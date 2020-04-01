package net.gudenau.discord.images.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.Result;

public class AliasCommand implements ICommand{
    private final CommandManager commandManager;
    private final Map<String, String> aliases;
    
    public AliasCommand(CommandManager commandManager, Map<String, String> aliases){
        this.commandManager = commandManager;
        this.aliases = aliases;
    }
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
        if(arguments.isEmpty()){
            Map<String, List<String>> aliasMap = new HashMap<>();
            aliases.forEach((k, v)->{
                var command = commandManager.getCommand(v);
                if(command != null && command.isAvailable(channel, author)){
                    aliasMap.computeIfAbsent(v, (v2)->new ArrayList<>()).add(k);
                }
            });
            
            StringBuilder stringBuilder = new StringBuilder("Current aliases:\n\n");
            aliasMap.forEach((k, v)->{
                stringBuilder.append(k).append(":\n");
                v.forEach((a)->stringBuilder.append(" > ").append(a).append('\n'));
                stringBuilder.append('\n');
            });
            return Result.success(stringBuilder.toString());
        }else if(arguments.size() == 1){
            var alias = arguments.get(0);
            var commandName = aliases.get(alias.toLowerCase());
            var command = commandName == null ? null : commandManager.getCommand(commandName);
            if(command != null && command.isAvailable(channel, author)){
                return Result.success("%s -> %s", alias, commandName);
            }else{
                return Result.error("Unknown alias: %s", alias);
            }
        }else{
            return Result.help(this);
        }
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "alias";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Prints aliases.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "alias [alias]";
    }
    
    public static class Get implements ICommand{
        private final CommandManager commandManager;
        private final Map<String, String> aliases;
        
        public Get(CommandManager commandManager, Map<String, String> aliases){
            this.commandManager = commandManager;
            this.aliases = aliases;
        }
    
        @Nonnull
        @Override
        public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
            if(arguments.size() == 1){
                var commandName = arguments.get(0);
                var command = commandManager.getCommand(commandName);
                var stringBuilder = new StringBuilder();
                if(command != null && command.isAvailable(channel, author)){
                    var lowerCommand = commandName.toLowerCase();
                    aliases.forEach((k, v)->{
                        if(v.equals(lowerCommand)){
                            stringBuilder.append(k).append('\n');
                        }
                    });
                }
                if(stringBuilder.length() != 0){
                    return Result.error("Did not find aliases for command %s", commandName);
                }else{
                    return Result.success("Aliases for %s\n%s", commandName, stringBuilder.toString());
                }
            }else{
                return Result.help(this);
            }
        }
    
        @Nonnull
        @Override
        public String getName(){
            return "getAlias";
        }
    
        @Nonnull
        @Override
        public String getHelp(){
            return "Prints aliases for a command.";
        }
    
        @Nonnull
        @Override
        public String getUsage(){
            return "getAlias (command)";
        }
    }
}
