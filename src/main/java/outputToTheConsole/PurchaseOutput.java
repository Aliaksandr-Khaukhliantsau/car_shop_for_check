package outputToTheConsole;

import service.PurchaseService;
import service.impl.PurchaseServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

/**
 * The PurchaseOutput class provides a main method for interacting with the purchase service.
 * This class includes a menu for performing various operations related to purchases.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class PurchaseOutput {
    public static void main(String[] args) throws SQLException {
        PurchaseService purchaseService = new PurchaseServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("1 - Show all purchases");
            System.out.println("2 - Show purchases by the sample");
            System.out.println("3 - Create a new purchase");
            System.out.println("4 - Change an purchase");
            System.out.println("5 - Delete an purchase");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Exiting the program and releasing resources
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Show all purchases
            } else if (userCommand.equals("1")) {
                purchaseService.getAllPurchases().forEach(System.out::println);
                System.out.println();

                // Show purchases by selection
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Purchase's id");
                    System.out.println("2 - Purchase's number");
                    System.out.println("3 - Customer's id");
                    System.out.println("4 - Car's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Sampling by purchase's id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the purchase's id:");
                        UUID purchaseId = UUID.fromString(scanner.nextLine());

                        System.out.println(purchaseService.getPurchaseByPurchaseId(purchaseId));
                        System.out.println();

                        // Sampling by purchase's number
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the purchase's number:");
                        String purchaseNumber = scanner.nextLine();

                        System.out.println(purchaseService.getPurchaseByPurchaseNumber(purchaseNumber));
                        System.out.println();

                        // Sampling by customer's id
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the customer's id:");
                        UUID customerId = UUID.fromString(scanner.nextLine());

                        purchaseService.getPurchaseByCustomerId(customerId).forEach(System.out::println);
                        System.out.println();

                        // Sampling by car's id
                    } else if (userCommand.equals("4")) {
                        System.out.println("Enter the car's id:");
                        UUID carId = UUID.fromString(scanner.nextLine());

                        purchaseService.getPurchaseByCarId(carId).forEach(System.out::println);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new purchase
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the customer's id of the new purchase:");
                UUID customerId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter the car's id of the new purchase:");
                UUID carId = UUID.fromString(scanner.nextLine());

                purchaseService.create(customerId, carId);
                System.out.println("New purchase's record has been created.\n");

                // Change a purchase
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the purchase's id:");
                UUID purchaseId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new customer's id for the purchase's record to edit:");
                UUID customerId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new car's id for the purchase's record to edit:");
                UUID carId = UUID.fromString(scanner.nextLine());

                purchaseService.update(purchaseId, customerId, carId);
                System.out.println("The purchase's record has been changed.\n");

                // Delete a purchase
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the purchase's id:");
                UUID purchaseId = UUID.fromString(scanner.nextLine());

                purchaseService.delete(purchaseId);
                System.out.println("The purchase's record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
