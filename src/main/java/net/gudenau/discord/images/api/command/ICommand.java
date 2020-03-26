package net.gudenau.discord.images.api.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * The interface that all commands must implement.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface ICommand extends IMessageCommand{
    @Override
    @Nonnull
    default Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull Message message, @Nonnull List<String> arguments){
        return execute(channel, author, arguments);
    }
    
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
    Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments);
}
