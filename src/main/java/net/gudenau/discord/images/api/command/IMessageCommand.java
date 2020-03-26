package net.gudenau.discord.images.api.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Provides an interface for accessing the message that was responsible for invoking the command.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface IMessageCommand {
    /**
     * Execute the command.
     *
     * @param channel The channel the command was issued in.
     * @param author The member that issued the command.
     * @param arguments The arguments to the command.
     *
     * @return The result of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull Message message, @Nonnull List<String> arguments);
    
    /**
     * Get's the name of the command.
     *
     * @return The command name.
     *
     * @since 1.0.0
     * */
    @Nonnull
    String getName();
    
    /**
     * Get's a short description of what this command does.
     *
     * @return A short description of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    String getHelp();
    
    /**
     * Get's the usage string of the command.
     *
     * @return The usage string of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    String getUsage();
    
    /**
     * Allows commands to be hidden.
     *
     * @param channel The channel the command was issued in.
     * @param author The member that issued the command.
     *
     * @return Whether or not the command should be shown.
     *
     * @since 1.0.0
     * */
    default boolean isAvailable(@Nonnull TextChannel channel, @Nonnull Member author){
        return true;
    }
}
