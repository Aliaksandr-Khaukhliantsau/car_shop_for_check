package outputToTheConsole;

import entity.CarOption;
import service.CarOptionService;
import service.impl.CarOptionServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CarOptionOutput {
    public static void main(String[] args) throws SQLException {
        CarOptionService carOptionService = new CarOptionServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all options");
            System.out.println("2 - Show options by the sample");
            System.out.println("3 - Create a new option");
            System.out.println("4 - Change an option");
            System.out.println("5 - Delete an option");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать все опции
            } else if (userCommand.equals("1")) {
                List<CarOption> carOptionList = carOptionService.getAllCarOptions();

                for (CarOption carOption : carOptionList) {
                    System.out.println(carOption);
                }
                System.out.println();

                // Показать опции по выборке
            } else if (userCommand.equals("2")) {
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Option's id");
                    System.out.println("2 - Name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по optionId
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the option's id:");
                        UUID optionId = UUID.fromString(scanner.nextLine());

                        CarOption carOption = carOptionService.getCarOptionByOptionId(optionId);

                        System.out.println(carOption);
                        System.out.println();

                        // Выборка по названию
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the option's name:");
                        String optionName = scanner.nextLine();

                        CarOption carOption = carOptionService.getCarOptionByOptionName(optionName);

                        System.out.println(carOption);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать новую опцию
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the option's name of the new option:");
                String optionName = scanner.nextLine();

                carOptionService.create(optionName);

                System.out.println("New option's record has been created.");
                System.out.println();

                // Изменить опцию
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the option's id:");
                UUID optionId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new name for the option's record to edit:");
                String optionName = scanner.nextLine();

                carOptionService.update(optionId, optionName);

                System.out.println("The option's record has been changed.");
                System.out.println();

                // Удалить опцию
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the option's id:");
                UUID optionId = UUID.fromString(scanner.nextLine());

                carOptionService.delete(optionId);

                System.out.println("The option's record has been deleted.");
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
