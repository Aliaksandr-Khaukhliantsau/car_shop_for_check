package service.impl;

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
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
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
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderByCustomerId(UUID customerId) throws SQLException {
        ResultSet resultSet = orderRepository.getByIdCustomer(customerId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
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
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderByCarId(UUID carId) throws SQLException {
        ResultSet resultSet = orderRepository.getByIdCar(carId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            order.setCustomer(customerService.getCustomerById(customerId));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        ResultSet resultSet = orderRepository.getAllOrders();
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> create(UUID customerId, UUID carId) throws SQLException {
        ResultSet resultSet = orderRepository.create(customerId, carId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> update(UUID orderId, UUID customerId, UUID carId) throws SQLException {
        ResultSet resultSet = orderRepository.update(orderId, customerId, carId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> delete(UUID orderId) throws SQLException {
        ResultSet resultSet = orderRepository.delete(orderId);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderId(UUID.fromString(resultSet.getString("id")));
            order.setOrderNumber(resultSet.getInt("number"));
            UUID customerId = UUID.fromString(resultSet.getString("idcustomer"));
            CustomerService customerService = new CustomerServiceImpl();
            order.setCustomer(customerService.getCustomerById(customerId));
            UUID carId = UUID.fromString(resultSet.getString("idcar"));
            CarService carService = new CarServiceImpl();
            order.setCar(carService.getCarById(carId));

            orderList.add(order);
        }
        return orderList;
    }
}
