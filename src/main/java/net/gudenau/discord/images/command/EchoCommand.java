package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IMessageCommand;
import net.gudenau.discord.images.api.command.IOwnerCommand;
import net.gudenau.discord.images.api.command.Result;

/**
 * A simple echo command for the bot owner.
 *
 * Deletes the message that issued it if possible.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class EchoCommand implements IOwnerCommand, IMessageCommand{
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull Message message, @Nonnull List<String> arguments){
        if(!arguments.isEmpty()){
            Member selfMember = channel.getGuild().getSelfMember();
            if(
                selfMember.hasPermission(channel, Permission.MESSAGE_MANAGE) ||
                selfMember.hasPermission(channel, Permission.ADMINISTRATOR)
            ){
                message.delete().queue();
            }
            StringBuilder builder = new StringBuilder();
            for(String argument : arguments){
                builder.append(argument).append(" ");
            }
            builder.setLength(builder.length() - 1);
            return Result.success(builder.toString());
        }else{
            return Result.help(this);
        }
    }
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
        return Result.error("Should not be reached.");
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "echo";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Echo a message.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "echo (message)";
    }
}
