package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import models.StudyGroup;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Команда 'remove_all_by_expelled_students'
 * Удаляет из коллекции все элементы, значение поля expelledStudents которого эквивалентно заданному
 */
public class RemoveAllByExpelledStudents extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public RemoveAllByExpelledStudents(Console console, CollectionManager collectionManager) {
        super("remove_all_by_expelled_students", " expelledStudents : удалить из коллекции все элементы, значение поля expelledStudents которого эквивалентно заданному");
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
        if (args.isBlank()) throw new IllegalArgument();
        try {
            int expelledStudents = Integer.parseInt(args.trim());
            Collection<StudyGroup> toRemove = collectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    .filter(studyGroup -> studyGroup.getExpelledStudents() == expelledStudents)
                    .collect(Collectors.toList());
            for (StudyGroup element:toRemove) {
                collectionManager.removeElement(element);
            }
            console.println("Удалены элементы с таким expelled_students");
        } catch (NumberFormatException exception) {
            console.printError("expelled_students должно быть числом типа int");
        }
    }
}
