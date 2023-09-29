//import entity.Customer;
//import service.CustomerService;
//import service.impl.CustomerServiceImpl;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Scanner;
//
//public class TestCustomer {
//    public static void main(String[] args) throws SQLException {
//        CustomerService customerService = new CustomerServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        // Основное меню
//        while (true) {
//            System.out.println("1 - Show all customers");
//            System.out.println("2 - Show customers by the sample");
//            System.out.println("3 - Create a new customer");
//            System.out.println("4 - Change a customer");
//            System.out.println("5 - Delete a customer");
//            System.out.println("0 - Exit");
//
//            String userCommand = scanner.nextLine();
//
//            if (userCommand.equals("0")) { // Выход из программы и освобождение ресурсов
//                System.out.println("Exit from program.");
//                scanner.close();
//                System.exit(0);
//
//            } else if (userCommand.equals("1")) {
//                // Показать всех клинтов
//                List<Customer> customerList = customerService.getAllCustomers();
//
//                for (Customer customer : customerList) {
//                    System.out.println(customer);
//                }
//                System.out.println();
//
//            } else if (userCommand.equals("2")) { // Показать клиентов по выборке
//                // Меню выборки
//                while (true) {
//                    System.out.println("Select a sample:");
//                    System.out.println("1 - id");
//                    System.out.println("2 - First name");
//                    System.out.println("3 - Middle name");
//                    System.out.println("4 - Last name");
//                    System.out.println("0 - Back to the previous menu");
//
//                    userCommand = scanner.nextLine();
//
//                    if (userCommand.equals("0")) { // Выход в предыдущее меню
//                        System.out.println("Exit to the previous menu.\n");
//                        break;
//                    } else if (userCommand.equals("1")) {
//                        // Выборка по id
//                        System.out.println("Enter the customer's id:");
//                        String id = scanner.nextLine();
//
//                        List<Customer> customerList = customerService.getServiceById(id);
//
//                        for (Customer customer : customerList) {
//                            System.out.println(customer);
//                        }
//                        System.out.println();
//
//                    } else if (userCommand.equals("2")) { // Выборка по имени
//                        System.out.println("Enter the first name:");
//                        String firstName = scanner.nextLine();
//
//                        List<Customer> customerList = customerService.getByFirstName(firstName);
//
//                        for (Customer customer : customerList) {
//                            System.out.println(customer);
//                        }
//                        System.out.println();
//
//                    } else if (userCommand.equals("3")) { // Выборка по отчеству
//                        System.out.println("Enter the middle name:");
//                        String middleName = scanner.nextLine();
//
//                        List<Customer> customerList = customerService.getByMiddleName(middleName);
//
//                        for (Customer customer : customerList) {
//                            System.out.println(customer);
//                        }
//                        System.out.println();
//
//                    } else if (userCommand.equals("4")) { // Выборка по фамилии
//                        System.out.println("Enter the last name:");
//                        String lastName = scanner.nextLine();
//
//                        List<Customer> customerList = customerService.getByLastName(lastName);
//
//                        for (Customer customer : customerList) {
//                            System.out.println(customer);
//                        }
//                        System.out.println();
//
//                    } else {
//                        System.err.println("Unknown Command!\n");
//                    }
//                }
//
//            } else if (userCommand.equals("3")) { // Создать нового клиента
//                System.out.println("Enter the first name of the new customer:");
//                String firstName = scanner.nextLine();
//                System.out.println("Enter the middle name of the new customer:");
//                String middleName = scanner.nextLine();
//                System.out.println("Enter the last name of the new customer:");
//                String lastName = scanner.nextLine();
//
//                List<Customer> customerList = customerService.create(firstName, middleName, lastName);
//
//                System.out.println("New customer's record has been created:");
//                for (Customer customer : customerList) {
//                    System.out.println(customer);
//                }
//                System.out.println();
//
//            } else if (userCommand.equals("4")) { // Изменить клиента
//                System.out.println("Enter the customer's id:");
//                String id = scanner.nextLine();
//                System.out.println("Enter a new first name for the customer's record to edit:");
//                String firstName = scanner.nextLine();
//                System.out.println("Enter a new middle name for the customer's record to edit:");
//                String middleName = scanner.nextLine();
//                System.out.println("Enter a new last name for the customer's record to edit:");
//                String lastName = scanner.nextLine();
//
//                List<Customer> customerList = customerService.update(id, firstName, middleName, lastName);
//
//                System.out.println("The customer's record has been changed:");
//                for (Customer customer : customerList) {
//                    System.out.println(customer);
//                }
//                System.out.println();
//
//            } else if (userCommand.equals("5")) { // Удалить клиента
//                System.out.println("Enter the customer's id:");
//                String id = scanner.nextLine();
//
//                List<Customer> customerList = customerService.delete(id);
//
//                System.out.println("The customer's record has been deleted:");
//                for (Customer customer : customerList) {
//                    System.out.println(customer);
//                }
//                System.out.println();
//
//            } else {
//                System.err.println("Unknown Command!\n");
//            }
//        }
//    }
//}