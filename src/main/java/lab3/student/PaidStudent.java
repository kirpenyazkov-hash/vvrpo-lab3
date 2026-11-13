package lab3.student;

/**
 * Класс, представляющий платного студента.
 * Наследуется от класса Student и добавляет
 * информацию о результатах сессии.
 * Платные студенты не получают стипендию.
 */
public class PaidStudent extends Student {
    /** Результаты экзаменационной сессии (композиция) */
    private final SessionResult sessionResult;

    /**
     * Конструктор класса PaidStudent.
     * Инициализирует платного студента с заданными характеристиками.
     *
     * @param name имя студента
     * @param age возраст студента
     * @param group номер группы
     * @param sessionResult результаты сессии
     */
    public PaidStudent(String name, int age, String group, SessionResult sessionResult) {
        super(name, age, group, "Платная");
        this.sessionResult = sessionResult;
    }

    /**
     * Возвращает результаты сессии.
     *
     * @return результаты сессии
     */
    public SessionResult getSessionResult() {
        return sessionResult;
    }

    /**
     * Возвращает расширенное строковое описание платного студента.
     * Переопределяет метод родительского класса, добавляя информацию
     * о результатах сессии.
     *
     * @return строка с полной информацией о студенте
     */
    @Override
    public String getInfo() {
        return "Студент: " + name + ", Возраст: " + age + ", Группа: " + group +
               ", Форма обучения: " + educationForm + "\n  " +
               sessionResult.getInfo() + "\n  Стипендия: не получает (платная основа)";
    }
}