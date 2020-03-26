package net.gudenau.discord.images.listener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;
import net.gudenau.discord.images.command.CommandManager;
import net.gudenau.discord.images.util.MiscUtil;

/**
 * Listens for commands and dispatches them to the command manager.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class CommandListener{
    /**
     * The command manager instance.
     *
     * @since 1.0.0
     * */
    @Nonnull
    private final CommandManager commandManager;
    
    /**
     * The regex for when users ping the bot.
     *
     * @since 1.0.0
     * */
    private volatile Pattern pingPattern;
    
    public CommandListener(@Nonnull CommandManager commandManager){
        this.commandManager = commandManager;
    }
    
    /**
     * Updates the ping prefix.
     *
     * @param event The event that triggered it
     *
     * @since 1.0.0
     * */
    @SubscribeEvent
    public void onReady(@Nonnull ReadyEvent event){
        pingPattern = Pattern.compile("^<@!?" + event.getJDA().getSelfUser().getId() + "+>\\s*([\\s\\S]+)$");
    }
    
    /**
     * Handles commands.
     *
     * @param event An event that contains a message that may contain a command.
     *
     * @since 1.0.0
     * */
    @SubscribeEvent
    public void onMessage(@Nonnull MessageReceivedEvent event){
        // Thread all the things, make this as responsive as possible.
        // Most everything should be inherently thread safe anyway....
        MiscUtil.runLater(()->{
            var author = event.getMember();
            if(author.getUser().isBot()){
                return;
            }
            
            var channel = event.getTextChannel();
            if(!channel.canTalk()){
                return;
            }
            
            var message = event.getMessage();
            var content = message.getContentRaw();
            
            var prefix = MiscUtil.getGuildSettings(event.getGuild()).prefix;
            if(prefix != null){
                if(content.startsWith(prefix)){
                    int index = prefix.length();
                    if(content.charAt(index) == ' '){
                        index++;
                    }
                    commandManager.executeCommand(message, content.substring(index));
                    return;
                }
            }
            
            if(content.startsWith("<@")){
                Matcher matcher = pingPattern.matcher(content);
                if(matcher.find()){
                    try{
                        commandManager.executeCommand(message, matcher.group(1));
                    }catch(Throwable t){
                        t.printStackTrace();
                    }
                }
            }
        });
    }
}
