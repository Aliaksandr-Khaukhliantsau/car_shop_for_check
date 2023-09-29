import entity.Car;
import service.CarService;
import service.impl.CarServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestCar {
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

            if (userCommand.equals("0")) { // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand.equals("1")) { // Показать все автомобили
                List<Car> carList = carService.getAllCars();

                for (Car car : carList) {
                    System.out.println(car);
                }
                System.out.println();

            } else if (userCommand.equals("2")) { // Показать автомобиль по выборке

                while (true) { // Меню выборки
                    System.out.println("Select a sample:");
                    System.out.println("1 - id");
                    System.out.println("2 - VIN");
                    System.out.println("3 - Model's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    if (userCommand.equals("0")) { // Выход в предыдущее меню
                        System.out.println("Exit to the previous menu.\n");
                        break;

                    } else if (userCommand.equals("1")) { // Выборка по id
                        System.out.println("Enter the car's id:");
                        String id = scanner.nextLine();

                        List<Car> carList = carService.getById(id);

                        for (Car car : carList) {
                            System.out.println(car);
                        }
                        System.out.println();

                    } else if (userCommand.equals("2")) { // Выборка по VIN
                        System.out.println("Enter the VIN:");
                        String vin = scanner.nextLine();

                        List<Car> carList = carService.getByVin(vin);

                        for (Car car : carList) {
                            System.out.println(car);
                        }
                        System.out.println();

                    } else if (userCommand.equals("3")) { // Выборка по id модели
                        System.out.println("Enter the model's id:");
                        String idModel = scanner.nextLine();

                        List<Car> carList = carService.getByIdModel(idModel);

                        for (Car car : carList) {
                            System.out.println(car);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("3")) { // Создать новый автомобиль
                System.out.println("Enter the VIN of the new car:");
                String vin = scanner.nextLine();
                System.out.println("Enter the model's id of the new car:");
                String idModel = scanner.nextLine();

                List<Car> carList = carService.create(vin, idModel);

                System.out.println("New car's record has been created:");
                for (Car car : carList) {
                    System.out.println(car);
                }
                System.out.println();

            } else if (userCommand.equals("4")) { // Изменить автомобиль
                System.out.println("Enter the car's id:");
                String id = scanner.nextLine();
                System.out.println("Enter a new VIN for the car's record to edit:");
                String vin = scanner.nextLine();
                System.out.println("Enter a new model's id for the car's record to edit:");
                String idModel = scanner.nextLine();

                List<Car> carList = carService.update(id, vin, idModel);

                System.out.println("The car's record has been changed:");
                for (Car car : carList) {
                    System.out.println(car);
                }
                System.out.println();

            } else if (userCommand.equals("5")) { // Удалить автомобиль
                System.out.println("Enter the car's id:");
                String id = scanner.nextLine();

                List<Car> carList = carService.delete(id);

                System.out.println("The car's record has been deleted:");
                for (Car car : carList) {
                    System.out.println(car);
                }
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
