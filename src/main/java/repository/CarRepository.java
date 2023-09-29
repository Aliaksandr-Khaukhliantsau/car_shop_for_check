package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
// java doc
public interface CarRepository {
    // Везде java doc по формату, образец в инете
    ResultSet getById(String id) throws SQLException;

    ResultSet getByVin(String vin) throws SQLException;

    ResultSet getByIdModel(String idModel) throws SQLException;

    ResultSet getAllCars() throws SQLException;

    ResultSet create(String vin, String idModel) throws SQLException;

    ResultSet update(String id, String vin, String idModel) throws SQLException;

    ResultSet delete(String id) throws SQLException;
}
