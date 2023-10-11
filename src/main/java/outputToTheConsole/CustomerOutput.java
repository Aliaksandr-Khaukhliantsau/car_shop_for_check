package outputToTheConsole;

import dto.CustomerDto;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CustomerOutput {
    public static void main(String[] args) throws SQLException {
        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all customers");
            System.out.println("2 - Show customers by the sample");
            System.out.println("3 - Create a new customer");
            System.out.println("4 - Change a customer");
            System.out.println("5 - Delete a customer");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать всех клинтов
            } else if (userCommand.equals("1")) {
                List<CustomerDto> customersDto = customerService.getAllCustomers();

                for (CustomerDto customerDto : customersDto) {
                    System.out.println(customerDto);
                }
                System.out.println();

                // Показать клиентов по выборке
            } else if (userCommand.equals("2")) {
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Customer's id");
                    System.out.println("2 - First name");
                    System.out.println("3 - Middle name");
                    System.out.println("4 - Last name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id клиента
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the customer's id:");
                        UUID customerId = UUID.fromString(scanner.nextLine());

                        CustomerDto customerDto = customerService.getCustomerByCustomerId(customerId);

                        System.out.println(customerDto);
                        System.out.println();

                        // Выборка по имени
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the first name:");
                        String firstName = scanner.nextLine();

                        List<CustomerDto> customersDto = customerService.getCustomerByFirstName(firstName);

                        for (CustomerDto customerDto : customersDto) {
                            System.out.println(customerDto);
                        }
                        System.out.println();

                        // Выборка по отчеству
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the middle name:");
                        String middleName = scanner.nextLine();

                        List<CustomerDto> customersDto = customerService.getCustomerByMiddleName(middleName);

                        for (CustomerDto customerDto : customersDto) {
                            System.out.println(customerDto);
                        }
                        System.out.println();

                        // Выборка по фамилии
                    } else if (userCommand.equals("4")) {
                        System.out.println("Enter the last name:");
                        String lastName = scanner.nextLine();

                        List<CustomerDto> customersDto = customerService.getCustomerByLastName(lastName);

                        for (CustomerDto customerDto : customersDto) {
                            System.out.println(customerDto);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать нового клиента
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the first name of the new customer:");
                String firstName = scanner.nextLine();
                System.out.println("Enter the middle name of the new customer:");
                String middleName = scanner.nextLine();
                System.out.println("Enter the last name of the new customer:");
                String lastName = scanner.nextLine();

                customerService.create(firstName, middleName, lastName);

                System.out.println("New customer's record has been created.");
                System.out.println();

                // Изменить клиента
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the customer's id:");
                UUID customerId = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new first name for the customer's record to edit:");
                String firstName = scanner.nextLine();
                System.out.println("Enter a new middle name for the customer's record to edit:");
                String middleName = scanner.nextLine();
                System.out.println("Enter a new last name for the customer's record to edit:");
                String lastName = scanner.nextLine();

                customerService.update(customerId, firstName, middleName, lastName);

                System.out.println("The customer's record has been changed.");
                System.out.println();

                // Удалить клиента
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the customer's id:");
                UUID customerId = UUID.fromString(scanner.nextLine());

                customerService.delete(customerId);

                System.out.println("The customer's record has been deleted.");
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}