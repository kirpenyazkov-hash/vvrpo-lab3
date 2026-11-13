package lab3.student;

/**
 * Класс, представляющий бюджетного студента.
 * Наследуется от класса Student и добавляет
 * информацию о результатах сессии и размере стипендии.
 * Реализует логику расчёта стипендии в зависимости от среднего балла.
 */
public class BudgetStudent extends Student {
    /** Результаты экзаменационной сессии (композиция) */
    private final SessionResult sessionResult;
    /** Размер стипендии в белорусских рублях (BYN) */
    private double scholarship;
    /** Минимальный размер стипендии */
    private static final double MIN_SCHOLARSHIP = 100.0;

    /**
     * Конструктор класса BudgetStudent.
     * Инициализирует бюджетного студента с заданными характеристиками.
     *
     * @param name имя студента
     * @param age возраст студента
     * @param group номер группы
     * @param sessionResult результаты сессии
     */
    public BudgetStudent(String name, int age, String group, SessionResult sessionResult) {
        super(name, age, group, "Бюджетная");
        this.sessionResult = sessionResult;
        this.scholarship = calculateScholarship();
    }

    /**
     * Вычисляет размер стипендии в зависимости от среднего балла.
     * Только студенты, сдавшие сессию в срок, получают стипендию.
     * Средний балл < 5: стипендия 0
     * Средний балл 5-6: минимальная стипендия
     * Средний балл 6-8: увеличенная на 25%
     * Средний балл 8-10: увеличенная на 50%
     *
     * @return размер стипендии
     */
    private double calculateScholarship() {
        if (!sessionResult.isPassedOnTime()) {
            return 0;
        }
        double avgGrade = sessionResult.getAverageGrade();
        if (avgGrade < 5) {
            return 0;
        } else if (avgGrade < 6) {
            return MIN_SCHOLARSHIP;
        } else if (avgGrade < 8) {
            return MIN_SCHOLARSHIP * 1.25;
        } else {
            return MIN_SCHOLARSHIP * 1.5;
        }
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
     * Возвращает размер стипендии.
     *
     * @return размер стипендии в BYN
     */
    public double getScholarship() {
        return scholarship;
    }

    /**
     * Возвращает расширенное строковое описание бюджетного студента.
     * Переопределяет метод родительского класса, добавляя информацию
     * о результатах сессии и размере стипендии.
     *
     * @return строка с полной информацией о студенте
     */
    @Override
    public String getInfo() {
        return "Студент: " + name + ", Возраст: " + age + ", Группа: " + group +
               ", Форма обучения: " + educationForm + "\n  " +
               sessionResult.getInfo() + "\n  Стипендия: " + String.format("%.2f", scholarship) + " BYN";
    }
}