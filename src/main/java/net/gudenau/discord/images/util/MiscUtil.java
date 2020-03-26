package net.gudenau.discord.images.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Guild;

/**
 * Some misc stuff.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class MiscUtil{
    /**
     * The global thread pool, uses double the thread count of the machine.
     *
     * @since 1.0.0
     * */
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() << 1);
    
    /**
     * Run something later.
     *
     * @param runnable The runnable to run later.
     *
     * @since 1.0.0
     * */
    public static void runLater(@Nonnull Runnable runnable){
        THREAD_POOL.submit(runnable);
    }
    
    /**
     * Per-guild setting map.
     *
     * @since 1.0.0
     * */
    private static final Map<Guild, GuildSettings> GUILD_SETTINGS = new HashMap<>();
    
    /**
     * Gets the settings for a guild, loads them if needed.
     *
     * @param guild The guild to load settings for.
     *
     * @return The guild settings.
     * */
    @Nonnull
    public static GuildSettings getGuildSettings(@Nonnull Guild guild){
        synchronized(GUILD_SETTINGS){
            return GUILD_SETTINGS.computeIfAbsent(guild, MiscUtil::loadGuildSettings);
        }
    }
    
    /**
     * Actually load the guild settings.
     *
     * @param guild The guilt to load settings for.
     *
     * @return The read settings.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private static GuildSettings loadGuildSettings(@Nonnull Guild guild){
        try{
            Path settingDir = Path.of(".", "settings", "guild");
            if(!Files.exists(settingDir)){
                Files.createDirectories(settingDir);
            }
            Path settingsFile = settingDir.resolve(guild.getId());
            GuildSettings settings;
            if(Files.exists(settingsFile)){
                try(var reader = Files.newBufferedReader(settingsFile)){
                    settings = Json.read(reader, GuildSettings.class);
                }
            }else{
                settings = new GuildSettings();
            }
            settings.guild = guild;
            return settings;
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Save guild settings.
     *
     * Note: This does not check for modification.
     *
     * @param settings The settings to save.
     *
     * @since 1.0.0
     * */
    public static void saveGuildSettings(@Nonnull GuildSettings settings){
        try{
            Path settingDir = Path.of(".", "settings", "guild");
            if(!Files.exists(settingDir)){
                Files.createDirectories(settingDir);
            }
            Path settingsFile = settingDir.resolve(settings.guild.getId());
            try(var writer = Files.newBufferedWriter(settingsFile)){
                Json.write(writer, settings);
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
