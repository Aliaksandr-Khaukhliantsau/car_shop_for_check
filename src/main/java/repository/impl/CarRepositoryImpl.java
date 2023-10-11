package repository.impl;

import entity.Car;
import repository.CarRepository;
import service.CarModelService;
import service.impl.CarModelServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarRepositoryImpl implements CarRepository {
    private static final String SQL_GET_CAR_BY_CAR_ID = "SELECT * FROM cars WHERE car_id = ? ORDER BY vin ASC;";
    private static final String SQL_GET_CAR_BY_VIN = "SELECT * FROM cars WHERE vin = ? ORDER BY vin ASC;";
    private static final String SQL_GET_CAR_BY_MODEL_ID = "SELECT * FROM cars WHERE model_id = ? ORDER BY vin ASC;";
    private static final String SQL_GET_ALL_CARS = "SELECT * FROM cars ORDER BY vin ASC;";
    private static final String SQL_CREATE_A_CAR = "INSERT INTO cars (vin, model_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_CAR = "UPDATE cars SET vin = ?, model_id = ? WHERE car_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_CAR = "DELETE FROM cars WHERE car_id = ? RETURNING *;";
    private final Connection connection;

    public CarRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public Car getCarByCarId(UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_CAR_ID)) {
            preparedStatement.setObject(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = new Car();

            while (resultSet.next()) {
                car.setCarId(UUID.fromString(resultSet.getString("car_id")));
                car.setVin(resultSet.getString("vin"));
                UUID modelId = UUID.fromString(resultSet.getString("model_id"));
                CarModelService carModelService = new CarModelServiceImpl();
                car.setCarModel(carModelService.getCarModelByModelId(modelId));
            }
            return car;
        }
    }

    @Override
    public Car getCarByVin(String vin) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_VIN)) {
            preparedStatement.setString(1, vin);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = new Car();

            while (resultSet.next()) {
                car.setCarId(UUID.fromString(resultSet.getString("car_id")));
                car.setVin(resultSet.getString("vin"));
                UUID modelId = UUID.fromString(resultSet.getString("model_id"));
                CarModelService carModelService = new CarModelServiceImpl();
                car.setCarModel(carModelService.getCarModelByModelId(modelId));
            }
            return car;
        }
    }

    @Override
    public List<Car> getCarByModelId(UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_MODEL_ID)) {
            preparedStatement.setObject(1, modelId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(UUID.fromString(resultSet.getString("car_id")));
                car.setVin(resultSet.getString("vin"));
                CarModelService carModelService = new CarModelServiceImpl();
                car.setCarModel(carModelService.getCarModelByModelId(modelId));

                cars.add(car);
            }
            return cars;
        }
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CARS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                Car car = new Car();
                car.setCarId(UUID.fromString(resultSet.getString("car_id")));
                car.setVin(resultSet.getString("vin"));
                UUID modelId = UUID.fromString(resultSet.getString("model_id"));
                CarModelService carModelService = new CarModelServiceImpl();
                car.setCarModel(carModelService.getCarModelByModelId(modelId));

                cars.add(car);
            }
            return cars;
        }
    }

    @Override
    public void create(String vin, UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR)) {
            preparedStatement.setString(1, vin);
            preparedStatement.setObject(2, modelId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void update(UUID carId, String vin, UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR)) {
            preparedStatement.setString(1, vin);
            preparedStatement.setObject(2, modelId);
            preparedStatement.setObject(3, carId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void delete(UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR)) {
            preparedStatement.setObject(1, carId);
            preparedStatement.executeQuery();
        }
    }
}
