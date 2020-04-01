package net.gudenau.discord.images.api.command;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;

/**
 * A command for simple image manipulations without arguments.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public abstract class SimpleImageCommand implements IImageCommand{
    /**
     * The name of the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private final String name;
    
    /**
     * The help string for the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private final String help;
    
    /**
     * The usage string for the command.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private final String usage;
    
    private SimpleImageCommand(@Nonnull String name, @Nonnull String help){
        this.name = name;
        this.help = help;
        this.usage = name + " [image]";
    }
    
    /**
     * Creates a simple image command.
     *
     * @param name The name of the command.
     * @param help The help string of the command.
     * @param function The callback for executing the command.
     *
     * @return The SimpleImageCommand.
     * */
    public static SimpleImageCommand create(@Nonnull String name, @Nonnull String help, @Nonnull Function<Image, Image> function){
        return new SimpleImageCommand(name, help){
            @Override
            Image execute(Image image){
                return function.apply(image);
            }
        };
    }
    
    /**
     * Creates a simple image command.
     *
     * @param name The name of the command.
     * @param help The help string of the command.
     * @param function The callback for executing the command.
     *
     * @return The SimpleImageCommand.
     * */
    public static SimpleImageCommand createBool(@Nonnull String name, @Nonnull String help, @Nonnull Function<Image, Boolean> function){
        return new SimpleImageCommand(name, help){
            @Override
            Image execute(Image image){
                if(function.apply(image)){
                    return Image.ReferenceImage(image);
                }else{
                    return null;
                }
            }
        };
    }
    
    /**
     * Creates a simple image command with GraphicsMagick exception handling.
     *
     * @param name The name of the command.
     * @param help The help string of the command.
     * @param function The callback for executing the command.
     *
     * @return The SimpleImageCommand.
     * */
    public static SimpleImageCommand create(@Nonnull String name, @Nonnull String help, @Nonnull BiFunction<Image, ExceptionInfo, Image> function){
        return new SimpleImageCommand(name, help){
            @Override
            Image execute(Image image){
                try(var exception = new ExceptionInfo()){
                    return exception.check(function.apply(image, exception));
                }
            }
        };
    }
    
    /**
     * Execute the command.
     *
     * @param image The image to process.
     * */
    @Nullable
    abstract Image execute(Image image);
    
    @Nonnull
    @Override
    public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        var result = execute(image);
        if(result == null){
            return Result.error("Failed to process image.");
        }else{
            try{
                return Result.image(result);
            }finally{
                Image.DestroyImage(result);
            }
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
        return usage;
    }
}
