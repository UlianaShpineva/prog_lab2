package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import managers.FileManager;

/**
 * Команда 'save'
 * Сохраняет коллекцию в файл
 */
public class Save extends Command {
    private Console console;
    private FileManager fileManager;
    private CollectionManager collectionManager;

    public Save(Console console, FileManager fileManager, CollectionManager collectionManager) {
        super("save", ": сохранить коллекцию в файл");
        this.console = console;
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    /**
     * Исполнить программу
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы
     */
    @Override
    public void execute(String args) throws IllegalArgument {
        if (!args.isBlank()) throw new IllegalArgument();
        fileManager.writeCollection(collectionManager.getCollection());
        //console.println("Коллекция сохранена в файл");
    }
}
