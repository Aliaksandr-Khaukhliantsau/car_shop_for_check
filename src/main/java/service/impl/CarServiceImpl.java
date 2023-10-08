package service.impl;

import entity.Car;
import repository.CarRepository;
import repository.impl.CarRepositoryImpl;
import service.CarModelService;
import service.CarService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarServiceImpl implements CarService {
    CarRepository carRepository = new CarRepositoryImpl();

    public CarServiceImpl() throws SQLException {
    }

    @Override
    public Car getCarByCarId(UUID carId) throws SQLException {
        ResultSet resultSet = carRepository.getCarByCarId(carId);

        Car car = new Car();

        while (resultSet.next()) {
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            UUID modelId = UUID.fromString(resultSet.getString("idmodel"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));
        }
        return car;
    }

    @Override
    public Car getCarByVin(String vin) throws SQLException {
        ResultSet resultSet = carRepository.getCarByVin(vin);
        Car car = new Car();

        while (resultSet.next()) {
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            UUID modelId = UUID.fromString(resultSet.getString("idmodel"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));
        }
        return car;
    }

    @Override
    public List<Car> getCarByModelId(UUID modelId) throws SQLException {
        ResultSet resultSet = carRepository.getCarByModelId(modelId);
        List<Car> cars = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            cars.add(car);
        }
        return cars;
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        ResultSet resultSet = carRepository.getAllCars();
        List<Car> cars = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            UUID modelId = UUID.fromString(resultSet.getString("idmodel"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            cars.add(car);
        }
        return cars;
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
