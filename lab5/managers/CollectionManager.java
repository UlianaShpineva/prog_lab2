package managers;

import console.Console;
import exceptions.InvalidForm;
import models.StudyGroup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Класс для работы с коллекцией
 */
public class CollectionManager {
    private TreeSet<StudyGroup> collection = new TreeSet<StudyGroup>();
    private final Console console;
    private final FileManager fileManager;
    /**
     * Дата создания коллекции
     */
    private LocalDateTime lastInitTime;

    public CollectionManager(Console console, FileManager fileManager) {
        this.console = console;
        this.fileManager = fileManager;
        this.lastInitTime = LocalDateTime.now();

        loadCollection();
    }

    /**
     * @return Коллекция
     */
    public TreeSet<StudyGroup> getCollection() {
        return collection;
    }

    /**
     * @return Время последней инициализации
     */
    public String getLastInitTime() {
        return lastInitTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * @return Тип коллекции
     */
    public String collectionType() {
        return collection.getClass().getName();
    }

    /**
     * @return Размер коллекции
     */
    public int collectionSize() {
        return collection.size();
    }

    /**
     * Очищает коллекцию, обновляет время инициализации
     */
    public void clear(){
        this.collection.clear();
        lastInitTime = LocalDateTime.now();
    }

    /**
     * Добавляет элемент в коллекцию
     * @param studyGroup Элемент
     * @throws InvalidForm Невалидные поля у элемента
     */
    public void addElement(StudyGroup studyGroup) throws InvalidForm {
        if (!studyGroup.validate()) throw new InvalidForm();
        collection.add(studyGroup);
    }

    /**
     * @param id id
     * @return Существование элемента с заданным id
     */
    public boolean checkExist(int id) {
        return collection.stream()
                .anyMatch((x) -> x.getId() == id);
    }

    /**
     * @param id id
     * @return Элемент с таким id или null
     */
    public StudyGroup getById(int id) {
        for (StudyGroup element : collection) {
            if (element.getId() == id) return element;
        }
        return null;
    }

    /**
     * Удаляет элемент из коллекции
     * @param studyGroup Элемент
     */
    public void removeElement(StudyGroup studyGroup){
        collection.remove(studyGroup);
    }

    /**
     * Изменяиет элемент коллекции по id
     * @param id id
     * @param newElement Новый элемент
     * @throws InvalidForm Элемент отсутствует
     */
    public void editById(int id, StudyGroup newElement) throws InvalidForm{
        StudyGroup pastElement = this.getById(id);
        this.removeElement(pastElement);
        newElement.setId(id);
        this.addElement(newElement);
        StudyGroup.updateId(this.getCollection());
    }

    /**
     * Загружает коллекцию из файла
     */
    private void loadCollection() {
        collection = (TreeSet<StudyGroup>) fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    /*
    public void validateAll(Console console) {
        collection.forEach(p -> {
            if (!p.validate()) {
                console.printError(" с id=" + p.getId() + " имеет невалидные поля.");
            }
        });

        (new ArrayList<>(this.getCollection())).forEach(p -> {
            if (!p.validate()) {
                console.printError("StudyGroup с id=" + p.getId() + " имеет невалидные поля.");
            }
        });
        console.println("Загруженные продукты валидны");
    }
    */

}
