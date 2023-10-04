package outputToTheConsole;

import entity.Customer;
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
                List<Customer> customerList = customerService.getAllCustomers();

                for (Customer customer : customerList) {
                    System.out.println(customer);
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

                    if (userCommand.equals("0")) { // Выход в предыдущее меню
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id клиента
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the customer's id:");
                        UUID customerId = UUID.fromString(scanner.nextLine());

                        Customer customer = customerService.getCustomerByCustomerId(customerId);

                        System.out.println(customer);
                        System.out.println();

                        // Выборка по имени
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the first name:");
                        String firstName = scanner.nextLine();

                        List<Customer> customerList = customerService.getCustomerByFirstName(firstName);

                        for (Customer customer : customerList) {
                            System.out.println(customer);
                        }
                        System.out.println();

                        // Выборка по отчеству
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the middle name:");
                        String middleName = scanner.nextLine();

                        List<Customer> customerList = customerService.getCustomerByMiddleName(middleName);

                        for (Customer customer : customerList) {
                            System.out.println(customer);
                        }
                        System.out.println();

                        // Выборка по фамилии
                    } else if (userCommand.equals("4")) {
                        System.out.println("Enter the last name:");
                        String lastName = scanner.nextLine();

                        List<Customer> customerList = customerService.getCustomerByLastName(lastName);

                        for (Customer customer : customerList) {
                            System.out.println(customer);
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
//                List<Customer> customerList = customerService.create(firstName, middleName, lastName);

                System.out.println("New customer's record has been created:");
//                for (Customer customer : customerList) {
//                    System.out.println(customer);
//                }
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

//                List<Customer> customerList = customerService.update(customerId, firstName, middleName, lastName);
                customerService.update(customerId, firstName, middleName, lastName);

                System.out.println("The customer's record has been changed:");
//                for (Customer customer : customerList) {
//                    System.out.println(customer);
//                }
                System.out.println();

                // Удалить клиента
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the customer's id:");
                UUID customerId = UUID.fromString(scanner.nextLine());

//                List<Customer> customerList = customerService.delete(customerId);
                customerService.delete(customerId);

                System.out.println("The customer's record has been deleted:");
//                for (Customer customer : customerList) {
//                    System.out.println(customer);
//                }
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}