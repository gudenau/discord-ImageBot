package net.gudenau.discord.images.api.command;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.ImageList;
import net.gudenau.discord.images.util.DiscordUtil;
import net.gudenau.discord.images.util.ImageUtil;

/**
 * A command that processes images.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface IImageCommand extends ICommand, IPipeCommand{
    default boolean supportsAnimations(){ return true; }
    
    @Nonnull
    @Override
    default Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
        URL url = null;
        if(!arguments.isEmpty()){
            String argument = arguments.get(0);
            try{
                url = new URL(argument);
                arguments.remove(0);
            }catch(MalformedURLException e){
                url = null;
            }
        }
        if(url == null){
            String lastUrl = DiscordUtil.getLastImage(channel);
            if(lastUrl == null){
                url = null;
            }else{
                try{
                    url = new URL(lastUrl);
                }catch(MalformedURLException e){
                    return Result.error("Discord provided a malformed URL");
                }
            }
        }
        if(url == null){
            return Result.error("Failed to locate image.");
        }
        Image image = ImageUtil.downloadImage(url);
        if(image == null){
            return Result.error("Failed to download image.");
        }
        return execute(channel, author, arguments, image);
    }
    
    @Nonnull
    @Override
    default Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        // Not an animation, just return it
        if(ImageList.GetImageListLength(image) == 1){
            return process(channel, author, arguments, image);
        }
    
        if(!supportsAnimations()){
            return Result.error("Image is animated, only still images are supported.");
        }
        
        // We know we have at least 2 frames
        
        // Get the initial frame
        Result stepResult = process(channel, author, arguments, image);
        if(!(stepResult instanceof Result.IPipeResult)){
            return stepResult;
        }
        
        // Setup the data structures
        Image listImage = ImageList.GetNextImageInList(image);
        Image resultImage = ((Result.IPipeResult)stepResult).getImage();
        try(Image.Pointer imageList = new Image.Pointer(resultImage)){
            
            // Iterate over all the frames.
            while(listImage != null){
                stepResult = process(channel, author, arguments, listImage);
                
                // Woops, encountered an error. Free everything.
                if(!(stepResult instanceof Result.IPipeResult)){
                    Image freeImage = imageList.getValue();
                    while(freeImage != null){
                        Image nextImage = ImageList.GetNextImageInList(freeImage);
                        Image.DestroyImage(freeImage);
                        freeImage = nextImage;
                    }
                    return stepResult;
                }
                // Get the result
                resultImage = ((Result.IPipeResult)stepResult).getImage();
                // Another error case...
                if(resultImage == null){
                    Image freeImage = imageList.getValue();
                    while(freeImage != null){
                        Image nextImage = ImageList.GetNextImageInList(freeImage);
                        Image.DestroyImage(freeImage);
                        freeImage = nextImage;
                    }
                    return Result.error("An error occurred while processing the animation.");
                }
                // Append it to the list and move on.
                ImageList.AppendImageToList(imageList, resultImage);
                listImage = ImageList.GetNextImageInList(listImage);
            }
            return Result.image(imageList.getValue());
        }
    }
    
    /**
     * Process an image.
     *
     * Automatically called for each frame in an animation.
     *
     * @param channel The channel the command was issued in.
     * @param author The member that issued the command.
     * @param arguments The arguments to the command.
     * @param image The Image from the last command.
     *
     * @return The result of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image);
}
