package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.DiscordImages;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.Result;

public class InfoCommand implements ICommand{
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
        if(!arguments.isEmpty()){
            return Result.help(this);
        }
        
        return Result.success(
            "Created by gudenau\n" +
            "Issues: https://github.com/gudenau/discord-ImageBot/issues\n" +
            "Help: https://todo\n" +
            "Version: " + DiscordImages.BOT_VERSION
        );
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "info";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Gets some info about the bot.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "info";
    }
}
