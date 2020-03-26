package net.gudenau.discord.images.plugin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.gudenau.discord.images.api.command.ICommandManager;
import net.gudenau.discord.images.util.Json;
import net.gudenau.discord.images.util.MiscUtil;

/**
 * Loads plugins and keeps references to them.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class PluginLoader{
    /**
     * The pattern for all valid ids.
     *
     * @since 1.0.0
     * */
    private static final Pattern PATTERN_ID = Pattern.compile("^[0-9a-z_]+$");
    
    /**
     * A list of all plugins.
     *
     * @since 1.0.0
     * */
    private static List<PluginMetadata> plugins;
    
    /**
     * Load the plugins.
     *
     * @param commandManager The {@link ICommandManager command manager} to use.
     * */
    public static void loadPlugins(@Nonnull ICommandManager commandManager){
        try{
            Path pluginDir = Path.of("plugins");
            if(!Files.exists(pluginDir)){
                Files.createDirectories(pluginDir);
            }
            
            var pluginJarCandidates = Files.list(pluginDir)
                .filter(Files::isRegularFile)
                .filter((file)->file.getFileName().toString().endsWith(".jar"))
                .collect(Collectors.toSet());
    
            List<PluginMetadata> pluginMetadata = new ArrayList<>();
            
            for(Path candidate : pluginJarCandidates){
                try(JarFile jarFile = new JarFile(candidate.toFile())){
                    JarEntry entry = jarFile.getJarEntry("plugin.json");
                    if(entry == null){
                        continue;
                    }
                    PluginMetadata metadata;
                    try(var input = jarFile.getInputStream(entry)){
                        metadata = Json.read(input, PluginMetadata.class);
                    }
                    if(!PATTERN_ID.matcher(metadata.getId()).matches()){
                        throw new RuntimeException(String.format(
                            "Plugin %s (%s) has a bad id!",
                            metadata.getName(),
                            metadata.getId()
                        ));
                    }
                    metadata.path = candidate;
                    pluginMetadata.add(metadata);
                }
            }
            
            for(var plugin : pluginMetadata){
                for(String require : plugin.getRequires()){
                    boolean found = false;
                    for(var plugin2 : pluginMetadata){
                        if(plugin2.getId().equals(require)){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        throw new RuntimeException(String.format(
                            "Plugin %s (%s) requires %s but it was not found",
                            plugin.getName(),
                            plugin.getId(),
                            require
                        ));
                    }
                }
            }
            
            Collections.sort(pluginMetadata);
    
            var pluginClassLoader = new PluginClassLoader(PluginLoader.class.getClassLoader());
            
            for(PluginMetadata metadata : pluginMetadata){
                pluginClassLoader.addURL(metadata.path.toUri().toURL());
                //noinspection unchecked
                metadata.entryClass = (Class<? extends IPlugin>)pluginClassLoader.loadClass(metadata.getEntry());
                var constructor = metadata.entryClass.getDeclaredConstructor();
                constructor.setAccessible(true);
                metadata.instance = constructor.newInstance();
                metadata.instance.onLoad(commandManager);
            }
            
            plugins = Collections.unmodifiableList(pluginMetadata);
        }catch(IOException | ReflectiveOperationException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Invoked when the the bot is read.
     *
     * @param jda The JDA instance
     *
     * @since 1.0.0
     * */
    public static void onReady(@Nonnull JDA jda){
        plugins.stream()
            .map((plugin)->((Runnable)()->plugin.instance.onReady(jda)))
            .forEach(MiscUtil::runLater);
    }
    
    /**
     * Gets a list of all loaded plugins.
     *
     * @return Loaded plugins.
     *
     * @since 1.0.0
     * */
    @Nonnull
    public static List<PluginMetadata> getPlugins(){
        return plugins;
    }
    
    /**
     * Finds a plugin by id.
     *
     * @param id The id of the plugin.
     *
     * @return The plugin or null.
     *
     * @since 1.0.0
     * */
    @Nullable
    public static PluginMetadata getPlugin(@Nonnull String id){
        return plugins.stream()
            .filter((plugin)->plugin.getId().equals(id))
            .findAny()
            .orElse(null);
    }
}
