package net.gudenau.discord.plugin;

import java.util.List;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.ICommandManager;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.plugin.IPlugin;
import org.jetbrains.annotations.NotNull;

public class TestPlugin implements IPlugin{
    @Override
    public void onLoad(@Nonnull ICommandManager commandManager){
        commandManager.register(new ICommand(){
            @Nonnull
            @Override
            public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
                return Result.success("Hello from a plugin!");
            }
    
            @Nonnull
            @Override
            public String getName(){
                return "pluginTest";
            }
    
            @Nonnull
            @Override
            public String getHelp(){
                return "Prints a hello message.";
            }
    
            @Nonnull
            @Override
            public String getUsage(){
                return "pluginTest";
            }
        });
    }
}
