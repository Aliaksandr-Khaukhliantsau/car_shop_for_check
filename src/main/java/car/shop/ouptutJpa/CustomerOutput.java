package car.shop.ouptutJpa;

import car.shop.configurationJpa.AppConfig;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import car.shop.dtoJpa.CustomerDto;
import car.shop.serviceJpa.CustomerService;
import java.util.Scanner;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"car.shop"})
@EntityScan("car.shop.entityJpa")
public class CustomerOutput {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CustomerOutput.class, args);
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        Scanner scanner = new Scanner(System.in);

        // Main menu
        while (true) {
            System.out.println("1 - Show all customers");
            System.out.println("2 - Show customers by the sample");
            System.out.println("3 - Create a new customer");
            System.out.println("4 - Change a customer");
            System.out.println("5 - Delete a customer");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Exiting the program and releasing resources
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Show all customers
            } else if (userCommand.equals("1")) {
                customerService.getAll().forEach(System.out::println);
                System.out.println();

                // Show customers by sample
            } else if (userCommand.equals("2")) {

                // Selection menu
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Customer id");
                    System.out.println("2 - First name");
                    System.out.println("3 - Middle name");
                    System.out.println("4 - Last name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Exit to the previous menu
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Selection by customer id
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the customer id:");
                        UUID id = UUID.fromString(scanner.nextLine());

                        System.out.println(customerService.getById(id));
                        System.out.println();

                        // Selection by first name
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the first name:");
                        String firstName = scanner.nextLine();

                        customerService.getByFirstName(firstName).forEach(System.out::println);
                        System.out.println();

                        // Selection by middle name
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the middle name:");
                        String middleName = scanner.nextLine();

                        // Implement this method based on your business logic
                        System.out.println();

                        // Selection by last name
                    } else if (userCommand.equals("4")) {
                        System.out.println("Enter the last name:");
                        String lastName = scanner.nextLine();

                        customerService.getByLastName(lastName).forEach(System.out::println);
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Create a new customer
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the first name of the new customer:");
                String firstName = scanner.nextLine();
                System.out.println("Enter the middle name of the new customer:");
                String middleName = scanner.nextLine();
                System.out.println("Enter the last name of the new customer:");
                String lastName = scanner.nextLine();

                customerService.create(firstName, middleName, lastName);
                System.out.println("New customer's record has been created.\n");

                // Change a customer
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the customer id:");
                UUID id = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new first name for the customer record to edit:");
                String firstName = scanner.nextLine();
                System.out.println("Enter a new middle name for the customer record to edit:");
                String middleName = scanner.nextLine();
                System.out.println("Enter a new last name for the customer record to edit:");
                String lastName = scanner.nextLine();

                customerService.update(id, firstName, middleName, lastName);
                System.out.println("The customer record has been changed.\n");

                // Delete a customer
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the customer id:");
                UUID id = UUID.fromString(scanner.nextLine());

                customerService.delete(id);
                System.out.println("The customer record has been deleted.\n");

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
