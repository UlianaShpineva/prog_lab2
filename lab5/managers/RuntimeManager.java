package managers;

import console.Console;
import console.Printable;
import exceptions.IllegalArgument;
import exceptions.NoSuchCommand;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для работы с пользовательским вводом
 */
public class RuntimeManager {
    private final Printable console;
    private final CommandManager commandManager;

    public RuntimeManager(Console console, CommandManager commandManager) {
        this.console = console;
        this.commandManager = commandManager;
    }

    /**
     * Работа с пользователем и выполнение команд
     */
    public void interactiveMode() {
        Scanner userScanner = ScannerManager.getScanner();
        while (true) {
            try {
                if (!userScanner.hasNext()) {
                    console.println("До свидания");
                    System.exit(0);
                }
                String userCommand = userScanner.nextLine().trim() + " ";
                this.launch(userCommand.split(" ", 2));
            } catch (NoSuchElementException exception) {
                console.printError("Пользовательский ввод не обнаружен");
            } catch (NoSuchCommand e) {
                console.printError("Такой команды нет в списке");
            } catch (IllegalArgument e) {
                console.printError("Введены неправильные аргументы команды");
            }
        }
    }

    /**
     * Запускает выполнение команд
     * @param userCommand Массив с именем команды и аргументом
     * @throws IllegalArgument Неверные аргументы команды
     * @throws NoSuchCommand Нет такой команды
     */
    public void launch(String[] userCommand) throws IllegalArgument, NoSuchCommand {
        if (userCommand[0].equals("")) return;
        commandManager.execute(userCommand[0], userCommand[1]);
    }
}
