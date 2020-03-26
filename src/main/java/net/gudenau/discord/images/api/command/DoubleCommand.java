package net.gudenau.discord.images.api.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.util.QuadFunction;
import net.gudenau.discord.images.api.util.TriFunction;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;

public abstract class DoubleCommand implements IImageCommand{
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
    
    private DoubleCommand(@Nonnull String name, @Nonnull String help, @Nonnull String usage){
        this.name = name;
        this.help = help;
        this.usage = (name + " [image] " + usage.trim()).trim();
    }
    
    /**
     * Creates a command tha takes a double parameter.
     *
     * @param name The name of the command.
     * @param help The help of the command.
     * @param usage The usage of the command.
     * @param defaultDouble The default value of the double.
     * @param function The callback for the command.
     *
     * @return The DoubleCommand.
     * */
    public static DoubleCommand create(@Nonnull String name, @Nonnull String help, @Nonnull String usage, double defaultDouble, @Nonnull TriFunction<Image, Double, ExceptionInfo, Image> function){
        return new DoubleCommand(name, help, usage){
            @Override
            @Nonnull
            Result execute(@Nonnull Image image, @Nonnull List<String> params){
                if(params.size() > 1){
                    return Result.help(this);
                }
                
                double double1;
                if(params.size() >= 1){
                    double1 = Double.parseDouble(params.get(0));
                }else{
                    double1 = defaultDouble;
                }
    
                try(var exception = new ExceptionInfo()){
                    var newImage = function.invoke(image, double1, exception);
                    try{
                        return Result.image(newImage);
                    }finally{
                        Image.DestroyImage(newImage);
                    }
                }
            }
        };
    }
    
    /**
     * Creates a command tha takes a double parameter.
     *
     * @param name The name of the command.
     * @param help The help of the command.
     * @param usage The usage of the command.
     * @param function The callback for the command.
     *
     * @return The DoubleCommand.
     * */
    public static DoubleCommand create(@Nonnull String name, @Nonnull String help, @Nonnull String usage, @Nonnull TriFunction<Image, Double, ExceptionInfo, Image> function){
        return new DoubleCommand(name, help, usage){
            @Override
            @Nonnull
            Result execute(@Nonnull Image image, @Nonnull List<String> params){
                if(params.size() > 1){
                    return Result.help(this);
                }
                
                double double1;
                if(params.size() >= 1){
                    double1 = Double.parseDouble(params.get(0));
                }else{
                    return Result.help(this);
                }
                
                try(var exception = new ExceptionInfo()){
                    var newImage = function.invoke(image, double1, exception);
                    try{
                        return Result.image(newImage);
                    }finally{
                        Image.DestroyImage(newImage);
                    }
                }
            }
        };
    }
    
    /**
     * Creates a command tha takes two double parameters.
     *
     * @param name The name of the command.
     * @param help The help of the command.
     * @param usage The usage of the command.
     * @param defaultDouble1 The default value of the first double.
     * @param defaultDouble2 The default value of the second double.
     * @param function The callback for the command.
     *
     * @return The DoubleCommand.
     * */
    public static DoubleCommand create(@Nonnull String name, @Nonnull String help, @Nonnull String usage, double defaultDouble1, double defaultDouble2, @Nonnull QuadFunction<Image, Double, Double, ExceptionInfo, Image> function){
        return new DoubleCommand(name, help, usage){
            @Override
            @Nonnull
            Result execute(@Nonnull Image image, @Nonnull List<String> params){
                if(params.size() > 2){
                    return Result.help(this);
                }
                
                double double1;
                if(params.size() >= 1){
                    double1 = Double.parseDouble(params.get(0));
                }else{
                    double1 = defaultDouble1;
                }
                
                double double2;
                if(params.size() >= 2){
                    double2 = Double.parseDouble(params.get(1));
                }else{
                    double2 = defaultDouble2;
                }
                
                try(var exception = new ExceptionInfo()){
                    var newImage = function.invoke(image, double1, double2, exception);
                    try{
                        return Result.image(newImage);
                    }finally{
                        Image.DestroyImage(newImage);
                    }
                }
            }
        };
    }
    
    /**
     * Execute the command.
     *
     * @param image The image to process.
     * @param args The arguments of the command.
     *
     * @return The result of the command.
     * */
    @Nonnull
    abstract Result execute(@Nonnull Image image, @Nonnull List<String> args);
    
    @Nonnull
    @Override
    public Result process(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments, @Nonnull Image image){
        return execute(image, arguments);
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
