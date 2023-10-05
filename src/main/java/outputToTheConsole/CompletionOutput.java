package outputToTheConsole;

import entity.Completion;
import service.CompletionService;
import service.impl.CompletionServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CompletionOutput {
    public static void main(String[] args) throws SQLException {
        CompletionService completionService = new CompletionServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all completions");
            System.out.println("2 - Show completions by the sample");
            System.out.println("3 - Create a new completion");
            System.out.println("4 - Change a completion");
            System.out.println("5 - Delete a completion");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать все комплектации
            } else if (userCommand.equals("1")) {
                List<Completion> completionList = completionService.getAllCompletions();

                for (Completion completion : completionList) {
                    System.out.println(completion);
                }
                System.out.println();

                // Показать комплектации по выборке
            } else if (userCommand.equals("2")) {
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Completion's id");
                    System.out.println("2 - Completion's name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the completion's id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());

                        Completion completion = completionService.getCompletionByCompletionId(completionId);

                        System.out.println(completion);
                        System.out.println();

                        // Выборка по названию
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the completion's name:");
                        String completionName = scanner.nextLine();

                        Completion completion = completionService.getCompletionByCompletionName(completionName);

                        System.out.println(completion);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать новую комплектацию
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the completion's name of the new completion:");
                String completionName = scanner.nextLine();

                completionService.create(completionName);

                System.out.println("New completion's record has been created:");
                System.out.println();

                // Изменить комплектацию
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the completion's id:");
                UUID completionId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new name for the completion's record to edit:");
                String completionName = scanner.nextLine();

                completionService.update(completionId, completionName);

                System.out.println("The completion's record has been changed:");
                System.out.println();

                // Удалить комплектацию
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the completion's id:");
                UUID completionId = UUID.fromString(scanner.nextLine());

                completionService.delete(completionId);

                System.out.println("The completion's record has been deleted:");
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
