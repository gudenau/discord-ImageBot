package net.gudenau.discord.images.plugin;

import com.google.gson.annotations.Expose;
import java.nio.file.Path;
import java.util.Set;

/**
 * The metadata for plugins.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class PluginMetadata implements Comparable<PluginMetadata>{
    /**
     * The name of the plugin.
     *
     * @since 1.0.0
     * */
    @Expose private String name;
    
    /**
     * The id of the plugin.
     *
     * @since 1.0.0
     * */
    @Expose private String id;
    
    /**
     * The version of the plugin.
     *
     * @since 1.0.0
     * */
    @Expose private String version;
    
    /**
     * The authors of the plugin.
     *
     * @since 1.0.0
     * */
    @Expose private Set<String> authors;
    
    /**
     * The other plugin ids that this plugin depends on.
     *
     * @since 1.0.0
     * */
    @Expose private Set<String> requires;
    
    /**
     * The entry point of the plugin.
     *
     * @since 1.0.0
     * */
    @Expose private String entry;
    
    /**
     * The path to the plugin on disk.
     *
     * @since 1.0.0
     * */
    transient Path path;
    
    /**
     * The plugin's entry point class.
     *
     * @since 1.0.0
     * */
    transient Class<? extends IPlugin> entryClass;
    
    /**
     * The instance of the plugin.
     *
     * @since 1.0.0
     * */
    transient IPlugin instance;
    
    /**
     * Gets the name of the plugin.
     *
     * @return The plugin name.
     *
     * @since 1.0.0
     * */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the ID of the plugin.
     *
     * @return The ID of the plugin.
     *
     * @since 1.0.0
     * */
    public String getId(){
        return id;
    }
    
    /**
     * Gets the version of the plugin.
     *
     * @return The plugin version.
     *
     * @since 1.0.0
     * */
    public String getVersion(){
        return version;
    }
    
    /**
     * Gets the authors of the plugin.
     *
     * @return The plugin authors.
     *
     * @since 1.0.0
     * */
    public Set<String> getAuthors(){
        return authors;
    }
    
    /**
     * Gets the plugin's dependencies.
     *
     * @return The plugin's dependencies
     *
     * @since 1.0.0
     * */
    public Set<String> getRequires(){
        return requires;
    }
    
    @Override
    public int compareTo(@Nonnull PluginMetadata meta){
        if(requires.contains(meta.id)){
            return 1;
        }
        if(meta.requires.contains(id)){
            return -1;
        }
        return 0;
    }
    
    /**
     * Gets the entry point of the plugin.
     *
     * @return The plugin's entry point.
     *
     * @since 1.0.0
     * */
    public String getEntry(){
        return entry;
    }
}
