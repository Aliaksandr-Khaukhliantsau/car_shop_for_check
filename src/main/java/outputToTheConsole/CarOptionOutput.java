package outputToTheConsole;

import service.CarOptionService;
import service.impl.CarOptionServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

/**
 * The CarOptionOutput class provides a main method for interacting with the car option service.
 * This class includes a menu for performing various operations related to car options.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CarOptionOutput {
    public static void main(String[] args) throws SQLException {
        CarOptionService carOptionService = new CarOptionServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("1 - Show all options");
            System.out.println("2 - Show options by the sample");
            System.out.println("3 - Create a new option");
            System.out.println("4 - Change an option");
            System.out.println("5 - Delete an option");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Exiting the program and releasing resources
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Show all options
            } else if (userCommand.equals("1")) {
                carOptionService.getAllCarOptions().forEach(System.out::println);
                System.out.println();

                // Show options by selection
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Option's id");
                    System.out.println("2 - Option's name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Sampling by option's id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the option's id:");
                        UUID optionId = UUID.fromString(scanner.nextLine());

                        System.out.println(carOptionService.getCarOptionByOptionId(optionId));
                        System.out.println();

                        // Sampling by option's name
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the option's name:");
                        String optionName = scanner.nextLine();

                        System.out.println(carOptionService.getCarOptionByOptionName(optionName));
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new option
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the option's name of the new option:");
                String optionName = scanner.nextLine();

                carOptionService.create(optionName);
                System.out.println("New option's record has been created.\n");

                // Change the option
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the option's id:");
                UUID optionId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new name for the option's record to edit:");
                String optionName = scanner.nextLine();

                carOptionService.update(optionId, optionName);
                System.out.println("The option's record has been changed.\n");

                // Delete an option
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the option's id:");
                UUID optionId = UUID.fromString(scanner.nextLine());

                carOptionService.delete(optionId);
                System.out.println("The option's record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
