import commands.*;
import console.Console;
import managers.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        //Scanner scanner = ScannerManager.getScanner();
        ScannerManager.setScanner(new Scanner(System.in));
        CommandManager commandManager = new CommandManager();
        RuntimeManager runtimeManager = new RuntimeManager(console, commandManager);
//        console.println("Введите имя загружаемого файла как аргумент командной строки:");
//        String fileName = scanner.nextLine().trim();
        String fileName = args[0];

        FileManager fileManager = new FileManager(console, fileName, runtimeManager);

        CollectionManager collectionManager = new CollectionManager(console, fileManager);
        //collectionManager.validateAll(console);

        commandManager.register(new Help(console, commandManager));
        commandManager.register(new Info(console, collectionManager));
        commandManager.register(new Show(console, collectionManager));
        commandManager.register(new AddElement(console, collectionManager));
        commandManager.register(new Update(console, collectionManager));
        commandManager.register(new RemoveById(console, collectionManager));
        commandManager.register(new Clear(console, collectionManager));
        commandManager.register(new Save(console, fileManager, collectionManager));
        commandManager.register(new ExecuteScript(console, fileManager));
        commandManager.register(new Exit());
        commandManager.register(new AddIfMax(console, collectionManager));
        commandManager.register(new AddIfMin(console, collectionManager));
        commandManager.register(new RemoveGreater(console, collectionManager));
        commandManager.register(new RemoveAllByExpelledStudents(console, collectionManager));
        commandManager.register(new AverageOfExpelledStudents(console, collectionManager));
        commandManager.register(new PrintAscending(console, collectionManager));

        new RuntimeManager(console, commandManager).interactiveMode();
    }
}
