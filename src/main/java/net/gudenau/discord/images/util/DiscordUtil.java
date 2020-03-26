package net.gudenau.discord.images.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

/**
 * Discord related util methods.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class DiscordUtil{
    /**
     * The ID of the owner of the bot.
     *
     * @since 1.0.0
     * */
    private static String owner;
    
    /**
     * Get's the URL of the last image sent within 50 messages.
     *
     * @param channel The channel to search in
     *
     * @return The last image or null if not found
     * */
    @Nullable
    public static String getLastImage(@Nonnull TextChannel channel){
        if(!channel.getGuild().getSelfMember().hasPermission(channel, Permission.MESSAGE_HISTORY)){
            return null;
        }
        
        var messages = channel.getHistory().retrievePast(50).complete();
        for(Message message : messages){
            for(Message.Attachment attachment : message.getAttachments()){
                if(attachment.isImage()){
                    return attachment.getProxyUrl();
                }
            }
            
            for(MessageEmbed embed : message.getEmbeds()){
                var image = embed.getImage();
                if(image != null){
                    return image.getProxyUrl();
                }
                
                var thumbnail = embed.getThumbnail();
                if(thumbnail != null){
                    return thumbnail.getProxyUrl();
                }
            }
        }
        return null;
    }
    
    /**
     * Gets called when the bot is ready.
     *
     * @param jda The JDA instance.
     * */
    public static void onReady(@Nonnull JDA jda){
        owner = jda.retrieveApplicationInfo().complete().getOwner().getId();
    }
    
    /**
     * Checks if the user is the owner of the bot.
     *
     * @param user The user to check.
     *
     * @return true if the user is the owner, false otherwise.
     * */
    public static boolean isOwner(@Nonnull User user){
        return owner.equals(user.getId());
    }
}
