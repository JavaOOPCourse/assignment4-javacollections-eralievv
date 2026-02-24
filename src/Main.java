import model.Issue;
import service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        AppointmentService appointmentService = new AppointmentService();
        IssueService issueService = new IssueService();
        ActionHistoryService actionService = new ActionHistoryService();

        // Заполняем стартовыми данными (если у тебя уже есть seed() в сервисах)
        studentService.seed();
        appointmentService.seed();
        issueService.seed();
        actionService.seed();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== 🎓 Smart University Service System =====");
            System.out.println("1. Show Students");
            System.out.println("2. Show Appointments");
            System.out.println("3. Show Emergency Issues");
            System.out.println("4. Show Action History");
            System.out.println("5. Add New Issue");
            System.out.println("6. Undo Action");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            // Защита от ввода не-числа
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number ❌");
                scanner.next(); // выбросить неправильный ввод
                System.out.print("Choose option: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // 🔥 СЪЕСТЬ ENTER после nextInt()

            switch (choice) {
                case 1:
                    // Показать студентов через Iterator
                    studentService.printAllStudentsWithIterator();
                    break;

                case 2:
                    // Показать консультации + first/last + Iterator
                    appointmentService.showFirstAndLast();
                    appointmentService.printAllWithIterator();
                    break;

                case 3:
                    // Показать самую срочную + вывести все оставшиеся
                    issueService.showMostUrgentIssue();
                    issueService.printRemainingWithIterator();
                    break;

                case 4:
                    // Показать историю действий
                    actionService.showFirstAndLast();
                    actionService.printAll();
                    break;

                case 5:
                    // Добавить новую проблему в PriorityQueue
                    System.out.print("Enter issue description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter urgency level (1 = most urgent): ");
                    int urgency;
                    while (!scanner.hasNextInt()) {
                        System.out.println("Urgency must be a number ❌");
                        scanner.next();
                        System.out.print("Enter urgency level (1 = most urgent): ");
                    }
                    urgency = scanner.nextInt();
                    scanner.nextLine(); // съесть Enter

                    issueService.addIssue(new Issue(description, urgency));
                    System.out.println("✅ Issue added!");
                    break;

                case 6:
                    // Undo действие (stack behavior)
                    actionService.undoLastAction();
                    break;

                case 7:
                    System.out.println("Exiting... 👋");
                    break;

                default:
                    System.out.println("Invalid option ❌");
            }

        } while (choice != 7);

        scanner.close();
    }
}