package net.gudenau.discord.images.command;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Icon;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IOwnerCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.util.DiscordUtil;
import net.gudenau.discord.images.util.NetworkUtil;

/**
 * Changes the avatar for the bot user.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class UpdateAvatarCommand implements IOwnerCommand{
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
        var manager = channel.getJDA().getSelfUser().getManager();
        String url;
        if(arguments.isEmpty()){
            url = DiscordUtil.getLastImage(channel);
        }else if(arguments.size() == 1){
            url = arguments.get(0);
        }else{
            return Result.help(this);
        }
        
        if(url == null){
            return Result.error("Failed to locate image.");
        }
    
        try(var stream = NetworkUtil.getInputStream(url)){
            manager.setAvatar(Icon.from(stream)).submit();
        }catch(IOException e){
            e.printStackTrace();
            return Result.error("Failed to download image.");
        }
    
        return Result.success("Updated avatar!");
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "updateAvatar";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Changes the bot's avatar.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "updateAvatar [image]";
    }
}
