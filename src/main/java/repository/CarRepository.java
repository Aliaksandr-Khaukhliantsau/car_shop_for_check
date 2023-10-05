package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CarRepository {
    // Везде java doc по формату, образец в инете !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    ResultSet getCarByCarId(UUID carId) throws SQLException;

    ResultSet getCarByVin(String vin) throws SQLException;

    ResultSet getCarByModelId(UUID modelId) throws SQLException;

    ResultSet getAllCars() throws SQLException;

    void create(String vin, UUID modelId) throws SQLException;

    void update(UUID carId, String vin, UUID modelId) throws SQLException;

    void delete(UUID carId) throws SQLException;
}
