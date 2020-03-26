package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IImageCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.ImageList;
import net.gudenau.discord.images.magick.PixelPacket;
import net.gudenau.discord.images.magick.Shear;

import static net.gudenau.discord.images.magick.Image.BackgroundDispose;

public class SpinCommand implements IImageCommand{
    private static final int FRAME_COUNT = 20;
    
    @Nonnull
    @Override
    public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        try(var color = new PixelPacket()){
            color.red((byte)0);
            color.green((byte)0);
            color.blue((byte)0);
            color.opacity((byte)255);
            image.background_color(color);
        }
        
        try(var exception = new ExceptionInfo()){
            image.dispose(BackgroundDispose);
            Image.ReferenceImage(image);
            var list = new Image.Pointer(image);
            
            int maxWidth = -1;
            int maxHeight = -1;
            
            int FRAME_DELAY = 5;
            
            for(int i = 1; i < FRAME_COUNT; i++){
                var result = Shear.RotateImage(image, i * (360F / FRAME_COUNT), exception);
                
                int width = result.columns();
                int height = result.rows();
                
                if(width > maxWidth){
                    maxWidth = width;
                }
                if(height > maxHeight){
                    maxHeight = height;
                }
                
                ImageList.AppendImageToList(list, result);
            }
            
            var frame = list.getValue();
            while(frame != null){
                int width = frame.columns();
                int height = frame.rows();
                
                var page = frame.page();
                page.width(maxWidth);
                page.height(maxHeight);
                page.x((maxWidth - width) >> 1);
                page.y((maxHeight - height) >> 1);
    
                frame.dispose(BackgroundDispose);
                frame.delay(FRAME_DELAY);
                
                frame = ImageList.GetNextImageInList(frame);
            }
            
            return Result.image(list.getValue());
        }
    }
    
    @Override
    public boolean supportsAnimations(){
        return false;
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "spin";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Makes a static image spin";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "spin [image]";
    }
}
