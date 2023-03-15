package models.forms;

import console.BlankConsole;
import console.Printable;
import models.FormOfEducation;
import managers.ScannerManager;

import java.util.Scanner;

/**
 * Форма для формы обучения
 */
public class FormOfEducationForm extends Form<FormOfEducation> {
    private final Printable console;
    private final Scanner scanner = ScannerManager.getScanner();

    public FormOfEducationForm(Printable console) {
        this.console = (ScannerManager.fileMode())
                ? new BlankConsole()
                : console;
    }

    /**
     * Создает объект {@link FormOfEducation}
     * @return объект {@link FormOfEducation}
     */
    @Override
    public FormOfEducation build() {
        console.println("Доступные формы обучения:");
        console.println(FormOfEducation.names());
        while (true) {
            console.println("Введите форму обучения:");
            String input = scanner.nextLine().trim();
            try{
                return FormOfEducation.valueOf(input);
            } catch (IllegalArgumentException exception){
                console.printError("Такой формы обучения нет в списке");
            } catch (Throwable throwable) {
                console.printError("Непредвиденная ошибка!");
            }
        }
    }
}
