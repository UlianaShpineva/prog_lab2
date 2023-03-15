package commands;
import exceptions.IllegalArgument;
import managers.CollectionManager;
import console.*;

/**
 * Команда 'info'
 * Выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class Info extends Command {
    private CollectionManager collectionManager;
    private Console console;

    public Info(Console console, CollectionManager collectionManager) {
        super("info", ": вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
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
        String lastInitTime = (collectionManager.getLastInitTime() == null)
                ? "Коллекция не инициализирована"
                : collectionManager.getLastInitTime().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Информация о коллекции: \n");
        stringBuilder.append("Тип: " + collectionManager.collectionType() + "\n");
        stringBuilder.append("Количество элементов: " + collectionManager.collectionSize() + "\n");
        stringBuilder.append("Дата инициализации: " + lastInitTime + "\n");
        console.print(stringBuilder.toString());
    }
}
