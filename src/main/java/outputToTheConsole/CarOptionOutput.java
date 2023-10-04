package outputToTheConsole;

import entity.CarOption;
import service.CarOptionService;
import service.impl.CarOptionServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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

            if (userCommand.equals("0")) { // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand.equals("1")) { // Показать все опции
                List<CarOption> carOptionList = carOptionService.getAllCarOptions();

                for (CarOption carOption : carOptionList) {
                    System.out.println(carOption);
                }
                System.out.println();

            } else if (userCommand.equals("2")) { // Показать опции по выборке
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

                        List<CarOption> carOptionList = carOptionService.getCarOptionByOptionId(id);

                        for (CarOption carOption : carOptionList) {
                            System.out.println(carOption);
                        }
                        System.out.println();

                    } else if (userCommand.equals("2")) { // Выборка по названию
                        System.out.println("Enter the name:");
                        String name = scanner.nextLine();

                        List<CarOption> carOptionList = carOptionService.getCarOptionByOptionName(name);

                        for (CarOption carOption : carOptionList) {
                            System.out.println(carOption);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("3")) { // Создать новую опцию
                System.out.println("Enter the name of the new option:");
                String name = scanner.nextLine();

                List<CarOption> carOptionList = carOptionService.create(name);

                System.out.println("New option's record has been created:");
                for (CarOption carOption : carOptionList) {
                    System.out.println(carOption);
                }
                System.out.println();

            } else if (userCommand.equals("4")) { // Изменить опцию
                System.out.println("Enter the option's id:");
                String id = scanner.nextLine();
                System.out.println("Enter a new name for the option's record to edit:");
                String name = scanner.nextLine();

                List<CarOption> carOptionList = carOptionService.update(id, name);

                System.out.println("The option's record has been changed:");
                for (CarOption carOption : carOptionList) {
                    System.out.println(carOption);
                }
                System.out.println();

            } else if (userCommand.equals("5")) { // Удалить опцию
                System.out.println("Enter the option's id:");
                String id = scanner.nextLine();

                List<CarOption> carOptionList = carOptionService.delete(id);

                System.out.println("The option's record has been deleted:");
                for (CarOption carOption : carOptionList) {
                    System.out.println(carOption);
                }
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
