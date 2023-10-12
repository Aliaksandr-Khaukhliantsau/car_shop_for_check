package service;

import dto.CarDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarService {
    CarDto getCarByCarId(UUID carId) throws SQLException;

    CarDto getCarByVin(String vin) throws SQLException;

    List<CarDto> getCarByModelId(UUID modelId) throws SQLException;

    List<CarDto> getAllCars() throws SQLException;

    void create(String vin, UUID modelId) throws SQLException;

    void update(UUID carId, String vin, UUID modelId) throws SQLException;

    void delete(UUID carId) throws SQLException;
}
