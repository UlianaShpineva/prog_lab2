package managers;

import commands.Command;
import exceptions.IllegalArgument;
import exceptions.NoSuchCommand;

import java.util.Collection;
import java.util.HashMap;

/**
 * Класс для управления командами
 */
public class CommandManager {
    private final HashMap<String, Command> commands = new HashMap<>();

    /**
     * Добавляет команду
     * @param command Команда
     */
    public void register(Command command){
        this.commands.put(command.getName(), command);
    }

    /**
     * @return Коллекция команд
     */
    public Collection<Command> getCommands(){
        return commands.values();
    }

    /**
     * Исполнение команды
     * @param name Имя
     * @param args Аргументы
     * @throws IllegalArgument неверные аргументы
     * @throws NoSuchCommand нет такой команды
     */
    public void execute(String name, String args) throws IllegalArgument, NoSuchCommand {
        Command command = commands.get(name);
        if (command == null) throw new NoSuchCommand();
        command.execute(args);
    }
}
