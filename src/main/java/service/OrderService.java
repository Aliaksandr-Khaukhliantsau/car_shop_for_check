package service;

import entity.Customer;
import entity.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<Order> getOrderByOrderId(String id) throws SQLException;

    List<Order> getOrderByOrderNumber(String number) throws SQLException;

    List<Order> getOrderByCustomerId(UUID CustomerId) throws SQLException;

    List<Order> getOrderByCustomer(Customer customer) throws SQLException;

    List<Order> getOrderByCarId(UUID carId) throws SQLException;


    List<Order> getAllOrders() throws SQLException;

    List<Order> create(UUID customerId, UUID carId) throws SQLException;

    List<Order> update(UUID orderId, UUID customerId, UUID carId) throws SQLException;

    List<Order> delete(UUID orderId) throws SQLException;
}
