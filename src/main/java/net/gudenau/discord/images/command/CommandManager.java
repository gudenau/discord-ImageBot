package net.gudenau.discord.images.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.DoubleCommand;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.ICommandManager;
import net.gudenau.discord.images.api.command.IMessageCommand;
import net.gudenau.discord.images.api.command.IPipeCommand;
import net.gudenau.discord.images.api.command.IntCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.api.command.SimpleImageCommand;
import net.gudenau.discord.images.magick.Effect;
import net.gudenau.discord.images.magick.Enhance;
import net.gudenau.discord.images.magick.Fx;
import net.gudenau.discord.images.magick.Image;
import net.gudenau.discord.images.magick.PixelPacket;
import net.gudenau.discord.images.magick.Shear;
import net.gudenau.discord.images.magick.Transform;

/**
 * The implementation of {@link ICommandManager ICommandManager}.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class CommandManager implements ICommandManager{
    /**
     * A command stub for the blacklist.
     *
     * @since 1.0.0
     * */
    private final ICommand BLACKLISTED_COMMAND = new ICommand(){
        @Nonnull
        @Override
        public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
            return Result.error("Unknown command");
        }
    
        @Nonnull
        @Override
        public String getName(){
            return "stubbyTheStubCommand";
        }
    
        @Nonnull
        @Override
        public String getHelp(){
            return "\uD83D\uDE43";
        }
    
        @Nonnull
        @Override
        public String getUsage(){
            return "\uD83D\uDE43";
        }
    };
    
    /**
     * The map of commands.
     *
     * @since 1.0.0
     * */
    private final Map<String, IMessageCommand> commands = new HashMap<>();
    
    /**
     * The map of aliases.
     *
     * @since 1.0.0
     * */
    private final Map<String, String> aliases = new HashMap<>();
    
    /**
     * Don't load commands with a name in this set.
     *
     * @since 1.0.0
     * */
    private final Set<String> blacklist;
    
    /**
     * Create's a new CommandManger with all the built in commands registered.
     *
     * @param blacklist A blacklist of command names.
     *
     * @since 1.0.0
     * */
    public CommandManager(Set<String> blacklist){
        this.blacklist = blacklist.stream().map(String::toLowerCase).collect(Collectors.toSet());
        
        registerCommands();
        registerAliases();
    }
    
    /**
     * Registers the default commands for the bot.
     *
     * @since 1.0.0
     * */
    private void registerCommands(){
        var readOnlyCommands = Collections.unmodifiableMap(commands);
        var readOnlyAliases = Collections.unmodifiableMap(aliases);
        
        register(
            new HelpCommand(this, readOnlyCommands, readOnlyAliases),
            new AliasCommand(this, readOnlyAliases),
            new AliasCommand.Get(this, readOnlyAliases),
            new DumpCommand(readOnlyCommands, readOnlyAliases)
        );
    
        register(
            new PrefixCommand.Clear(),
            new PrefixCommand.Set(),
            new PrefixCommand.Get()
        );
    
        register(
            new PluginCommand.Enumerate(),
            new PluginCommand.Info()
        );
    
        register(
            new TerminateCommand(),
            new EchoCommand(),
            new UpdateAvatarCommand()
        );
    
        register(new MessageCommand("invite", "Get's the URL to invite this bot!", "Thanks for the interest!\nhttps://discordapp.com/oauth2/authorize?client_id=532402004568440852&scope=bot&permissions=-1"));
    
        register(new AvatarCommand());
        register(new GuildCommand());
        register(new EmojiCommand());
    
        register(
            new RepostCommand(),
            DoubleCommand.create("charcoal", "Applies a charcoal effect", "[radius = 0] [sigma = 1]", 0, 1, Fx::CharcoalImage),
            DoubleCommand.create("oilPaint", "Makes the image look like it's a painting.", "[radius = 3]", 3, Fx::OilPaintImage),
            DoubleCommand.create("solarize", "Makes the image look like it was solarized.", "[threshold = 50]", 50, (image, threshold, exception)->{
                Fx.SolarizeImage(image, threshold);
                return Image.ReferenceImage(image);
            }),
            DoubleCommand.create("swirl", "Swirls an image.", "[amount = 45]", 45, (image, amount, exception)->{
                try(var color = new PixelPacket()){
                    color.red((byte)0);
                    color.green((byte)0);
                    color.blue((byte)0);
                    color.opacity((byte)255);
                    image.background_color(color);
                }
                return Fx.SwirlImage(image, amount, exception);
            }),
            DoubleCommand.create("wave", "Makes the image look like it's a flag.", "[amplitude = 25] [waveLength = 150]", 25, 150, (image, amplitude, wave_length, exception)->{
                try(var color = new PixelPacket()){
                    color.red((byte)0);
                    color.green((byte)0);
                    color.blue((byte)0);
                    color.opacity((byte)255);
                    image.background_color(color);
                }
                return Fx.WaveImage(image, amplitude, wave_length, exception);
            })
        );
    
        register(new AddNoiseCommand());
    
        register(
            DoubleCommand.create("blur", "Blurs an image.", "[radius = 0] [sigma = 1]", 0, 1, Effect::BlurImage),
            SimpleImageCommand.create("despeckle", "Despeckle an image.", Effect::DespeckleImage),
            DoubleCommand.create("edge", "Hightlight image edges", "[radius = 0]", 0, Effect::EdgeImage),
            DoubleCommand.create("emboss", "Embosses an image.", "[radius = 0] [sigma = 1]", 0, 1, Effect::EmbossImage),
            SimpleImageCommand.create("enhance", "Enhances an image.", Effect::EnhanceImage),
            DoubleCommand.create("sharpen", "Sharpens an image.", "[radius = 0] [sigma = 1]", 0, 1, Effect::SharpenImage),
            IntCommand.create("spread", "Spreads an image.", "[radius = 0]", 3, Effect::SpreadImage)
        );
    
        register(
            SimpleImageCommand.createBool("invert", "Inverts an image", (image)->Enhance.NegateImage(image, false))
        );
    
        register(
            DoubleCommand.create("rotate", "Rotates an image", "degrees", (image, degrees, exception)->{
                try(var color = new PixelPacket()){
                    color.red((byte)0);
                    color.green((byte)0);
                    color.blue((byte)0);
                    color.opacity((byte)255);
                    image.background_color(color);
                }
                return Shear.RotateImage(image, degrees, exception);
            })
        );
        
        register(
            new FlagCommand(),
            new SpinCommand()
        );
    
        register(new MetadataCommand());
        
        register(
            new WeirdMirror.Woow(),
            new WeirdMirror.Hooh(),
            new WeirdMirror.Waaw(),
            new WeirdMirror.Haah(),
            SimpleImageCommand.create("flip", "Mirrors an image on it's X-axis.", Transform::FlipImage),
            SimpleImageCommand.create("flop", "Mirrors an image on it's Y-axis.", Transform::FlopImage)
        );
        
        register(new InfoCommand());
        
        // Broken
        //register(new EyesCommand());
    }
    
    /**
     * Registers the default aliases for the bot.
     *
     * @since 1.0.0
     * */
    private void registerAliases(){
        registerAlias("e", "emoji");
        registerAlias("a", "avatar");
        registerAlias("g", "guild");
        registerAlias("i", "info");
        
        registerAlias("aliases", "alias");
        
        registerAlias("setPrefix", "prefix.set");
        registerAlias("getPrefix", "prefix.get");
        registerAlias("clearPrefix", "prefix.clear");
    
    
        registerAlias("listPlugins", "plugin.list");
        registerAlias("pluginInfo", "plugin.info");
    }
    
    @Override
    public void registerAlias(String name, String value){
        if(commands.containsKey(name.toLowerCase())){
            throw new IllegalArgumentException("Failed to register alias \"" + name + "\n, a command already registered it");
        }
        if(aliases.containsKey(name.toLowerCase())){
            throw new IllegalArgumentException("Failed to register alias \"" + name + "\n, already registered");
        }
        if(!commands.containsKey(value.toLowerCase())){
            throw new IllegalArgumentException("Command \"" + value + "\" does not exist");
        }
        aliases.put(name.toLowerCase(), value.toLowerCase());
    }
    
    @Override
    public void register(@Nonnull IMessageCommand command){
        String commandName = command.getName();
        String lowerName = commandName.toLowerCase();
        if(commands.containsKey(lowerName)){
            throw new IllegalArgumentException("Failed to register command \"" + commandName + "\", already registered");
        }
        if(blacklist.contains(lowerName)){
            commands.put(lowerName, BLACKLISTED_COMMAND);
        }else{
            commands.put(lowerName, command);
        }
    }
    
    @Override
    public void register(@Nonnull IMessageCommand... commands){
        for(IMessageCommand command : commands){
            register(command);
        }
    }
    
    /**
     * Chars for the little pipe animation.
     *
     * @since 1.0.0
     * */
    private static final String[] PIPE_ANIMATION = {
        "\uD83D\uDD5B", "\uD83D\uDD50", "\uD83D\uDD51", "\uD83D\uDD52",
        "\uD83D\uDD53", "\uD83D\uDD54", "\uD83D\uDD55", "\uD83D\uDD56",
        "\uD83D\uDD57", "\uD83D\uDD58", "\uD83D\uDD59", "\uD83D\uDD5A"
    };
    
    /**
     * Executes a command.
     *
     * @param message The message that invoked this command.
     * @param commandString The contents of the message with the prefix stripped out
     *
     * @since 1.0.0
     * */
    public void executeCommand(@Nonnull Message message, @Nonnull String commandString){
        try{
            var channel = message.getTextChannel();
            var author = message.getMember();
            assert author != null;
    
            // Throttle a touch and give the client a chance to see the typing message
            channel.sendTyping().complete();
            Thread.sleep(100);
    
            Result result = null;
            // Handle piping
            if(commandString.contains("|")){
                try{
                    // Split the command into segments
                    Message statusMessage = null;
                    int i = 0;
                    var commands = commandString.split("\\|");
                    
                    // Limit to 10 commands.
                    if(commands.length > 10){
                        Result.error("The pipe limit is 10 commands.")
                            .preparePost(channel, author).queue();
                        return;
                    }
                    
                    // Handle each segment
                    for(String command : commands){
                        i++; // Just for the user
                        if(command.isBlank()){
                            continue;
                        }
                        
                        Result lastResult = result;
                        try{
                            // Execute the next command
                            result = doExecuteCommand(message, command.trim(), result);
                            
                            // Result was not an image, bail out
                            if(!(result instanceof Result.IPipeResult)){
                                break;
                            }

                            // Update the progress message
                            if(statusMessage == null){
                                statusMessage = result.preparePost(channel, author).complete();
                            }else{
                                statusMessage.editMessage(
                                    new MessageBuilder()
                                        .setEmbed(
                                            new EmbedBuilder(statusMessage.getEmbeds().get(0))
                                                .setDescription(String.format("%d/%d\n%s", i, commands.length, PIPE_ANIMATION[i % PIPE_ANIMATION.length]))
                                                .build()
                                        )
                                        .build()
                                ).complete();
                            }
                        }finally{
                            if(lastResult != null){
                                // Free the last image
                                lastResult.cleanup();
                            }
                        }
    
                        channel.sendTyping().complete();
                        try{
                            // Throttle it a little bit
                            Thread.sleep(1000);
                        }catch(InterruptedException ignored){}
                    }
                    
                    // Delete the status message
                    if(statusMessage != null){
                        statusMessage.delete().complete();
                    }
                }catch(Throwable t){
                    t.printStackTrace();
                    Result.error(t.getMessage()).preparePost(channel, author).queue();
                }
            }else{
                // It's not a pipe
                result = doExecuteCommand(message, commandString, null);
            }
            
            // Post the result
            try{
                if(result == null){
                    result = Result.error("Failed to execute command");
                }
                result.preparePost(channel, author).queue();
            }finally{
                if(result != null){
                    result.cleanup();
                }
            }
        }catch(Throwable t){
            t.printStackTrace();
            //noinspection ConstantConditions
            Result.error("Failed to execute command. %s", t.getMessage()).preparePost(message.getTextChannel(), message.getMember()).queue();
        }
    }
    
    /**
     * Actually executes a command, this is after the piping is taken care of.
     *
     * @param message The message that invoked this command.
     * @param commandString The contents of the command
     * @param lastResult The result of the last command if piped
     *
     * @return The result of the command.
     *
     * @since 1.0.0
     * */
    @Nullable
    private Result doExecuteCommand(@Nonnull Message message, @Nonnull String commandString, @Nullable Result lastResult){
        var channel = message.getTextChannel();
        var author = message.getMember();
        assert author != null;
        
        List<String> args = splitCommand(commandString);
        if(args.isEmpty()){
            return lastResult;
        }
    
        String commandName = args.remove(0);
        IMessageCommand command = getCommand(commandName);
        
        if(command == null){
            String alias = aliases.get(commandName.toLowerCase());
            if(alias != null){
                command = getCommand(alias);
            }
        }
    
        if(command == null || !command.isAvailable(channel, author)){
            return Result.error("Unknown command \"%s\"", commandName);
        }else{
            try{
                if(lastResult != null){
                    if(command instanceof IPipeCommand && lastResult instanceof Result.IPipeResult){
                        Image lastImage = ((Result.IPipeResult)lastResult).getImage();
                        if(lastImage != null){
                            return ((IPipeCommand)command).execute(channel, author, args, lastImage);
                        }
                    }
                    return Result.error("Failed to pipe command");
                }else{
                    return command.execute(channel, author, message, args);
                }
            }catch(Throwable t){
                t.printStackTrace();
                return Result.error("Failed to execute command \"%s\"", commandName);
            }
        }
    }
    
    /**
     * Gets a command.
     *
     * @param name The name of the command.
     *
     * @return The command, or null.
     * */
    @Nullable
    IMessageCommand getCommand(@Nonnull String name){
        return commands.get(name.toLowerCase());
    }
    
    /**
     * Splits a command string into parts, respecting escapes and quotes.
     *
     * @param command The raw command string.
     *
     * @return The command string split into it's components.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private List<String> splitCommand(@Nonnull String command){
        List<String> segments = new ArrayList<>();
        
        var builder = new StringBuilder();
        var chars = command.toCharArray();
    
        char escapeChar = 0;
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(c == '\\' && i + 1 < chars.length){
                builder.append(chars[++i]);
                continue;
            }
            if(c == '\'' || c == '"'){
                if(escapeChar == 0){
                    if(i >= 1 && chars[i - 1] == ' '){
                        escapeChar = c;
                        continue;
                    }
                }else if(escapeChar == c && (i + 1 >= chars.length || chars[i + 1] == ' ')){
                    escapeChar = 0;
                    i++;
                    c = ' ';
                }
            }
            if(c == ' ' && escapeChar == 0){
                segments.add(builder.toString());
                builder.setLength(0);
                continue;
            }
            builder.append(c);
        }
        if(builder.length() > 0){
            segments.add(builder.toString());
        }
        
        return segments;
    }
}
