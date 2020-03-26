package net.gudenau.discord.images.plugin;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.JDA;
import net.gudenau.discord.images.api.command.ICommandManager;

/**
 * The interface plugins must implement.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface IPlugin{
    /**
     * Invoked when a plugin is loaded.
     *
     * @param commandManager The @{link ICommandManager command manager} used to register commands
     * */
    void onLoad(@Nonnull ICommandManager commandManager);
    /**
     * Invoked when the bot is ready to interact with Discord.
     *
     * @param jda The instance of JDA.
     * */
    default void onReady(@Nonnull JDA jda){}
}
