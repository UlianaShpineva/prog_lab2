package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CommandManager;

/**
 * Команда 'help'
 * Выводит справку по доступным командам
 */
public class Help extends Command{
    private CommandManager commandManager;
    private Console console;
    public Help(Console console, CommandManager commandManager) {
        super("help", ": вывести справку по доступным командам");
        this.commandManager = commandManager;
        this.console = console;
    }

    /**
     * Исполнить программу
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (!args.isBlank()) throw new IllegalArgument();
        commandManager.getCommands()
                .forEach(command -> console.println(command.getName() + command.getDescription()));
    }
}
