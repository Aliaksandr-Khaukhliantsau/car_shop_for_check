package outputToTheConsole;

import service.CarService;
import service.impl.CarServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class CarOutput {
    public static void main(String[] args) throws SQLException {
        CarService carService = new CarServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) { // Основное меню
            System.out.println("1 - Show all cars");
            System.out.println("2 - Show cars by the sample");
            System.out.println("3 - Create a new car");
            System.out.println("4 - Change a car");
            System.out.println("5 - Delete a car");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать все автомобили
            } else if (userCommand.equals("1")) {
                carService.getAllCars().forEach(System.out::println);
                System.out.println();

                // Показать автомобиль по выборке
            } else if (userCommand.equals("2")) {

                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Car's id");
                    System.out.println("2 - VIN");
                    System.out.println("3 - Model's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id автомобиля
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the car's id:");
                        UUID carId = UUID.fromString(scanner.nextLine());

                        System.out.println(carService.getCarByCarId(carId));
                        System.out.println();

                        // Выборка по VIN
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the VIN:");
                        String vin = scanner.nextLine();

                        System.out.println(carService.getCarByVin(vin));
                        System.out.println();

                        // Выборка по id модели
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the model's id:");
                        UUID modelId = UUID.fromString(scanner.nextLine());

                        carService.getCarByModelId(modelId).forEach(System.out::println);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать новый автомобиль
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the VIN of the new car:");
                String vin = scanner.nextLine();
                System.out.println("Enter the model's id of the new car:");
                UUID modelId = UUID.fromString(scanner.nextLine());

                carService.create(vin, modelId);

                System.out.println("New car's record has been created.");
                System.out.println();

                // Изменить автомобиль
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the car's id:");
                UUID carId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new VIN for the car's record to edit:");
                String vin = scanner.nextLine();
                System.out.println("Enter a new model's id for the car's record to edit:");
                UUID modelId = UUID.fromString(scanner.nextLine());

                carService.update(carId, vin, modelId);

                System.out.println("The car's record has been changed.");
                System.out.println();

                // Удалить автомобиль
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the car's id:");
                UUID carId = UUID.fromString(scanner.nextLine());

                carService.delete(carId);

                System.out.println("The car's record has been deleted.");
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
