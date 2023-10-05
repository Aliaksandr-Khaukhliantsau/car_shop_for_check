package outputToTheConsole;

import entity.CompletionCarOption;
import service.CompletionCarOptionService;
import service.impl.CompletionCarOptionServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CompletionCarOptionOutput {
    public static void main(String[] args) throws SQLException {
        CompletionCarOptionService completionCarOptionService = new CompletionCarOptionServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all completionscaroptions");
            System.out.println("2 - Show completionscaroptions by the sample");
            System.out.println("3 - Create a new completionscaroption");
            System.out.println("4 - Delete a completionscaroption");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать все completionscaroptions
            } else if (userCommand.equals("1")) {
                List<CompletionCarOption> completionCarOptionList = completionCarOptionService.getAllCompletionCarOptions();

                for (CompletionCarOption completionCarOption : completionCarOptionList) {
                    System.out.println(completionCarOption);
                }
                System.out.println();

                // Показать опции по выборке
            } else if (userCommand.equals("2")) {
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Completion's id");
                    System.out.println("2 - Option's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id комплектации
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the customer's id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());

                        List<CompletionCarOption> completionCarOptionList = completionCarOptionService.getCompletionCarOptionByCompletionId(completionId);

                        for (CompletionCarOption completionCarOption : completionCarOptionList) {
                            System.out.println(completionCarOption);
                        }
                        System.out.println();

                        // Выборка по id опции
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the option's id:");
                        UUID optionId = UUID.fromString(scanner.nextLine());

                        List<CompletionCarOption> completionCarOptionList = completionCarOptionService.getCompletionCarOptionByOptionId(optionId);

                        for (CompletionCarOption completionCarOption : completionCarOptionList) {
                            System.out.println(completionCarOption);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать новый completionscaroption
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the completion's id of the new completioscaroption:");
                UUID completionId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter the option's id of the new completioscaroption:");
                UUID optionId = UUID.fromString(scanner.nextLine());

                completionCarOptionService.create(completionId, optionId);

                System.out.println("New completioscaroption's record has been created.");
                System.out.println();

                // Удалить completiosoption
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the completion's id:");
                UUID completionId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter the option's id:");
                UUID optionId = UUID.fromString(scanner.nextLine());

                completionCarOptionService.delete(completionId, optionId);

                System.out.println("The completioscaroption's record has been deleted.");
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
