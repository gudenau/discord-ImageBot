package net.gudenau.discord.images.command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IMessageCommand;
import net.gudenau.discord.images.api.command.Result;

/**
 * Get's an emoji's image.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class EmojiCommand implements IMessageCommand{
    /**
     * The pattern for matching a Discord emoji and only a Discord emoji.
     *
     * @since 1.0.0
     * */
    private static final Pattern PATTERN_DISCORD_EMOJI = Pattern.compile("^<a?:[\\S]+?:([0-9])+>$");
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull Message message, @Nonnull List<String> arguments){
        if(arguments.size() == 1){
            var argument = arguments.get(0);
            if(PATTERN_DISCORD_EMOJI.matcher(argument).find()){
                var emoji = message.getEmotes().get(0);
                return Result.image(emoji.getImageUrl(), emoji.getName());
            }else{
                var codePoint = toCodePoint(argument);
                if(codePoint != null){
                    var fileName = toCodePoint(argument) + ".png";
                    var path = Path.of(".", "resources", "emoji", fileName);
                    if(Files.exists(path)){
                        return Result.image(path, argument);
                    }
                }
            }
        }else if(arguments.isEmpty()){
            if(channel.getGuild().getSelfMember().hasPermission(channel, Permission.MESSAGE_HISTORY)){
                for(Message oldMessage : channel.getHistory().retrievePast(50).complete()){
                    var emojiList = oldMessage.getEmotes();
                    if(!emojiList.isEmpty()){
                        return Result.image(emojiList.get(0).getImageUrl());
                    }
                }
            }
            return Result.error("Failed to find message with a custom emoji.");
        }
        return Result.help(this);
    }
    
    
    private String toCodePoint(String surrogates){
        var surrogateChars = surrogates.toCharArray();
        char pair = 0;
        var result = new StringBuilder();
        for(char surrogate : surrogateChars){
            if(pair != 0){
                result.append(Integer.toHexString(0x10000 + ((pair - 0xD800) << 10) + (surrogate - 0xDC00))).append('-');
                pair = 0;
            }else if(0xD800 <= surrogate && surrogate <= 0xDBFF){
                pair = surrogate;
            }else{
                return null;
            }
        }
        if(result.length() > 0){
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "emoji";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Gets the image for an emoji";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "emoji [emoji]";
    }
}
