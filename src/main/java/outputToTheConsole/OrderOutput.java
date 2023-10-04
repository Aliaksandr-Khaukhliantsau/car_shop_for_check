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

        // Основное меню
        while (true) {
            System.out.println("1 - Show all orders");
            System.out.println("2 - Show orders by the sample");
            System.out.println("3 - Create a new order");
            System.out.println("4 - Change an order");
            System.out.println("5 - Delete an order");
            System.out.println("0 - Exit");

            String userCommand = scanner.nextLine();

            // Выход из программы и освобождение ресурсов
            if (userCommand.equals("0")) {
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

                // Показать все заказы
            } else if (userCommand.equals("1")) {
                List<Order> orderList = orderService.getAllOrders();

                for (Order order : orderList) {
                    System.out.println(order);
                }
                System.out.println();

                // Показать заказы по выборке
            } else if (userCommand.equals("2")) {

                // Меню выборки
                while (true) {
                    System.out.println("Select a sample:");
                    System.out.println("1 - Order's id");
                    System.out.println("2 - Order's number");
                    System.out.println("3 - Customer's id");
                    System.out.println("4 - Car's id");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextLine();

                    // Выход в предыдущее меню
                    if (userCommand.equals("0")) {
                        System.out.println("Exit to the previous menu.\n");
                        break;

                        // Выборка по id заказа
                    } else if (userCommand.equals("1")) {
                        System.out.println("Enter the order's id:");
                        String OrderId = scanner.nextLine();

                        List<Order> orderList = orderService.getOrderByOrderId(OrderId);

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                        // Выборка по номеру заказа
                    } else if (userCommand.equals("2")) {
                        System.out.println("Enter the order's number:");
                        String OrderNumber = scanner.nextLine();

                        List<Order> orderList = orderService.getOrderByOrderNumber(OrderNumber);

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                        // Выборка по id клиента
                    } else if (userCommand.equals("3")) {
                        System.out.println("Enter the customer's id:");
                        UUID customerId = UUID.fromString(scanner.nextLine());

                        List<Order> orderList = orderService.getOrderByCustomerId(customerId);

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                        // Выборка по id автомобиля
                    } else if (userCommand.equals("4")) {
                        System.out.println("Enter the car's id:");
                        UUID carId = UUID.fromString(scanner.nextLine());

                        List<Order> orderList = orderService.getOrderByCarId(carId);

                        for (Order order : orderList) {
                            System.out.println(order);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

                // Создать новый заказ
            } else if (userCommand.equals("3")) {
                System.out.println("Enter the customer's id of the new order:");
                UUID idCustomer = UUID.fromString(scanner.nextLine());
                System.out.println("Enter the car's id of the new order:");
                UUID idCar = UUID.fromString(scanner.nextLine());

                List<Order> orderList = orderService.create(idCustomer, idCar);

                System.out.println("New order's record has been created:");
                for (Order order : orderList) {
                    System.out.println(order);
                }
                System.out.println();

                // Изменить заказ
            } else if (userCommand.equals("4")) {
                System.out.println("Enter the order's id:");
                UUID id = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new customer's id for the order's record to edit:");
                UUID idCustomer = UUID.fromString(scanner.nextLine());
                System.out.println("Enter a new car's id for the order's record to edit:");
                UUID idCar = UUID.fromString(scanner.nextLine());

                List<Order> orderList = orderService.update(id, idCustomer, idCar);

                System.out.println("The order's record has been changed:");
                for (Order order : orderList) {
                    System.out.println(order);
                }
                System.out.println();

                // Удалить заказ
            } else if (userCommand.equals("5")) {
                System.out.println("Enter the order's id:");
                UUID id = UUID.fromString(scanner.nextLine());

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
