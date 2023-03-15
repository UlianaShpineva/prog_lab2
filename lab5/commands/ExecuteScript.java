package commands;

import console.Console;
import exceptions.IllegalArgument;
import managers.FileManager;


/**
 * Команда 'execute_script'
 * Считатывает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 */
public class ExecuteScript extends Command {
    private final Console console;
    private final FileManager fileManager;

    public ExecuteScript(Console console, FileManager fileManager) {
        super("execute_script", " file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        this.console = console;
        this.fileManager = fileManager;
    }

    /**
     * Исполнить программу
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы
     */

    @Override
    public void execute(String args) throws IllegalArgument {
        if (args == null || args.isEmpty()) {
            console.printError("Файл не найден");
            return;
        }
        String fileName = (args.trim());
        fileManager.scriptMode(fileName);
    }
}
