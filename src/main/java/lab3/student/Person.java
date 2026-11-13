package lab3.student;

/**
 * Абстрактный базовый класс, представляющий человека.
 * Является родительским классом для всех категорий людей.
 * Содержит общие характеристики: имя и возраст.
 */
public abstract class Person {
    /** Имя человека */
    protected String name;
    /** Возраст человека */
    protected int age;

    /**
     * Конструктор класса Person.
     * Инициализирует основные характеристики человека.
     *
     * @param name имя человека
     * @param age возраст человека
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Возвращает строковое описание человека с основными характеристиками.
     * Должен быть переопределён в классах-наследниках.
     *
     * @return строка с информацией о человеке
     */
    public abstract String getInfo();

    /**
     * Возвращает имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает возраст человека.
     *
     * @return возраст человека
     */
    public int getAge() {
        return age;
    }
}