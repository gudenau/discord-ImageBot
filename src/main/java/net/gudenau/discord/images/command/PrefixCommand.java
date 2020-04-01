package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IAdminCommand;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.util.MiscUtil;

/**
 * Commands related to setting the prefix for the bot in a guild.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class PrefixCommand{
    /**
     * Removes the prefix from the current guild.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    public static class Clear implements IAdminCommand{
        @Nonnull
        @Override
        public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
            if(!arguments.isEmpty()){
                return Result.help(this);
            }
            
            var settings = MiscUtil.getGuildSettings(channel.getGuild());
            if(settings.prefix != null){
                settings.prefix = null;
                MiscUtil.saveGuildSettings(settings);
            }
            return Result.success("Successfully removed prefix!");
        }
        
        @Nonnull
        @Override
        public String getName(){
            return "prefix.clear";
        }
        
        @Nonnull
        @Override
        public String getHelp(){
            return "Removes the current prefix from the current guild.";
        }
        
        @Nonnull
        @Override
        public String getUsage(){
            return "prefix.clear";
        }
    }
    
    /**
     * Sets the prefix for the current guild.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    public static class Set implements IAdminCommand{
        @Nonnull
        @Override
        public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
            if(arguments.size() != 1){
                return Result.help(this);
            }
            
            var settings = MiscUtil.getGuildSettings(channel.getGuild());
            String prefix = arguments.get(0).trim();
            if(prefix.isBlank()){
                prefix = null;
            }
            if(settings.prefix != null && settings.prefix.equals(prefix) || prefix == null){
                return Result.success("Successfully updated prefix to \"%s\"!", prefix);
            }
            settings.prefix = prefix;
            MiscUtil.saveGuildSettings(settings);
            return Result.success("Successfully updated prefix to \"%s\"!", prefix);
        }
        
        @Nonnull
        @Override
        public String getName(){
            return "prefix.set";
        }
        
        @Nonnull
        @Override
        public String getHelp(){
            return "Sets the prefix for the current guild.";
        }
        
        @Nonnull
        @Override
        public String getUsage(){
            return "prefix.set (new prefix)";
        }
    }
    
    public static class Get implements ICommand{
        @Nonnull
        @Override
        public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
            if(arguments.isEmpty()){
                var prefix = MiscUtil.getGuildSettings(channel.getGuild()).prefix;
                if(prefix == null){
                    return Result.success("The guild has not set a prefix.");
                }else{
                    return Result.success("Current prefix: \"%s\"", prefix);
                }
            }else{
                return Result.help(this);
            }
        }
        
        @Nonnull
        @Override
        public String getName(){
            return "prefix.get";
        }
        
        @Nonnull
        @Override
        public String getHelp(){
            return "Gets the current prefix in the guild.";
        }
        
        @Nonnull
        @Override
        public String getUsage(){
            return "prefix.get";
        }
    }
}
