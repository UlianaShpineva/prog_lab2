package commands;

import console.Console;
import exceptions.IllegalArgument;
import exceptions.InvalidForm;
import managers.CollectionManager;
import models.StudyGroup;
import models.forms.StudyGroupForm;

import java.util.Objects;

/**
 * Команда 'add_if_min'
 * Добавляет элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */
public class AddIfMin extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public AddIfMin(Console console, CollectionManager collectionManager) {
        super("add_if_min", " {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
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
        try {
            console.println("Создание объекта StudyGroup");
            StudyGroup newElement = new StudyGroupForm(console).build();
            console.println("Создание объекта StudyGroup окончено успешно!");
            if (newElement.compareTo(collectionManager.getCollection().stream()
                .filter(Objects::nonNull)
                .min(StudyGroup::compareTo)
                .orElse(null)) >= 1)
            {
                collectionManager.addElement(newElement);
                console.println("Объект успешно добавлен");
            } else {
                console.println("Элемент больше минимального");
            }
        } catch (InvalidForm invalidForm) {
            console.printError("Поля объекта не валидны! Объект не создан!");
        }
    }
}