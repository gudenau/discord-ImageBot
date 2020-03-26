package net.gudenau.discord.images.api.command;

import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * Provides an easy interface for implementing a command that only guild admins can use.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface IAdminCommand extends ICommand{
    @Override
    default boolean isAvailable(@Nonnull TextChannel channel, @Nonnull Member author){
        return author.hasPermission(Permission.ADMINISTRATOR) || channel.getGuild().getOwnerId().equals(author.getId());
    }
}
