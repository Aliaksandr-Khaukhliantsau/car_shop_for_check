package output;

import service.SettingService;
import service.impl.SettingServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

/**
 * The SettingOutput class provides a main method for interacting with the car setting service.
 * This class includes a menu for performing various operations related to car settings.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class SettingOutput {
    public static void main(String[] args) throws SQLException {
        SettingService settingService = new SettingServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("1 - Show all settings");
            System.out.println("2 - Show settings by the sample");
            System.out.println("3 - Create a new setting");
            System.out.println("4 - Change a setting");
            System.out.println("5 - Delete a setting");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Exiting the program and releasing resources
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Show all settings
            } else if (userCommand.equals("1")) {
                settingService.getAll().forEach(System.out::println);
                System.out.println();

                // Show settings by selection
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Setting id");
                    System.out.println("2 - Setting name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Sampling by setting id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the setting id:");
                        UUID id = UUID.fromString(scanner.nextLine());

                        System.out.println(settingService.getById(id));
                        System.out.println();

                        // Sampling by setting name
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the setting name:");
                        String settingName = scanner.nextLine();

                        System.out.println(settingService.getBySettingName(settingName));
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new setting
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the setting name of the new setting:");
                String settingName = scanner.nextLine();

                settingService.create(settingName);
                System.out.println("New setting record has been created.\n");

                // Change the setting
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the setting id:");
                UUID id = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new name for the setting record to edit:");
                String settingName = scanner.nextLine();

                settingService.update(id, settingName);
                System.out.println("The setting record has been changed.\n");

                // Delete an setting
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the setting id:");
                UUID id = UUID.fromString(scanner.nextLine());

                settingService.delete(id);
                System.out.println("The setting record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
