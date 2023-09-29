import entity.Completion;
import service.CompletionService;
import service.impl.CompletionServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestCompletion {
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

            if (userCommand.equals("0")) { // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand.equals("1")) { // Показать все комплектации
                List<Completion> completionList = completionService.getAllCompletions();

                for (Completion completion : completionList) {
                    System.out.println(completion);
                }
                System.out.println();

            } else if (userCommand.equals("2")) { // Показать комплектации по выборке
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - id");
                    System.out.println("2 - Name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    if (userCommand.equals("0")) { // Выход в предыдущее меню
                        System.out.println("Exit to the previous menu.\n");
                        break;

                    } else if (userCommand.equals("1")) { // Выборка по id
                        System.out.println("Enter the id:");
                        String id = scanner.nextLine();

                        List<Completion> completionList = completionService.getById(id);

                        for (Completion completion : completionList) {
                            System.out.println(completion);
                        }
                        System.out.println();

                    } else if (userCommand.equals("2")) { // Выборка по названию
                        System.out.println("Enter the name:");
                        String name = scanner.nextLine();

                        List<Completion> completionList = completionService.getByName(name);

                        for (Completion completion : completionList) {
                            System.out.println(completion);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("3")) { // Создать новую комплектацию
                System.out.println("Enter the name of the new completion:");
                String name = scanner.nextLine();

                List<Completion> completionList = completionService.create(name);

                System.out.println("New completion's record has been created:");
                for (Completion completion : completionList) {
                    System.out.println(completion);
                }
                System.out.println();

            } else if (userCommand.equals("4")) { // Изменить комплектацию
                System.out.println("Enter the completion's id:");
                String id = scanner.nextLine();
                System.out.println("Enter a new name for the completion's record to edit:");
                String name = scanner.nextLine();

                List<Completion> completionList = completionService.update(id, name);

                System.out.println("The completion's record has been changed:");
                for (Completion completion : completionList) {
                    System.out.println(completion);
                }
                System.out.println();

            } else if (userCommand.equals("5")) { // Удалить комплектацию
                System.out.println("Enter the completion's id:");
                String id = scanner.nextLine();

                List<Completion> completionList = completionService.delete(id);

                System.out.println("The completion's record has been deleted:");
                for (Completion completion : completionList) {
                    System.out.println(completion);
                }
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
