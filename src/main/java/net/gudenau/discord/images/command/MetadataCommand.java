package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IImageCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.ImageList;

public class MetadataCommand implements IImageCommand{
    @Nonnull
    @Override
    public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        StringBuilder builder = new StringBuilder();
        
        builder.append("Type: ").append(image.magick()).append('\n');
        builder.append("Height: ").append(image.columns()).append('\n');
        builder.append("Width: ").append(image.rows()).append('\n');
        int frameCount = (int)ImageList.GetImageListLength(image);
        if(frameCount > 1){
            builder.append("Frames: ").append(frameCount).append('\n');
            builder.append("Delays:\n");
            
            var frame = image;
            int i = 0;
            do{
                builder.append(++i).append(": ").append(frame.delay()).append('\n');
                frame = ImageList.GetNextImageInList(frame);
            }while(frame != null);
        }
        
        return Result.success(builder.toString());
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "meta";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Gets image metadata.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "meta [image]";
    }
}
