package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import models.StudyGroup;

/**
 * Команда 'print_ascending'
 * Выводит элементы коллекции в порядке возрастания
 */
public class PrintAscending extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public PrintAscending(Console console, CollectionManager collectionManager) {
        super("print_ascending", ": вывести элементы коллекции в порядке возрастания");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    /**
     * Исполнить программу
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы
     */
    @Override
    public void execute(String args) {
        collectionManager.getCollection().stream()
                .sorted(StudyGroup::compareTo)
                .forEach(p -> console.println(p.toString()));
    }
}
