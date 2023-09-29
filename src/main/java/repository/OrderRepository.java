package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderRepository {

    ResultSet getById(String id) throws SQLException;

    ResultSet getByNumber(String number) throws SQLException;

    ResultSet getByIdCustomer(String idCustomer) throws SQLException;

    ResultSet getByIdCar(String idCar) throws SQLException;

    ResultSet getAllOrders() throws SQLException;

    ResultSet create(String idCustomer, String idCar) throws SQLException;

    ResultSet update(String id, String idCustomer, String idCar) throws SQLException;

    ResultSet delete(String id) throws SQLException;
}
