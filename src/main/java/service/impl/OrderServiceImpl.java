package service.impl;

import entity.Car;
import entity.Customer;
import entity.Order;
import repository.OrderRepository;
import repository.impl.OrderRepositoryImpl;
import service.CarService;
import service.CustomerService;
import service.OrderService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository = new OrderRepositoryImpl();

    public OrderServiceImpl() throws SQLException {
    }

    @Override
    public List<Order> getOrderByOrderId(String orderId) throws SQLException {
        ResultSet resultSet = orderRepository.getById(orderId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
//            String customerId = resultSet.getString("idcustomer");
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            String carId = resultSet.getString("idcar");
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderByOrderNumber(String orderNumber) throws SQLException {
        ResultSet resultSet = orderRepository.getByNumber(orderNumber);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
//            String customerId = resultSet.getString("idcustomer");
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            String carId = resultSet.getString("idcar");
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
//    public List<Order> getOrderByCustomerId(String customerId) throws SQLException {
    public List<Order> getOrderByCustomerId(UUID customerId) throws SQLException {
        ResultSet resultSet = orderRepository.getByIdCustomer(customerId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            String carId = resultSet.getString("idcar");
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderByCustomer(Customer customer) throws SQLException {
        ResultSet resultSet = orderRepository.getByIdCustomer(customer.getCustomerId());
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
//            String customerId = resultSet.getString("idcustomer");
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            String carId = resultSet.getString("idcar");
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderByCarId(String carId) throws SQLException {
        ResultSet resultSet = orderRepository.getByIdCar(carId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
//            String customerId = resultSet.getString("idcustomer");
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            order.setCustomer(customerService.getCustomerById(customerId));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

//    @Override
//    public List<Order> getOrderByCar(Car car) throws SQLException {
//        ResultSet resultSet = orderRepository.getByIdCustomer(car.getId());
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setOrderId(resultSet.getString("id"));
//            order.setOrderNumber(resultSet.getInt("number"));
////            String customerId = resultSet.getString("idcustomer");
//            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
//            CustomerService customerService = new CustomerServiceImpl();
//            order.setCustomer(customerService.getCustomerById(customerId));
//            String carId = resultSet.getString("idcar");
//            CarService carService = new CarServiceImpl();
//            order.setCar(carService.getCarById(carId));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        ResultSet resultSet = orderRepository.getAllOrders();
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
//            String customerId = resultSet.getString("idcustomer");
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            String carId = resultSet.getString("idcar");
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
//    public List<Order> create(String customerId, String carId) throws SQLException {
    public List<Order> create(UUID customerId, String carId) throws SQLException {
        ResultSet resultSet = orderRepository.create(customerId, carId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

//    @Override
//    public List<Order> create(Customer customer, Car car) throws SQLException {
//        ResultSet resultSet = orderRepository.create(customer.getId(), car.getId());
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setOrderId(resultSet.getString("id"));
//            order.setOrderNumber(resultSet.getInt("number"));
//            String idCustomer = resultSet.getString("idcustomer");
//            CustomerService customerService = new CustomerServiceImpl();
//            order.setCustomer(customerService.getCustomerById(idCustomer));
//            String idCar = resultSet.getString("idcar");
//            CarService carService = new CarServiceImpl();
//            order.setCar(carService.getCarById(idCar));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }

    @Override
//    public List<Order> update(String orderId, String customerId, String carId) throws SQLException {
    public List<Order> update(String orderId, UUID customerId, String carId) throws SQLException {
        ResultSet resultSet = orderRepository.update(orderId, customerId, carId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

//    @Override
//    public List<Order> update(String orderId, Customer customer, Car car) throws SQLException {
//        ResultSet resultSet = orderRepository.update(orderId, customer.getId(), car.getId());
//        List<Order> orderList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Order order = new Order();
//            order.setOrderId(resultSet.getString("id"));
//            order.setOrderNumber(resultSet.getInt("number"));
//            String idCustomer = resultSet.getString("idcustomer");
//            CustomerService customerService = new CustomerServiceImpl();
//            order.setCustomer(customerService.getCustomerById(idCustomer));
//            String idCar = resultSet.getString("idcar");
//            CarService carService = new CarServiceImpl();
//            order.setCar(carService.getCarById(idCar));
//
//            orderList.add(order);
//        }
//        return orderList;
//    }

    @Override
    public List<Order> delete(String orderId) throws SQLException {
        ResultSet resultSet = orderRepository.delete(orderId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(resultSet.getString("id"));
            order.setOrderNumber(resultSet.getInt("number"));
//            String idCustomer = resultSet.getString("idcustomer");
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            String carId = resultSet.getString("idcar");
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }
}
