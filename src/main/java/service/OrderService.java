package service;

import entity.Car;
import entity.Customer;
import entity.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<Order> getOrderByOrderId(String id) throws SQLException;

    List<Order> getOrderByOrderNumber(String number) throws SQLException;

//    List<Order> getOrderByCustomerId(String CustomerId) throws SQLException;
    List<Order> getOrderByCustomerId(UUID CustomerId) throws SQLException;

    List<Order> getOrderByCustomer(Customer customer) throws SQLException;

    List<Order> getOrderByCarId(String idCar) throws SQLException;

//    List<Order> getOrderByCar(Car car) throws SQLException;

    List<Order> getAllOrders() throws SQLException;

//    List<Order> create(String idCustomer, String idCar) throws SQLException;
    List<Order> create(UUID idCustomer, String idCar) throws SQLException;

//    List<Order> update(String id, String idCustomer, String idCar) throws SQLException;
    List<Order> update(String id, UUID idCustomer, String idCar) throws SQLException;

    List<Order> delete(String id) throws SQLException;
}
