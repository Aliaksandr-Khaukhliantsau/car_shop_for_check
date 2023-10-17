package output;

import service.CarService;
import service.impl.CarServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

/**
 * The CarOutput class provides a main method for interacting with the car service.
 * This class includes a menu for performing various operations related to cars.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CarOutput {
    public static void main(String[] args) throws SQLException {
        CarService carService = new CarServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("1 - Show all cars");
            System.out.println("2 - Show cars by the sample");
            System.out.println("3 - Create a new car");
            System.out.println("4 - Change a car");
            System.out.println("5 - Delete a car");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Exiting the program and releasing resources
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Show all cars
            } else if (userCommand.equals("1")) {
                carService.getAll().forEach(System.out::println);
                System.out.println();

                // Show car by selection
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Car id");
                    System.out.println("2 - VIN");
                    System.out.println("3 - Layout id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Sampling by car id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the car id:");
                        UUID id = UUID.fromString(scanner.nextLine());

                        System.out.println(carService.getById(id));
                        System.out.println();

                        // Sampling by VIN
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the VIN:");
                        String vin = scanner.nextLine();

                        System.out.println(carService.getByVin(vin));
                        System.out.println();

                        // Sampling by layout id
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the layout id:");
                        UUID layoutId = UUID.fromString(scanner.nextLine());

                        carService.getByLayoutId(layoutId).forEach(System.out::println);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new car
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the VIN of the new car:");
                String vin = scanner.nextLine();
                System.out.println("Enter the layout id of the new car:");
                UUID layoutId = UUID.fromString(scanner.nextLine());

                carService.create(vin, layoutId);
                System.out.println("New car record has been created.\n");

                // Change a car
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the car id:");
                UUID id = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new VIN for the car record to edit:");
                String vin = scanner.nextLine();
                System.out.println("Enter a new layout id for the car record to edit:");
                UUID layoutId = UUID.fromString(scanner.nextLine());

                carService.update(id, vin, layoutId);
                System.out.println("The car record has been changed.\n");

                // Delete a car
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the car id:");
                UUID id = UUID.fromString(scanner.nextLine());

                carService.delete(id);
                System.out.println("The car record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
