package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IImageCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Fx;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.ImageList;
import net.gudenau.discord.images.magick.PixelPacket;
import net.gudenau.discord.images.magick.Transform;

import static net.gudenau.discord.images.magick.Image.BackgroundDispose;

public class FlagCommand implements IImageCommand{
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
            
            int FRAME_DELAY = 8;
            
            int width = image.columns();
            int height = image.rows();
            
            int rollAmount = width / FRAME_COUNT;
            double wavelength = width / 2.0;
            double amplitude = height / 15.0;
            
            Image.Pointer list;
            {
                var initial = exception.check(Fx.WaveImage(image, amplitude, wavelength, exception));
                list = new Image.Pointer(initial);
            }
            
            for(int i = 1; i < FRAME_COUNT; i++){
                var rollA = exception.check(Transform.RollImage(image, rollAmount * i, 0, exception));
                var wave = exception.check(Fx.WaveImage(rollA, amplitude, wavelength, exception));
                var result = exception.check(Transform.RollImage(wave, -rollAmount * i, 0, exception));
                
                Image.DestroyImage(rollA);
                Image.DestroyImage(wave);
                
                ImageList.AppendImageToList(list, result);
            }
            
            var frame = list.getValue();
            var result = frame;
            while(frame != null){
                frame.dispose(BackgroundDispose);
                frame.delay(FRAME_DELAY);
                frame = ImageList.GetNextImageInList(frame);
            }
            
            return Result.image(result);
        }
    }
    
    @Override
    public boolean supportsAnimations(){
        return false;
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "flag";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Makes a static image wave like a flag.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "flag [image]";
    }
}
