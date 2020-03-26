package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IAdminCommand;
import net.gudenau.discord.images.api.command.IImageCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.magick.Image;

public class RepostCommand implements IAdminCommand, IImageCommand{
    @Nonnull
    @Override
    public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        if(!arguments.isEmpty()){
            return Result.help(this);
        }
        return Result.image(Image.ReferenceImage(image));
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "repost";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Reposts an image.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "repost [image]";
    }
}
