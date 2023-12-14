package car.shop.ouptut;

import car.shop.service.CompletionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication(scanBasePackages = {"car.shop"})
@EntityScan("car.shop.entity")
public class CompletionOutput {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CompletionOutput.class);
        CompletionService completionService = context.getBean(CompletionService.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Show all completions");
            System.out.println("2 - Show completions by the sample");
            System.out.println("3 - Create a new completion");
            System.out.println("4 - Change a completion");
            System.out.println("5 - Delete a completion");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand.equals("1")) {
                completionService.getAll().forEach(System.out::println);
                System.out.println();

            } else if (userCommand.equals("2")) {

                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Completion id");
                    System.out.println("2 - Completion name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the completion id:");
                        UUID id = UUID.fromString(scanner.nextLine());

                        System.out.println(completionService.getById(id));
                        System.out.println();

                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the completion name:");
                        String completionName = scanner.nextLine();

                        System.out.println(completionService.getByCompletionName(completionName));
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("3")) {
                System.out.println("Enter the completion name of the new completion:");
                completionService.create(scanner.nextLine());
                System.out.println("New completion record has been created.\n");

            } else if (userCommand.equals("4")) {

                while (true) {
                    System.out.println("1 - Change a completion name");
                    System.out.println("2 - Add a setting to the completion");
                    System.out.println("3 - Remove a setting from the completion");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the completion id:");
                        UUID id = UUID.fromString(scanner.nextLine());
                        System.out.println("Enter a new name for the completion record to edit:");
                        String completionName = scanner.nextLine();
                        completionService.update(id, completionName);
                        System.out.println("The completion name has been changed.\n");

                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the completion id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());
                        System.out.println("Enter the setting id:");
                        UUID settingId = UUID.fromString(scanner.nextLine());
                        completionService.addSettingToCompletion(completionId, settingId);
                        System.out.println("The setting has been added to the completion.\n");

                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the completion id:");
                        UUID completionId = UUID.fromString(scanner.nextLine());
                        System.out.println("Enter the setting id:");
                        UUID settingId = UUID.fromString(scanner.nextLine());
                        completionService.removeSettingFromCompletion(completionId, settingId);
                        System.out.println("The setting has been removed from the completion.\n");

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("5")) {
                System.out.println("Enter the completion id:");
                UUID id = UUID.fromString(scanner.nextLine());
                completionService.delete(id);
                System.out.println("The completion record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
