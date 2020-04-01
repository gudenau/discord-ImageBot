package net.gudenau.discord.images.command;

import com.google.gson.annotations.Expose;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.RestAction;
import net.gudenau.discord.images.api.command.IAdminCommand;
import net.gudenau.discord.images.api.command.IMessageCommand;
import net.gudenau.discord.images.api.command.IOwnerCommand;
import net.gudenau.discord.images.api.command.IPipeCommand;
import net.gudenau.discord.images.api.command.Result;
import net.gudenau.discord.images.util.Json;

public class DumpCommand implements IOwnerCommand{
    private final Map<String, IMessageCommand> commands;
    private final Map<String, String> aliases;
    
    public DumpCommand(Map<String, IMessageCommand> commands, Map<String, String> aliases){
        this.commands = commands;
        this.aliases = aliases;
    }
    
    private static final class CommandInfo{
        @Expose public String name;
        @Expose public String help;
        @Expose public String usage;
        @Expose public String type;
        @Expose public List<String> aliases;
        @Expose public boolean pipeable;
    }
    
    @Nonnull
    @Override
    public Result execute(@Nonnull TextChannel channel, @Nonnull Member author, @Nonnull List<String> arguments){
        if(!arguments.isEmpty()){
            return Result.help(this);
        }
        
        var commandInfoList = new ArrayList<CommandInfo>();
        for(IMessageCommand command : commands.values()){
            var commandInfo = new CommandInfo();
            commandInfo.name = command.getName();
            commandInfo.help = command.getHelp();
            commandInfo.usage = command.getUsage();
            
            if(command instanceof IAdminCommand){
                commandInfo.type = "admin";
            }else if(command instanceof IOwnerCommand){
                commandInfo.type = "owner";
            }else{
                commandInfo.type = "user";
            }
            
            commandInfo.pipeable = command instanceof IPipeCommand;
            
            var name = commandInfo.name.toLowerCase();
            commandInfo.aliases = aliases.entrySet().stream()
                .filter((e)->e.getValue().equalsIgnoreCase(name))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
            commandInfo.aliases.sort(String::compareToIgnoreCase);
            
            commandInfoList.add(commandInfo);
        }
        
        return new JsonResult(Json.write(commandInfoList));
    }
    
    @Nonnull
    @Override
    public String getName(){
        return "dumpCommands";
    }
    
    @Nonnull
    @Override
    public String getHelp(){
        return "Dumps all commands to a JSON file.";
    }
    
    @Nonnull
    @Override
    public String getUsage(){
        return getName();
    }
    
    private static class JsonResult extends Result{
        private final String payload;
    
        public JsonResult(String payload){
            super();
            this.payload = payload;
        }
    
        @Override
        public RestAction<Message> preparePost(@Nonnull TextChannel channel, @Nonnull Member author){
            return channel.sendFile(
                payload.getBytes(StandardCharsets.UTF_8),
                "result.json"
            );
        }
    }
}
