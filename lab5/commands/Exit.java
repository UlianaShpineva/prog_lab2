package commands;


import exceptions.IllegalArgument;

/**
 * Команда 'exit'
 * Завершает программу (без сохранения в файл)
 */
public class Exit extends Command {
    public Exit() {
        super("exit", ": завершить программу (без сохранения в файл)");
    }

    /**
     * Исполнить программу
     * @param args аргументы команды
     * @throws IllegalArgument неверные аргументы
     */
    @Override
    public void execute(String args) {
        System.exit(0);
    }
}
