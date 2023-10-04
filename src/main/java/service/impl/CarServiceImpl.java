package service.impl;

import entity.Car;
import repository.CarRepository;
import repository.impl.CarRepositoryImpl;
import service.CarService;
import service.CarModelService;

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
    public List<Car> getCarByVin(String vin) throws SQLException {
        ResultSet resultSet = carRepository.getCarByVin(vin);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            UUID modelId = UUID.fromString(resultSet.getString("idmodel"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> getCarByModelId(UUID modelId) throws SQLException {
        ResultSet resultSet = carRepository.getCarByModelId(modelId);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        ResultSet resultSet = carRepository.getAllCars();
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            UUID modelId = UUID.fromString(resultSet.getString("idmodel"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            carList.add(car); // cars никаких лист
        }
        return carList;
    }

    @Override
    public List<Car> create(String vin, UUID modelId) throws SQLException {
        ResultSet resultSet = carRepository.create(vin, modelId);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> update(UUID carId, String vin, UUID modelId) throws SQLException {
        ResultSet resultSet = carRepository.update(carId, vin, modelId);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id"))); // название в бд привести в порядок
            car.setVin(resultSet.getString("vin"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            carList.add(car);
        }
        return carList;
    }

    @Override
    public List<Car> delete(UUID carId) throws SQLException {
        ResultSet resultSet = carRepository.delete(carId);
        List<Car> carList = new ArrayList<>();

        while (resultSet.next()) {
            Car car = new Car();
            car.setCarId(UUID.fromString(resultSet.getString("id")));
            car.setVin(resultSet.getString("vin"));
            UUID modelId = UUID.fromString(resultSet.getString("idmodel"));
            CarModelService carModelService = new CarModelServiceImpl();
            car.setCarModel(carModelService.getCarModelByModelId(modelId));

            carList.add(car);
        }
        return carList;
    }
}
