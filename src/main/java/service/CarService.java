package service;

import entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {

    List<Car> getById(String id) throws SQLException;

    List<Car> getByVin(String vin) throws SQLException;

    List<Car> getByIdModel(String idModel) throws SQLException;

    List<Car> getAllCars() throws SQLException;

    List<Car> create(String vin, String idModel) throws SQLException;

    List<Car> update(String id, String vin, String idModel) throws SQLException;

    List<Car> delete(String id) throws SQLException;
}
