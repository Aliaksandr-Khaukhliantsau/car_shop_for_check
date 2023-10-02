package outputToTheConsole;

import entity.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class OrderOutput {
    public static void main(String[] args) throws SQLException {
        OrderService orderService = new OrderServiceImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) { // Основное меню
            System.out.println("1 - Show all orders");
            System.out.println("2 - Show orders by the sample");
            System.out.println("3 - Create a new order");
            System.out.println("4 - Change an order");
            System.out.println("5 - Delete an order");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            if (userCommand.equals("0")) { // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand.equals("1")) { // Показать все заказы
                List<Order> orderList = orderService.getAllOrders();

                for (Order order : orderList) {
                    System.out.println(order);
                }
                System.out.println();

            } else if (userCommand.equals("2")) { // Показать заказы по выборке

                while (true) { // Меню выборки
                    System.out.println("Select a sample:");
                    System.out.println("1 - id");
                    System.out.println("2 - Number");
                    System.out.println("3 - Customer's id");
                    System.out.println("4 - Car's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    if (userCommand.equals("0")) { // Выход в предыдущее меню
                        System.out.println("Exit to the previous menu.\n");
                        break;

                    } else if (userCommand.equals("1")) { // Выборка по id
                        System.out.println("Enter the order's id:");
                        String OrderId = scanner.nextLine();

                        List<Order> orderList = orderService.getOrderByOrderId(OrderId);

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                    } else if (userCommand.equals("2")) { // Выборка по номеру заказа
                        System.out.println("Enter the number:");
                        String OrderNumber = scanner.nextLine();

                        List<Order> orderList = orderService.getOrderByOrderNumber(OrderNumber);

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                    } else if (userCommand.equals("3")) { // Выборка по id клиента
                        System.out.println("Enter the customer's id:");
                        String customerId = scanner.nextLine();

                        List<Order> orderList = orderService.getOrderByCustomerId(UUID.fromString(customerId));

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                    } else if (userCommand.equals("4")) { // Выборка по id автомобиля
                        System.out.println("Enter the car's id:");
                        String carId = scanner.nextLine();

                        List<Order> orderList = orderService.getOrderByCarId(carId);

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand.equals("3")) { // Создать новый заказ
                System.out.println("Enter the customer's id of the new order:");
                UUID idCustomer = UUID.fromString(scanner.nextLine());
//                String idCustomer = scanner.nextLine();
                System.out.println("Enter the car's id of the new order:");
                String idCar = scanner.nextLine();

                List<Order> orderList = orderService.create(idCustomer, idCar);

                System.out.println("New order's record has been created:");
                for (Order order : orderList) {
                    System.out.println(order);
                }
                System.out.println();

            } else if (userCommand.equals("4")) { // Изменить заказ
                System.out.println("Enter the order's id:");
                String id = scanner.nextLine();
                System.out.println("Enter a new customer's id for the order's record to edit:");
//                String idCustomer = scanner.nextLine();
                UUID idCustomer = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new car's id for the order's record to edit:");
                String idCar = scanner.nextLine();

                List<Order> orderList = orderService.update(id, idCustomer, idCar);

                System.out.println("The order's record has been changed:");
                for (Order order : orderList) {
                    System.out.println(order);
                }
                System.out.println();

            } else if (userCommand.equals("5")) { // Удалить заказ
                System.out.println("Enter the order's id:");
                String id = scanner.nextLine();

                List<Order> orderList = orderService.delete(id);

                System.out.println("The order's record has been deleted:");
                for (Order order : orderList) {
                    System.out.println(order);
                }
                System.out.println();

            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}
