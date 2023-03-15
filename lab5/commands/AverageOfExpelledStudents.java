package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import models.StudyGroup;

import java.util.Objects;

/**
 * Команда 'average_of_expelled_students'
 * Выводит среднее значение поля expelledStudents для всех элементов коллекции
 */
public class AverageOfExpelledStudents extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public AverageOfExpelledStudents(Console console, CollectionManager collectionManager) {
        super("average_of_expelled_students", ": вывести среднее значение поля expelledStudents для всех элементов коллекции");
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
        console.println("Среднее значение поля expelledStudents:");
        Double toSort = collectionManager.getCollection().stream()
                .filter(Objects::nonNull)
                .mapToInt(StudyGroup::getExpelledStudents)
                .average().orElse(0);
        console.println(toSort.toString());
    }
}
