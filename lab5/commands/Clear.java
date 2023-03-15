package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;

/**
 * Команда 'clear'
 * Очищает коллекцию
 */
public class Clear extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", ": очистить коллекцию");
        this.collectionManager = collectionManager;
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
        collectionManager.clear();
        console.print("Элементы удалены");
    }
}
