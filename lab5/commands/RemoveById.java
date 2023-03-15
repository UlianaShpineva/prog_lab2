package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import managers.ScannerManager;

import java.util.Scanner;

public class RemoveById extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public RemoveById(Console console, CollectionManager collectionManager) {
        super("remove_by_id", " id : удалить элемент из коллекции по его id");
        this.collectionManager = collectionManager;
        this.console = console;
    }

    @Override
    public void execute(String args) throws IllegalArgument {
        if (args.isBlank()) throw new IllegalArgument();
        class NoSuchId extends RuntimeException {
        }
        try {
            int id = Integer.parseInt(args.trim());
            if (!collectionManager.checkExist(id)) throw new NoSuchId();
            collectionManager.removeElement(collectionManager.getById(id));
        } catch (NoSuchId err) {
            console.printError("В коллекции нет элемента с таким id");
        } catch (NumberFormatException exception) {
            console.printError("id должно быть числом типа int");
        }
    }
}
