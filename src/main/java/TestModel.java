import entity.Model;
import service.ModelService;
import service.impl.ModelServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestModel {
    public static void main(String[] args) throws SQLException {
        ModelService modelService = new ModelServiceImpl();
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

            if (userCommand.equals("0")) { // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand.equals("1")) { // Показать все модели
                List<Model> modelList = modelService.getAllModels();

                for (Model model : modelList) {
                    System.out.println(model);
                }
                System.out.println();

            } else if (userCommand.equals("2")) { // Показать модели по выборке
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - id");
                    System.out.println("2 - Name");
                    System.out.println("3 - Completion's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    if (userCommand.equals("0")) { // Выход в предыдущее меню
                        System.out.println("Exit to the previous menu.\n");
                        break;

                    } else if (userCommand.equals("1")) { // Выборка по id
                        System.out.println("Enter the model's id:");
                        String id = scanner.nextLine();

                        List<Model> modelList = modelService.getById(id);

                        for (Model model : modelList) {
                            System.out.println(model);
                        }
                        System.out.println();

                    } else if (userCommand.equals("2")) { // Выборка по названию
                        System.out.println("Enter the name:");
                        String name = scanner.nextLine();

                        List<Model> modelList = modelService.getByName(name);

                        for (Model model : modelList) {
                            System.out.println(model);
                        }
                        System.out.println();

                    } else if (userCommand.equals("3")) { // Выборка по id комплектации
                        System.out.println("Enter the completion's id:");
                        String idCompletion = scanner.nextLine();

                        List<Model> modelList = modelService.getByIdCompletion(idCompletion);

                        for (Model model : modelList) {
                            System.out.println(model);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("3")) { // Создать новую модель
                System.out.println("Enter the name of the new model:");
                String name = scanner.nextLine();
                System.out.println("Enter the completion's id of the new model:");
                String idCompletion = scanner.nextLine();

                List<Model> modelList = modelService.create(name, idCompletion);

                System.out.println("New model's record has been created:");
                for (Model model : modelList) {
                    System.out.println(model);
                }
                System.out.println();

            } else if (userCommand.equals("4")) { // Изменить модель
                System.out.println("Enter the model's id:");
                String id = scanner.nextLine();
                System.out.println("Enter a new name for the model's record to edit:");
                String name = scanner.nextLine();
                System.out.println("Enter a new completion's id for the model's record to edit:");
                String idCompletion = scanner.nextLine();

                List<Model> modelList = modelService.update(id, name, idCompletion);

                System.out.println("The model's record has been changed:");
                for (Model model : modelList) {
                    System.out.println(model);
                }
                System.out.println();

            } else if (userCommand.equals("5")) { // Удалить модель
                System.out.println("Enter the model's id:");
                String id = scanner.nextLine();

                List<Model> modelList = modelService.delete(id);

                System.out.println("The model's record has been deleted:");
                for (Model model : modelList) {
                    System.out.println(model);
                }
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
