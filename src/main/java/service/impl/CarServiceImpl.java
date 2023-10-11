package service.impl;

import entity.Car;
import repository.CarRepository;
import repository.impl.CarRepositoryImpl;
import service.CarService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CarServiceImpl implements CarService {
    CarRepository carRepository = new CarRepositoryImpl();

    public CarServiceImpl() throws SQLException {
    }

    @Override
    public Car getCarByCarId(UUID carId) throws SQLException {
        return carRepository.getCarByCarId(carId);
    }

    @Override
    public Car getCarByVin(String vin) throws SQLException {
        return carRepository.getCarByVin(vin);
    }

    @Override
    public List<Car> getCarByModelId(UUID modelId) throws SQLException {
        return carRepository.getCarByModelId(modelId);
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        return carRepository.getAllCars();
    }

    @Override
    public void create(String vin, UUID modelId) throws SQLException {
        carRepository.create(vin, modelId);
    }

    @Override
    public void update(UUID carId, String vin, UUID modelId) throws SQLException {
        carRepository.update(carId, vin, modelId);
    }

    @Override
    public void delete(UUID carId) throws SQLException {
        carRepository.delete(carId);
    }
}
