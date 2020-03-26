package net.gudenau.discord.images.api.command;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.util.DiscordUtil;

/**
 * A continent way to implement a command that is only available to the bot owner.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface IOwnerCommand extends ICommand{
    @Override
    default boolean isAvailable(@Nonnull TextChannel channel, @Nonnull Member author){
        return DiscordUtil.isOwner(author.getUser());
    }
}
