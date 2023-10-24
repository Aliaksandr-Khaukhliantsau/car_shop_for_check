package output;

import service.LayoutService;
import service.impl.LayoutServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

/**
 * The LayoutOutput class provides a main method for interacting with the car layout service.
 * This class includes a menu for performing various operations related to car layouts.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class LayoutOutput {
    public static void main(String[] args) throws SQLException {
        LayoutService layoutService = new LayoutServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("1 - Show all layouts");
            System.out.println("2 - Show layouts by the sample");
            System.out.println("3 - Create a new layout");
            System.out.println("4 - Change a layout");
            System.out.println("5 - Delete a layout");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Exiting the program and releasing resources
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Show all layouts
            } else if (userCommand.equals("1")) {
                layoutService.getAll().forEach(System.out::println);
                System.out.println();

                // Show layouts by selection
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Layout id");
                    System.out.println("2 - Layout name");
                    System.out.println("3 - Completion id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Sampling by layout id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the layout id:");
                        UUID id = UUID.fromString(scanner.nextLine());

                        System.out.println(layoutService.getById(id));
                        System.out.println();

                        // Sampling by layout name
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the layout name:");
                        String layoutName = scanner.nextLine();

                        layoutService.getByLayoutName(layoutName).forEach(System.out::println);
                        System.out.println();

                        // Sampling by completion id
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the completion id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());

                        layoutService.getByCompletionId(completionId).forEach(System.out::println);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new layout
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the name of the new layout:");
                String layoutName = scanner.nextLine();
                System.out.println("Enter the completion id of the new layout:");
                UUID completionId = UUID.fromString(scanner.nextLine());

                layoutService.create(layoutName, completionId);
                System.out.println("New layout record has been created.\n");

                // Change a layout
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the layout id:");
                UUID id = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new name for the layout record to edit:");
                String layoutName = scanner.nextLine();
                System.out.println("Enter a new completion's id for the layout record to edit:");
                UUID completionId = UUID.fromString(scanner.nextLine());

                layoutService.update(id, layoutName, completionId);
                System.out.println("The layout record has been changed.\n");

                // Delete a layout
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the layout id:");
                UUID id = UUID.fromString(scanner.nextLine());

                layoutService.delete(id);
                System.out.println("The layout record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
