package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.Result;

/**
 * A simple command that prints a message.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class MessageCommand implements ICommand{
    /**
     * The name of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private final String name;
    
    /**
     * The help string of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private final String help;
    
    /**
     * The message of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private final String message;
    
    public MessageCommand(@Nonnull String name, @Nonnull String help, @Nonnull String message){
        this.name = name;
        this.help = help;
        this.message = message;
    }
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
        if(arguments.isEmpty()){
            return Result.success(message);
        }else{
            return Result.help(this);
        }
    }
    
    @Nonnull
    @Override
    public String getName(){
        return name;
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return help;
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return name;
    }
}
