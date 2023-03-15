package commands;

import console.Console;
import exceptions.IllegalArgument;
import exceptions.InvalidForm;
import managers.CollectionManager;
import models.forms.StudyGroupForm;

/**
 * Команда 'add'
 * Добавляет новый элемент в коллекцию
 */
public class AddElement extends Command{
    private CollectionManager collectionManager;
    private Console console;

    public AddElement(Console console, CollectionManager collectionManager) {
        super("add", " {element} : добавить новый элемент в коллекцию");
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
            console.println("Создание объекта StudyGroup:");
            collectionManager.addElement(new StudyGroupForm(console).build());
            console.println("Создание объекта StudyGroup окончено успешно");
        } catch (InvalidForm invalidForm) {
            console.printError("Поля объекта не валидны. Объект не создан.");
        }
    }
}
