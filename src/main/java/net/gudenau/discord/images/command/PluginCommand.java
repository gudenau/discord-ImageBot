package net.gudenau.discord.images.command;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.IOwnerCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.plugin.PluginLoader;
import net.gudenau.discord.images.plugin.PluginMetadata;

/**
 * Commands related to plugins.
 *
 * @author gudenau
 * @since 1.0.0
 */
public class PluginCommand{
    /**
     * Lists all loaded plugins.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    public static class Enumerate implements IOwnerCommand{
        @Nonnull
        @Override
        public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
            if(arguments.isEmpty()){
                var builder = new StringBuilder("Loaded plugins:");
                for(PluginMetadata plugin : PluginLoader.getPlugins()){
                    builder.append("\n**")
                        .append(plugin.getName())
                        .append("**\n > v")
                        .append(plugin.getVersion())
                        .append("\n > Id: ")
                        .append(plugin.getId());
                }
                return Result.success(builder.toString());
            }else{
                return Result.help(this);
            }
        }
    
        @Nonnull
        @Override
        public String getName(){
            return "plugin.list";
        }
    
        @Nonnull
        @Override
        public String getHelp(){
            return "Lists loaded plugins.";
        }
    
        @Nonnull
        @Override
        public String getUsage(){
            return "plugin.list";
        }
    }
    
    /**
     * Gets info on a loaded plugin.
     *
     * @author gudenau
     * @since 1.0.0
     * */
    public static class Info implements IOwnerCommand{
        @Nonnull
        @Override
        public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
            if(arguments.size() == 1){
                PluginMetadata plugin = PluginLoader.getPlugin(arguments.get(0));
                if(plugin == null){
                    return Result.error("Unknown plugin: %s", arguments.get(0));
                }
                
                var builder = new StringBuilder();
                builder
                    .append("**")
                    .append(plugin.getName())
                    .append("** v")
                    .append(plugin.getVersion())
                    .append("\n")
                    .append("requires:\n");
    
                for(String require : plugin.getRequires()){
                    builder.append(" > ").append(require).append("\n");
                }
                
                builder.append("authors:\n");
                for(String pluginAuthor : plugin.getAuthors()){
                    builder.append(" > ").append(pluginAuthor).append("\n");
                }
                
                return Result.success(builder.toString());
            }else{
                return Result.help(this);
            }
        }
    
        @Nonnull
        @Override
        public String getName(){
            return "plugin.info";
        }
    
        @Nonnull
        @Override
        public String getHelp(){
            return "Gets info about a loaded plugin.";
        }
    
        @Nonnull
        @Override
        public String getUsage(){
            return "plugin.info (plugin id)";
        }
    }
}
