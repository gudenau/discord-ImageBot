package net.gudenau.discord.images.api.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.magick.Image;

/**
 * How piping is implemented, provides the image from the last command executed.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface IPipeCommand{
    /**
     * Execute the command.
     *
     * @param channel The channel the command was issued in.
     * @param author The member that issued the command.
     * @param arguments The arguments to the command.
     * @param image The Image from the last command.
     *
     * @return The result of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image);
}
