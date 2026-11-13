package lab3.student;

/**
 * Класс, представляющий результаты экзаменационной сессии.
 * Используется в композиции со классом Student.
 * Содержит информацию об оценках, среднем балле и факте сдачи сессии в срок.
 */
public class SessionResult {
    /** Массив оценок за сессию */
    private final int[] grades;
    /** Факт сдачи сессии в срок */
    private final boolean passedOnTime;

    /**
     * Конструктор класса SessionResult.
     * Инициализирует результаты сессии с заданными параметрами.
     *
     * @param grades массив оценок за сессию
     * @param passedOnTime факт сдачи сессии в срок
     */
    public SessionResult(int[] grades, boolean passedOnTime) {
        this.grades = grades;
        this.passedOnTime = passedOnTime;
    }

    /**
     * Вычисляет средний балл по итогам сессии.
     *
     * @return средний балл
     */
    public double getAverageGrade() {
        if (grades.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    /**
     * Возвращает факт сдачи сессии в срок.
     *
     * @return true, если сессия сдана в срок; false в противном случае
     */
    public boolean isPassedOnTime() {
        return passedOnTime;
    }

    /**
     * Возвращает массив оценок.
     *
     * @return массив оценок
     */
    public int[] getGrades() {
        return grades;
    }

    /**
     * Возвращает строковое описание результатов сессии.
     *
     * @return строка с информацией о результатах сессии
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Оценки: [");
        for (int i = 0; i < grades.length; i++) {
            sb.append(grades[i]);
            if (i < grades.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("], Средний балл: ").append(String.format("%.2f", getAverageGrade()));
        sb.append(", Сдана в срок: ").append(passedOnTime ? "Да" : "Нет");
        return sb.toString();
    }
}