package net.gudenau.discord.images.command;

import io.sentry.Sentry;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IImageCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.magick.Effect;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;

import static net.gudenau.discord.images.magick.Magick.*;

public class AddNoiseCommand implements IImageCommand{
    @Nonnull
    @Override
    public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        if(arguments.size() == 0 || arguments.size() > 2){
            return Result.help(this);
        }
        
        int type;
        switch(arguments.get(0).toLowerCase()){
            case "uniform": type = UniformNoise; break;
            case "gaussian": type = GaussianNoise; break;
            case "multiplicative": type = MultiplicativeGaussianNoise; break;
            case "impulse": type = ImpulseNoise; break;
            case "laplacian": type = LaplacianNoise; break;
            case "poisson": type = PoissonNoise; break;
            case "random": type = RandomNoise; break;
            default: return Result.help(this);
        }
        
        if(arguments.size() == 1){
            try(var exception = new ExceptionInfo()){
                return Result.image(exception.check(Effect.AddNoiseImage(image, type, exception)));
            }
        }
        
        int colorChannel;
        switch(arguments.get(1).toLowerCase()){
            case "red": colorChannel = RedChannel; break;
            case "green": colorChannel = GreenChannel; break;
            case "blue": colorChannel = BlueChannel; break;
            case "cyan": colorChannel = CyanChannel; break;
            case "magenta": colorChannel = MagentaChannel; break;
            case "yellow": colorChannel = YellowChannel; break;
            case "alpha": colorChannel = OpacityChannel; break;
            case "black": colorChannel = BlackChannel; break;
            case "all": colorChannel = AllChannels; break;
            case "gray": colorChannel = GrayChannel; break;
            default: return Result.help(this);
        }
        
        try(var exception = new ExceptionInfo()){
            return Result.image(exception.check(Effect.AddNoiseImageChannel(image, colorChannel, type, exception)));
        }
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "addNoise";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Makes an image more noisy";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "addNoise (image) (noise type) [channel = all]\n\n" +
            "Valid `noise type`s are:\n" +
            " > uniform\n" +
            " > gaussian\n" +
            " > multiplicative\n" +
            " > impulse\n" +
            " > laplacian\n" +
            " > poisson\n" +
            " > random\n\n" +
            "Valid `channel`s are:\n" +
            " > red\n" +
            " > green\n" +
            " > blue\n" +
            " > cyan\n" +
            " > magenta\n" +
            " > yellow\n" +
            " > alpha\n" +
            " > black\n" +
            " > all\n" +
            " > gray";
    }
}
