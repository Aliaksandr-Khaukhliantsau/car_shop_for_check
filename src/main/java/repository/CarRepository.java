package repository;

import entity.Car;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarRepository {
    // Везде java doc по формату, образец в инете !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    Car getCarByCarId(UUID carId) throws SQLException;

    Car getCarByVin(String vin) throws SQLException;

    List<Car> getCarByModelId(UUID modelId) throws SQLException;

    List<Car> getAllCars() throws SQLException;

    void create(String vin, UUID modelId) throws SQLException;

    void update(UUID carId, String vin, UUID modelId) throws SQLException;

    void delete(UUID carId) throws SQLException;
}
