package service;

import entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    List<Order> getOrderById(String id) throws SQLException;

    List<Order> getByNumber(String number) throws SQLException;

    List<Order> getByIdCustomer(String idCustomer) throws SQLException;

    List<Order> getByIdCar(String idCar) throws SQLException;

    List<Order> getAllOrders() throws SQLException;

    List<Order> create(String idCustomer, String idCar) throws SQLException;

    List<Order> update(String id, String idCustomer, String idCar) throws SQLException;

    List<Order> delete(String id) throws SQLException;
}
