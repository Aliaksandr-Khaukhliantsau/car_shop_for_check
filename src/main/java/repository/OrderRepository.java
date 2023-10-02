package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface OrderRepository {

    ResultSet getById(String id) throws SQLException;

    ResultSet getByNumber(String number) throws SQLException;

    ResultSet getByIdCustomer(UUID idCustomer) throws SQLException;

    ResultSet getByIdCar(String idCar) throws SQLException;

    ResultSet getAllOrders() throws SQLException;

//    ResultSet create(String idCustomer, String idCar) throws SQLException;
    ResultSet create(UUID idCustomer, String idCar) throws SQLException;

//    ResultSet update(String id, String idCustomer, String idCar) throws SQLException;
    ResultSet update(String id, UUID idCustomer, String idCar) throws SQLException;

    ResultSet delete(String id) throws SQLException;
}
