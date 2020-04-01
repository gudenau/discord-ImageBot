package net.gudenau.discord.images;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.sentry.Sentry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.AnnotatedEventManager;
import net.gudenau.discord.images.command.CommandManager;
import net.gudenau.discord.images.listener.CommandListener;
import net.gudenau.discord.images.listener.ReadyListener;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Magick;
import net.gudenau.discord.images.plugin.PluginLoader;
import net.gudenau.discord.images.util.Json;
import net.gudenau.discord.images.util.Natives;

import static net.gudenau.discord.images.magick.Magick.MAGICK_OPT_NO_SIGNAL_HANDER;

/**
 * The entry point.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class DiscordImages{
    public static final String BOT_VERSION = "1.0.1";
    
    public static void main(String[] arguments){
        Natives.loadNatives();
        
        Settings settings;
        try(var reader = Files.newBufferedReader(Path.of("settings.json"))){
            settings = Json.read(reader, Settings.class);
        }catch(IOException e){
            throw new RuntimeException("Failed to read settings.json", e);
        }
        
        Sentry.init(settings.sentry);
        Thread.UncaughtExceptionHandler exceptionHandler = (thread, throwable)->{
            Sentry.getContext().addTag("thread", thread.getName());
            Sentry.capture(throwable);
        };
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
        Thread.getAllStackTraces().keySet().forEach((thread)->{
            if(thread.getUncaughtExceptionHandler() != null){
                thread.setUncaughtExceptionHandler(exceptionHandler);
            }
        });
    
        try(var exception = new ExceptionInfo()){
            Magick.InitializeMagickEx(
                System.getProperty("java.home") + "/bin/java",
                MAGICK_OPT_NO_SIGNAL_HANDER,
                exception
            );
            if(exception.severity() == 0){
                throw exception.createException();
            }
        }
    
        CommandManager commandManager = new CommandManager(settings.commandBlacklist);
        
        if(settings.loadPlugins){
            PluginLoader.loadPlugins(commandManager);
        }
        
        var builder = new JDABuilder(settings.token);
        builder.setActivity(Activity.playing("@ImageBot help"));
        builder.setEventManager(new AnnotatedEventManager());
        builder.addEventListeners(
            new CommandListener(commandManager),
            new ReadyListener()
        );
        try{
            builder.build();
        }catch(LoginException e){
            System.err.println("Failed to create bot");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    @SuppressWarnings("unused")
    private static class Settings{
        @Expose private String token;
        @SerializedName("load_plugins")
        @Expose private boolean loadPlugins;
        @SerializedName("command_blacklist")
        @Expose private Set<String> commandBlacklist;
        @Expose private String sentry;
    }
}
