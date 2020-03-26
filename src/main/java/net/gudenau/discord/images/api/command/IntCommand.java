package net.gudenau.discord.images.api.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.util.QuadFunction;
import net.gudenau.discord.images.api.util.TriFunction;
import net.gudenau.discord.images.magick.ExceptionInfo;
import net.gudenau.discord.images.magick.Image;

public abstract class IntCommand implements IImageCommand{
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
    
    private IntCommand(@Nonnull String name, @Nonnull String help, @Nonnull String usage){
        this.name = name;
        this.help = help;
        this.usage = (name + " [image] " + usage.trim()).trim();
    }
    
    /**
     * Creates a command tha takes a int parameter.
     *
     * @param name The name of the command.
     * @param help The help of the command.
     * @param usage The usage of the command.
     * @param defaultInt The default value of the int.
     * @param function The callback for the command.
     *
     * @return The IntCommand.
     * */
    public static IntCommand create(@Nonnull String name, @Nonnull String help, @Nonnull String usage, int defaultInt, @Nonnull TriFunction<Image, Integer, ExceptionInfo, Image> function){
        return new IntCommand(name, help, usage){
            @Override
            @Nonnull
            Result execute(@Nonnull Image image, @Nonnull List<String> params){
                if(params.size() > 1){
                    return Result.help(this);
                }
                
                int int1;
                if(params.size() >= 1){
                    int1 = Integer.parseInt(params.get(0));
                }else{
                    int1 = defaultInt;
                }
    
                try(var exception = new ExceptionInfo()){
                    var newImage = function.invoke(image, int1, exception);
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
     * Creates a command tha takes two int parameters.
     *
     * @param name The name of the command.
     * @param help The help of the command.
     * @param usage The usage of the command.
     * @param defaultInt1 The default value of the first int.
     * @param defaultInt2 The default value of the second int.
     * @param function The callback for the command.
     *
     * @return The IntCommand.
     * */
    public static IntCommand create(@Nonnull String name, @Nonnull String help, @Nonnull String usage, int defaultInt1, int defaultInt2, @Nonnull QuadFunction<Image, Integer, Integer, ExceptionInfo, Image> function){
        return new IntCommand(name, help, usage){
            @Override
            @Nonnull
            Result execute(@Nonnull Image image, @Nonnull List<String> params){
                if(params.size() > 2){
                    return Result.help(this);
                }
                
                int int1;
                if(params.size() >= 1){
                    int1 = Integer.parseInt(params.get(0));
                }else{
                    int1 = defaultInt1;
                }
                
                int int2;
                if(params.size() >= 2){
                    int2 = Integer.parseInt(params.get(1));
                }else{
                    int2 = defaultInt2;
                }
                
                try(var exception = new ExceptionInfo()){
                    var newImage = function.invoke(image, int1, int2, exception);
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
