package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IOwnerCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.util.MiscUtil;

/**
 * Terminates the bot.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class TerminateCommand implements IOwnerCommand{
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
        MiscUtil.runLater(()->{
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ignored){}
            System.exit(0);
        });
        return Result.success("Goodbye world!");
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "terminate";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Terminates the bot";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "terminate";
    }
}
