package output;

import service.CompletionService;
import service.impl.CompletionServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

/**
 * The CompletionOutput class provides a main method for interacting with the completion service.
 * This class includes a menu for performing various operations related to completions.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CompletionOutput {
    public static void main(String[] args) throws SQLException {
        CompletionService completionService = new CompletionServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("1 - Show all completions");
            System.out.println("2 - Show completions by the sample");
            System.out.println("3 - Create a new completion");
            System.out.println("4 - Change a completion");
            System.out.println("5 - Delete a completion");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Exiting the program and releasing resources
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Show all completions
            } else if (userCommand.equals("1")) {
                completionService.getAllCompletions().forEach(System.out::println);
                System.out.println();

                // Show completions by selection
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Completion's id");
                    System.out.println("2 - Completion's name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Sampling by completion's id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the completion's id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());

                        System.out.println(completionService.getCompletionByCompletionId(completionId));
                        System.out.println();

                        // Sampling by completion's name
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the completion's name:");
                        String completionName = scanner.nextLine();

                        System.out.println(completionService.getCompletionByCompletionName(completionName));
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new completion
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the completion's name of the new completion:");
                completionService.create(scanner.nextLine());

                System.out.println("New completion's record has been created.\n");

                // Change the completion
            } else if (userCommand.equals("4")) {

                // Completion change menu
                while (true) {
                    System.out.println("1 - Change a completion's name");
                    System.out.println("2 - Add a car's option to the completion");
                    System.out.println("3 - Delete a car's option from the completion");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Change the completion's name
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the completion's id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());
                        System.out.println("Enter a new name for the completion's record to edit:");
                        String completionName = scanner.nextLine();

                        completionService.update(completionId, completionName);
                        System.out.println("The completion's name has been changed.\n");

                        // Add an option
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the completion's id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());
                        System.out.println("Enter the option's id:");
                        UUID optionId = UUID.fromString(scanner.nextLine());

                        completionService.addCarOption(completionId, optionId);
                        System.out.println("The option has been added.\n");

                        // Delete an option
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the completion's id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());
                        System.out.println("Enter the option's id:");
                        UUID optionId = UUID.fromString(scanner.nextLine());

                        completionService.deleteCarOption(completionId, optionId);
                        System.out.println("The option has been deleted.\n");

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Delete a completion
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the completion's id:");
                UUID completionId = UUID.fromString(scanner.nextLine());

                completionService.delete(completionId);
                System.out.println("The completion's record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
