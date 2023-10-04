package outputToTheConsole;

import entity.CompletionCarOption;
import service.CompletionCarOptionService;
import service.impl.CompletionCarOptionServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CompletionCarOptionOutput {
    public static void main(String[] args) throws SQLException {
        CompletionCarOptionService completionCarOptionService = new CompletionCarOptionServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all completionsoptions");
            System.out.println("2 - Show completionsoptions by the sample");
            System.out.println("3 - Create a new completionoption");
            System.out.println("4 - Delete a completionoption");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            if (userCommand.equals("0")) { // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand.equals("1")) { // Показать все completionsoptions
                List<CompletionCarOption> completionCarOptionList = completionCarOptionService.getAllCompletionCarOptions();

                for (CompletionCarOption completionCarOption : completionCarOptionList) {
                    System.out.println(completionCarOption);
                }
                System.out.println();

            } else if (userCommand.equals("2")) { // Показать опции по выборке
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Completion's id");
                    System.out.println("2 - Option's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    if (userCommand.equals("0")) { // Выход в предыдущее меню
                        System.out.println("Exit to the previous menu.\n");
                        break;

                    } else if (userCommand.equals("1")) { // Выборка по id комплектации
                        System.out.println("Enter the customer's id:");
                        String idCompletion = scanner.nextLine();

                        List<CompletionCarOption> completionCarOptionList = completionCarOptionService.getCompletionCarOptionByCompletionId(idCompletion);

                        for (CompletionCarOption completionCarOption : completionCarOptionList) {
                            System.out.println(completionCarOption);
                        }
                        System.out.println();

                    } else if (userCommand.equals("2")) { // Выборка по id опции
                        System.out.println("Enter the option's id:");
                        String idOption = scanner.nextLine();

                        List<CompletionCarOption> completionCarOptionList = completionCarOptionService.getCompletionCarOptionByOptionId(idOption);

                        for (CompletionCarOption completionCarOption : completionCarOptionList) {
                            System.out.println(completionCarOption);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("3")) { // Создать новый completiosoption
                System.out.println("Enter the completion's id of the new completiosoption:");
                String idCompletion = scanner.nextLine();
                System.out.println("Enter the option's id of the new completiosoption:");
                String idOption = scanner.nextLine();

                List<CompletionCarOption> completionCarOptionList = completionCarOptionService.create(idCompletion, idOption);

                System.out.println("New completiosoption's record has been created:");
                for (CompletionCarOption completionCarOption : completionCarOptionList) {
                    System.out.println(completionCarOption);
                }
                System.out.println();

            } else if (userCommand.equals("4")) { // Удалить completiosoption
                System.out.println("Enter the completion's id:");
                String idCompletion = scanner.nextLine();
                System.out.println("Enter the option's id:");
                String idOption = scanner.nextLine();

                List<CompletionCarOption> completionCarOptionList = completionCarOptionService.delete(idCompletion, idOption);

                System.out.println("The completiosoption's record has been deleted:");
                for (CompletionCarOption completionCarOption : completionCarOptionList) {
                    System.out.println(completionCarOption);
                }
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
