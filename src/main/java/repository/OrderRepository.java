package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface OrderRepository {

    ResultSet getById(String id) throws SQLException;

    ResultSet getByNumber(String number) throws SQLException;

    ResultSet getByIdCustomer(UUID idCustomer) throws SQLException;

    ResultSet getByIdCar(UUID carId) throws SQLException;

    ResultSet getAllOrders() throws SQLException;

//    ResultSet create(String idCustomer, String idCar) throws SQLException;
    ResultSet create(UUID customerId, UUID carId) throws SQLException;

//    ResultSet update(String id, String idCustomer, String idCar) throws SQLException;
    ResultSet update(UUID orderId, UUID customerId, UUID carId) throws SQLException;

    ResultSet delete(UUID orderId) throws SQLException;
}
