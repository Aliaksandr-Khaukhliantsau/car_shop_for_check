package outputToTheConsole;

import service.CarModelService;
import service.impl.CarModelServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class CarModelOutput {
    public static void main(String[] args) throws SQLException {
        CarModelService carModelService = new CarModelServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all models");
            System.out.println("2 - Show models by the sample");
            System.out.println("3 - Create a new model");
            System.out.println("4 - Change a model");
            System.out.println("5 - Delete a model");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать все модели
            } else if (userCommand.equals("1")) {
                carModelService.getAllCarModels().forEach(System.out::println);
                System.out.println();

                // Показать модели по выборке
            } else if (userCommand.equals("2")) {
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Model's id");
                    System.out.println("2 - Model's name");
                    System.out.println("3 - Completion's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the model's id:");
                        UUID modelId = UUID.fromString(scanner.nextLine());

                        System.out.println(carModelService.getCarModelByModelId(modelId));
                        System.out.println();

                        // Выборка по названию
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the model's name:");
                        String modelName = scanner.nextLine();

                        carModelService.getCarModelByModelName(modelName).forEach(System.out::println);
                        System.out.println();

                        // Выборка по id комплектации
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the completion's id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());

                        carModelService.getCarModelByCompletionId(completionId).forEach(System.out::println);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать новую модель
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the name of the new model:");
                String modelName = scanner.nextLine();
                System.out.println("Enter the completion's id of the new model:");
                UUID completionId = UUID.fromString(scanner.nextLine());

                carModelService.create(modelName, completionId);

                System.out.println("New model's record has been created.");
                System.out.println();

                // Изменить модель
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the model's id:");
                UUID modelId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new name for the model's record to edit:");
                String modelName = scanner.nextLine();
                System.out.println("Enter a new completion's id for the model's record to edit:");
                UUID completionId = UUID.fromString(scanner.nextLine());

                carModelService.update(modelId, modelName, completionId);

                System.out.println("The model's record has been changed.");
                System.out.println();

                // Удалить модель
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the model's id:");
                UUID modelId = UUID.fromString(scanner.nextLine());

                carModelService.delete(modelId);

                System.out.println("The model's record has been deleted.");
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
