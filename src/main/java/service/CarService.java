package service;

import entity.Car;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarService {

    Car getCarById(UUID carId) throws SQLException;

    List<Car> getCarByVin(String vin) throws SQLException;

    List<Car> getCarByModelId(UUID modelId) throws SQLException;

    List<Car> getAllCars() throws SQLException;

    List<Car> create(String vin, UUID modelId) throws SQLException;

    List<Car> update(UUID carId, String vin, UUID modelId) throws SQLException;

    List<Car> delete(UUID carId) throws SQLException;
}
