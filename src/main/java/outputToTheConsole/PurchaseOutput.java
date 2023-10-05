package outputToTheConsole;

import entity.Purchase;
import service.PurchaseService;
import service.impl.PurchaseServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class PurchaseOutput {
    public static void main(String[] args) throws SQLException {
        PurchaseService purchaseService = new PurchaseServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all purchases");
            System.out.println("2 - Show purchases by the sample");
            System.out.println("3 - Create a new purchase");
            System.out.println("4 - Change an purchase");
            System.out.println("5 - Delete an purchase");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать все заказы
            } else if (userCommand.equals("1")) {
                List<Purchase> purchaseList = purchaseService.getAllPurchases();

                for (Purchase purchase : purchaseList) {
                    System.out.println(purchase);
                }
                System.out.println();

                // Показать заказы по выборке
            } else if (userCommand.equals("2")) {

                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Purchase's id");
                    System.out.println("2 - Purchase's number");
                    System.out.println("3 - Customer's id");
                    System.out.println("4 - Car's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id заказа
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the purchase's id:");
                        UUID purchaseId = UUID.fromString(scanner.nextLine());

                        Purchase purchase = purchaseService.getPurchaseByPurchaseId(purchaseId);

                        System.out.println(purchase);
                        System.out.println();

                        // Выборка по номеру заказа
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the purchase's number:");
                        String purchaseNumber = scanner.nextLine();

                        Purchase purchase = purchaseService.getPurchaseByPurchaseNumber(purchaseNumber);

                        System.out.println(purchase);
                        System.out.println();

                        // Выборка по id клиента
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the customer's id:");
                        UUID customerId = UUID.fromString(scanner.nextLine());

                        List<Purchase> purchaseList = purchaseService.getPurchaseByCustomerId(customerId);

                        for (Purchase purchase : purchaseList) {
                            System.out.println(purchase);
                        }
                        System.out.println();

                        // Выборка по id автомобиля
                    } else if (userCommand.equals("4")) {
                        System.out.println("Enter the car's id:");
                        UUID carId = UUID.fromString(scanner.nextLine());

                        List<Purchase> purchaseList = purchaseService.getPurchaseByCarId(carId);

                        for (Purchase purchase : purchaseList) {
                            System.out.println(purchase);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать новый заказ
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the customer's id of the new purchase:");
                UUID customerId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter the car's id of the new purchase:");
                UUID carId = UUID.fromString(scanner.nextLine());

                purchaseService.create(customerId, carId);

                System.out.println("New purchase's record has been created.");
                System.out.println();

                // Изменить заказ
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the purchase's id:");
                UUID purchaseId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new customer's id for the purchase's record to edit:");
                UUID customerId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new car's id for the purchase's record to edit:");
                UUID carId = UUID.fromString(scanner.nextLine());

                purchaseService.update(purchaseId, customerId, carId);

                System.out.println("The purchase's record has been changed.");
                System.out.println();

                // Удалить заказ
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the purchase's id:");
                UUID purchaseId = UUID.fromString(scanner.nextLine());

                purchaseService.delete(purchaseId);

                System.out.println("The purchase's record has been deleted.");
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
