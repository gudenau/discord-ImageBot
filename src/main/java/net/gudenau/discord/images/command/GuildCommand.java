package net.gudenau.discord.images.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.Result;

/**
 * Get's some info about the current guild.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class GuildCommand implements ICommand{
    /**
     * Formatting for the creation date.
     *
     * @since 1.0.0
     * */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/YYYY hh:mm:ssa", Locale.ENGLISH);
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
        if(arguments.isEmpty()){
            var guild = channel.getGuild();
            var id = guild.getIdLong();
            long time = (id >> 22) + 1420070400000L;
            
            Date date = new Date(time);
            
            return Result.image(
                guild.getIconUrl(),
                "Guild: %s\nCreated on: %s\nMember count: %d\nOnline count: %d\nRole count: %d",
                guild.getName(),
                DATE_FORMAT.format(date),
                guild.getMemberCache().size(),
                guild.getMemberCache().stream()
                    .filter((member)->member.getOnlineStatus() != OnlineStatus.OFFLINE)
                    .count(),
                guild.getRoles().size()
            );
        }else{
            return Result.help(this);
        }
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "guild";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Get's info on the current guild.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "guild";
    }
}
