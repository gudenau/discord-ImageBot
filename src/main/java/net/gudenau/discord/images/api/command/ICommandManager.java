package net.gudenau.discord.images.api.command;

import javax.annotation.Nonnull;

/**
 * Where commands are registered.
 *
 * @author gudenau
 * @since 1.0.0
 * */
public interface ICommandManager{
    /**
     * Registers a command.
     *
     * @param command The command to register.
     *
     * @throws IllegalArgumentException If the command's name was registered by another command.
     *
     * @since 1.0.0
     * */
    void register(@Nonnull IMessageCommand command);
    
    /**
     * Registers a bunch of commands.
     *
     * @param commands The commands to register.
     *
     * @throws IllegalArgumentException If a command's name was registered by another command.
     *
     * @since 1.0.0
     * */
    void register(@Nonnull IMessageCommand... commands);
    
    /**
     * Registers a command alias.
     *
     * @param name The name of tha alias
     * @param value The name of the command
     *
     * @throws java.lang.IllegalArgumentException If a command has the alias name, the alias is already registered, or
     *      the command does not exit.
     *
     * @since 1.0.0
     * */
    void registerAlias(String name, String value);
}
