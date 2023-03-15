package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import models.StudyGroup;
import models.forms.StudyGroupForm;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Команда 'remove_greater'
 * Удаляет из коллекции все элементы, превышающие заданный
 */
public class RemoveGreater extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public RemoveGreater(Console console, CollectionManager collectionManager) {
        super("remove_greater", " {element} : удалить из коллекции все элементы, превышающие заданный");
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
        class NoElements extends RuntimeException{
        }
        try {
            console.println("Создание объекта StudyGroup");
            StudyGroup newElement = new StudyGroupForm(console).build();
            //console.println("Создание объекта StudyGroup окончено успешно!");
            Collection<StudyGroup> toRemove = collectionManager.getCollection().stream()
                    .filter(Objects::nonNull)
                    .filter(studyGroup -> studyGroup.compareTo(newElement) >= 1)
                    .collect(Collectors.toList());
            for (StudyGroup element:toRemove) {
                collectionManager.removeElement(element);
            }
            console.println("Удалены элементы большие чем заданный");
        } catch (NoElements e){
            console.printError("В коллекции нет элементов");
        }
    }
}
