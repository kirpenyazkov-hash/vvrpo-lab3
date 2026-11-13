package lab3;

import lab3.student.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Основное приложение для демонстрации работы системы учёта стипендий
 * Создаёт 10 объектов студентов и предоставляет интерактивное меню
 */
public class Main {
    /** Список студентов */
    private static List<Student> students = new ArrayList<>();

    /**
     * Главный метод приложения
     */
    public static void main(String[] args) {
        initializeStudents();
        showMenu();
    }

    /**
     * Инициализирует список студентов тестовыми данными
     */
    private static void initializeStudents() {
        // 10 студентов со стипендией +25% (средний балл 6-8)
        students.add(new BudgetStudent("Иванов Иван", 19, "ИТП-21",
            new SessionResult(new int[]{7, 7, 8, 6, 7}, true)));
        students.add(new BudgetStudent("Петров Пётр", 20, "ИТП-21",
            new SessionResult(new int[]{6, 7, 7, 8, 6}, true)));
        students.add(new BudgetStudent("Сидоров Сидор", 19, "ИТП-21",
            new SessionResult(new int[]{7, 6, 8, 7, 7}, true)));
        students.add(new BudgetStudent("Козлов Алексей", 20, "ИТП-21",
            new SessionResult(new int[]{8, 7, 6, 7, 7}, true)));
        students.add(new BudgetStudent("Новиков Дмитрий", 19, "ИТП-21",
            new SessionResult(new int[]{7, 7, 7, 6, 8}, true)));
        students.add(new BudgetStudent("Морозов Артём", 20, "ИТП-21",
            new SessionResult(new int[]{6, 8, 7, 7, 6}, true)));
        students.add(new BudgetStudent("Волков Сергей", 19, "ИТП-21",
            new SessionResult(new int[]{7, 6, 7, 8, 7}, true)));
        students.add(new BudgetStudent("Соловьёв Андрей", 20, "ИТП-21",
            new SessionResult(new int[]{8, 6, 7, 7, 7}, true)));
        students.add(new BudgetStudent("Лебедев Максим", 19, "ИТП-21",
            new SessionResult(new int[]{7, 7, 6, 7, 8}, true)));
        students.add(new BudgetStudent("Кузнецов Никита", 20, "ИТП-21",
            new SessionResult(new int[]{6, 7, 8, 7, 6}, true)));

        // Дополнительные студенты для демонстрации
        students.add(new BudgetStudent("Попов Василий", 19, "ИТП-21",
            new SessionResult(new int[]{9, 10, 9, 8, 10}, true))); // +50%
        students.add(new BudgetStudent("Васильев Павел", 20, "ИТП-21",
            new SessionResult(new int[]{4, 5, 4, 5, 4}, true))); // без стипендии
        students.add(new PaidStudent("Зайцев Олег", 19, "ИТП-21",
            new SessionResult(new int[]{7, 8, 7, 9, 8}, true))); // платный
        students.add(new PaidStudent("Павлов Игорь", 20, "ИТП-21",
            new SessionResult(new int[]{6, 7, 8, 7, 6}, true))); // платный
    }

    /**
     * Отображает главное меню приложения.
     */
    private static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            clearConsole();
            System.out.println("\n=== Меню системы учёта стипендий ===");
            System.out.println("1. Вывод информации о всех студентах");
            System.out.println("2. Вывод студентов со стипендией +25%");
            System.out.println("3. Вывод студентов на платной основе");
            System.out.println("4. Вывод среднего балла по всем студентам");
            System.out.println("5. Вывод студентов без стипендии");
            System.out.println("6. Добавление нового студента");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        printAllStudents();
                        break;
                    case 2:
                        printStudentsWith25PercentScholarship();
                        break;
                    case 3:
                        printPaidStudents();
                        break;
                    case 4:
                        printAverageGrade();
                        break;
                    case 5:
                        printStudentsWithoutScholarship();
                        break;
                    case 6:
                        addNewStudent(scanner);
                        break;
                    case 0:
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Неверный пункт меню.");
                }
                if (choice != 0) {
                    System.out.print("\nНажмите Enter для продолжения...");
                    scanner.nextLine(); // Ждет нажатия Enter перед очисткой экрана
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода. Введите число.");
                choice = -1;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void printAllStudents() {
        System.out.println("\n--- Информация о всех студентах ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getInfo());
        }
    }

    private static void printStudentsWith25PercentScholarship() {
        System.out.println("\n--- Студенты со стипендией +25% ---");
        boolean found = false;
        for (Student student : students) {
            if (student instanceof BudgetStudent) {
                BudgetStudent bs = (BudgetStudent) student;
                double avg = bs.getSessionResult().getAverageGrade();
                if (avg >= 6 && avg < 8 && bs.getSessionResult().isPassedOnTime()) {
                    System.out.println(bs.getInfo());
                    found = true;
                }
            }
        }
        if (!found) System.out.println("Студенты не найдены.");
    }

    private static void printPaidStudents() {
        System.out.println("\n--- Студенты на платной основе ---");
        boolean found = false;
        for (Student student : students) {
            if (student instanceof PaidStudent) {
                System.out.println(student.getInfo());
                found = true;
            }
        }
        if (!found) System.out.println("Платные студенты не найдены.");
    }

    private static void printAverageGrade() {
        System.out.println("\n--- Средний балл по всем студентам ---");
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        double totalSum = 0;
        int totalGrades = 0;

        for (Student student : students) {
            SessionResult result;
            if (student instanceof BudgetStudent) {
                result = ((BudgetStudent) student).getSessionResult();
            } else if (student instanceof PaidStudent) {
                result = ((PaidStudent) student).getSessionResult();
            } else {
                continue;
            }

            for (int grade : result.getGrades()) {
                totalSum += grade;
                totalGrades++;
            }
        }

        if (totalGrades > 0) {
            double average = totalSum / totalGrades;
            System.out.println("Средний балл: " + String.format("%.2f", average));
        }
    }

    private static void printStudentsWithoutScholarship() {
        System.out.println("\n--- Студенты без стипендии ---");
        boolean found = false;

        for (Student student : students) {
            if (student instanceof PaidStudent) {
                System.out.println(student.getInfo());
                found = true;
            } else if (student instanceof BudgetStudent) {
                BudgetStudent bs = (BudgetStudent) student;
                SessionResult result = bs.getSessionResult();
                if (!result.isPassedOnTime() || result.getAverageGrade() < 5) {
                    System.out.println(bs.getInfo());
                    found = true;
                }
            }
        }

        if (!found) System.out.println("Все студенты получают стипендию.");
    }

    private static void addNewStudent(Scanner scanner) {
        System.out.println("\n--- Добавление нового студента ---");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите группу: ");
        String group = scanner.nextLine();
        System.out.print("Форма обучения (Бюджетная/Платная): ");
        String form = scanner.nextLine();
        System.out.print("Сдана сессия в срок? (true/false): ");
        boolean passedOnTime = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Количество оценок: ");
        int count = Integer.parseInt(scanner.nextLine());
        int[] grades = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Оценка " + (i + 1) + ": ");
            grades[i] = Integer.parseInt(scanner.nextLine());
        }

        SessionResult result = new SessionResult(grades, passedOnTime);

        if (form.equalsIgnoreCase("Бюджетная")) {
            students.add(new BudgetStudent(name, age, group, result));
            System.out.println("Бюджетный студент добавлен.");
        } else {
            students.add(new PaidStudent(name, age, group, result));
            System.out.println("Платный студент добавлен.");
        }
    }

    private static void clearConsole() {
        try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Запасной вариант: выводим 50 пустых строк, если команда не сработала
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
}