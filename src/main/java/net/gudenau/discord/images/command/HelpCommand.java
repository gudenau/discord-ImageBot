package net.gudenau.discord.images.command;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.gudenau.discord.images.api.command.ICommand;
import net.gudenau.discord.images.api.command.IMessageCommand;
import net.gudenau.discord.images.api.command.Result;

/**
 * Lists all of the commands or gets usage for a specific command.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public class HelpCommand implements ICommand{
    private final CommandManager commandManager;
    private final Map<String, IMessageCommand> commandMap;
    private final Map<String, String> aliases;
    
    public HelpCommand(CommandManager commandManager, Map<String, IMessageCommand> commandMap, Map<String, String> aliases){
        this.commandManager = commandManager;
        this.commandMap = commandMap;
        this.aliases = aliases;
    }
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull @Nonnull List<String> arguments){
        if(arguments.size() > 1){
            return Result.help(this);
        }
        if(arguments.isEmpty()){
            List<IMessageCommand> commands = new ArrayList<>(commandMap.values());
            commands.sort(Comparator.comparing(IMessageCommand::getName));
            
            var builder = new StringBuilder("Commands:");
            for(IMessageCommand command : commands){
                if(command.isAvailable(channel, author)){
                    builder.append("\n**").append(command.getName()).append("**\n > ").append(command.getHelp());
                }
            }
            return Result.success(builder.toString());
        }else{
            var commandName = arguments.get(0);
            var command = commandManager.getCommand(commandName);
            
            if(command == null){
                String alias = aliases.get(commandName.toLowerCase());
                if(alias != null){
                    command = commandManager.getCommand(alias);
                    if(command != null){
                        if(command.isAvailable(channel, author)){
                            return Result.success(
                                "`%s` is an alias for `%s`\n\n" +
                                    "%s\n\nUsage: %s",
                                commandName, alias,
                                command.getHelp(),
                                command.getUsage().replaceFirst(alias, commandName.toLowerCase())
                            );
                        }else{
                            command = null;
                        }
                    }
                }
            }
            
            if(command != null && command.isAvailable(channel, author)){
                return Result.success("%s\n\nUsage: %s", command.getHelp(), command.getUsage());
            }else{
                return Result.error("Unknown command \"%s\"", commandName);
            }
        }
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "help";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Lists commands and how to use them.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return "help [command]";
    }
}
