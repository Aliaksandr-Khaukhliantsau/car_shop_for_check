package output;

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
                purchaseService.getAll().forEach(System.out::println);
                System.out.println();

                // Show purchases by selection
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Purchase id");
                    System.out.println("2 - Purchase number");
                    System.out.println("3 - Customer id");
                    System.out.println("4 - Car id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Sampling by purchase id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the purchase id:");
                        UUID id = UUID.fromString(scanner.nextLine());

                        System.out.println(purchaseService.getById(id));
                        System.out.println();

                        // Sampling by purchase number
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the purchase number:");
                        String purchaseNumber = scanner.nextLine();

                        System.out.println(purchaseService.getByPurchaseNumber(purchaseNumber));
                        System.out.println();

                        // Sampling by customer id
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the customer id:");
                        UUID customerId = UUID.fromString(scanner.nextLine());

                        purchaseService.getByCustomerId(customerId).forEach(System.out::println);
                        System.out.println();

                        // Sampling by car id
                    } else if (userCommand.equals("4")) {
                        System.out.println("Enter the car id:");
                        UUID carId = UUID.fromString(scanner.nextLine());

                        purchaseService.getByCarId(carId).forEach(System.out::println);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new purchase
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the customer id of the new purchase:");
                UUID customerId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter the car id of the new purchase:");
                UUID carId = UUID.fromString(scanner.nextLine());

                purchaseService.create(customerId, carId);
                System.out.println("New purchase record has been created.\n");

                // Change a purchase
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the purchase id:");
                UUID id = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new customer id for the purchase record to edit:");
                UUID customerId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new car id for the purchase record to edit:");
                UUID carId = UUID.fromString(scanner.nextLine());

                purchaseService.update(id, customerId, carId);
                System.out.println("The purchase's record has been changed.\n");

                // Delete a purchase
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the purchase id:");
                UUID id = UUID.fromString(scanner.nextLine());

                purchaseService.delete(id);
                System.out.println("The purchase record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
