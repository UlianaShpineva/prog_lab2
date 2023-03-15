package commands;

import exceptions.IllegalArgument;
import managers.CollectionManager;
import console.Console;
import models.StudyGroup;

import java.util.Collection;

/**
 * Команда 'show'
 * Выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class Show extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public Show(Console console, CollectionManager collectionManager) {
        super("show", ": вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
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
        Collection<StudyGroup> collection = collectionManager.getCollection();
        if (collection == null || collection.isEmpty()) {
            console.printError("Коллекция не инициализирована");
            return;
        }
        console.println(collection.toString());
    }
}
