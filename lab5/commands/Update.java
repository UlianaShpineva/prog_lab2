package commands;

import console.Console;
import exceptions.IllegalArgument;
import exceptions.InvalidForm;
import managers.CollectionManager;
import models.StudyGroup;
import models.forms.StudyGroupForm;

/**
 * Команда 'update'
 * Обновляет значение элемента коллекции, id которого равен заданному
 */
public class Update extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public Update(Console console, CollectionManager collectionManager) {
        super("update", " id {element} : обновить значение элемента коллекции, id которого равен заданному");
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
        class NoSuchId extends RuntimeException{
        }
        try {
            int id = Integer.parseInt(args.trim());
            if (!collectionManager.checkExist(id)) throw new NoSuchId();
            console.println("Создание нового объекта StudyGroup");
            StudyGroup newStudyGroup = new StudyGroupForm(console).build();
            collectionManager.editById(id, newStudyGroup);
        } catch (NoSuchId err) {
            console.printError("В коллекции нет элемента с таким id");
        } catch (InvalidForm invalidForm) {
            console.printError("Поля объекта не валидны. Объект не создан.");
        } catch (NumberFormatException exception) {
            console.printError("id должно быть числом типа int");
        }
    }
}
