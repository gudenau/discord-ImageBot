package net.gudenau.discord.images.command;

import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.Result;

/**
 * Gets the avatar of a guild member.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class AvatarCommand implements ICommand{
    /**
     * A pattern to match pings.
     *
     * @since 1.0.0
     * */
    private static final Pattern PATTERN_PING = Pattern.compile("<@!?([0-9]+)>");
    /**
     * A pattern to match snowflake IDs.
     *
     * @since 1.0.0
     * */
    private static final Pattern PATTERN_ID = Pattern.compile("^[0-9]+$");
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
        if(arguments.isEmpty()){
            // Get the issuer's avatar
            return Result.image(author.getUser().getEffectiveAvatarUrl(), "%s's avatar", author.getEffectiveName());
        }else if(arguments.size() == 1){
            Member member = null;
            var guild = channel.getGuild();
            
            String argument = arguments.get(0);
            var matcher = PATTERN_PING.matcher(argument);
            
            if(matcher.find()){
                member = guild.getMemberById(matcher.group(1));
            }else{
                if(PATTERN_ID.matcher(argument).find()){
                    member = guild.getMemberById(argument);
                }
                if(member == null){
                    var members = guild.getMembersByEffectiveName(argument.toLowerCase(), true);
                    if(members.isEmpty()){
                        members = guild.getMembersByName(argument.toLowerCase(), true);
                    }
                    member = members.isEmpty() ? null : members.get(0);
                }
            }
            
            if(member == null){
                return Result.error("Failed to find user %s", argument);
            }else{
                return Result.image(member.getUser().getEffectiveAvatarUrl());
            }
        }else{
            return Result.help(this);
        }
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "avatar";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Gets a user's avatar";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "avatar [uid | name]";
    }
}
