package lab3.student;

/**
 * Абстрактный класс, представляющий студента.
 * Наследуется от класса Person и добавляет
 * специфичные характеристики студента: номер группы и форму обучения.
 */
public abstract class Student extends Person {
    /** Номер группы студента */
    protected String group;
    /** Форма обучения (бюджетная или платная) */
    protected String educationForm;

    /**
     * Конструктор класса Student.
     * Инициализирует студента с заданными характеристиками.
     *
     * @param name имя студента
     * @param age возраст студента
     * @param group номер группы
     * @param educationForm форма обучения
     */
    public Student(String name, int age, String group, String educationForm) {
        super(name, age);
        this.group = group;
        this.educationForm = educationForm;
    }

    /**
     * Возвращает номер группы студента.
     *
     * @return номер группы
     */
    public String getGroup() {
        return group;
    }

    /**
     * Возвращает форму обучения студента.
     *
     * @return форма обучения
     */
    public String getEducationForm() {
        return educationForm;
    }
}