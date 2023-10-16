package repository.impl;

import entity.Car;
import mapper.CarModelMapper;
import repository.CarRepository;
import service.CarModelService;
import service.impl.CarModelServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The CarRepositoryImpl class implements the CarRepository interface.
 * It provides methods to interact with the cars table in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CarRepositoryImpl implements CarRepository {
    private static final String SQL_GET_CAR_BY_CAR_ID = "SELECT * FROM cars WHERE car_id = ? ORDER BY vin ASC;";
    private static final String SQL_GET_CAR_BY_VIN = "SELECT * FROM cars WHERE vin = ? ORDER BY vin ASC;";
    private static final String SQL_GET_CAR_BY_MODEL_ID = "SELECT * FROM cars WHERE model_id = ? ORDER BY vin ASC;";
    private static final String SQL_GET_ALL_CARS = "SELECT * FROM cars ORDER BY vin ASC;";
    private static final String SQL_CREATE_A_CAR = "INSERT INTO cars (vin, model_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_CAR = "UPDATE cars SET vin = ?, model_id = ? WHERE car_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_CAR = "DELETE FROM cars WHERE car_id = ? RETURNING *;";
    private static final CarModelMapper carModelMapper = mapper.CarModelMapper.INSTANCE;
    private final Connection connection;

    /**
     * Constructor establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CarRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
    }

    /**
     * Method to get a car by its ID.
     *
     * @param carId the UUID of the car.
     * @return a Car object.
     * @throws SQLException if a database access error occurs.
     */
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
                car.setCarModel(carModelMapper.carModelDtoToCarModel(carModelService.getCarModelByModelId(modelId)));
            }
            return car;
        }
    }

    /**
     * Method to get a car by its VIN (vehicle identification number).
     *
     * @param vin the VIN of the car.
     * @return a Car object.
     * @throws SQLException if a database access error occurs.
     */
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
                car.setCarModel(carModelMapper.carModelDtoToCarModel(carModelService.getCarModelByModelId(modelId)));
            }
            return car;
        }
    }

    /**
     * Method to get a list of cars by model ID.
     *
     * @param modelId the UUID of the car model.
     * @return a list of Car objects.
     * @throws SQLException if a database access error occurs.
     */
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
                car.setCarModel(carModelMapper.carModelDtoToCarModel(carModelService.getCarModelByModelId(modelId)));

                cars.add(car);
            }
            return cars;
        }
    }

    /**
     * Method to get a list of all cars.
     *
     * @return a list of Car objects.
     * @throws SQLException if a database access error occurs.
     */
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
                car.setCarModel(carModelMapper.carModelDtoToCarModel(carModelService.getCarModelByModelId(modelId)));

                cars.add(car);
            }
            return cars;
        }
    }

    /**
     * Method to create a new car.
     *
     * @param vin     the VIN (vehicle identification number) of the new car.
     * @param modelId the UUID of the car model associated with the new car.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String vin, UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR)) {
            preparedStatement.setString(1, vin);
            preparedStatement.setObject(2, modelId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing car.
     *
     * @param carId   the UUID of the car to be updated.
     * @param vin     the new VIN (Vehicle Identification Number) of the car.
     * @param modelId the UUID of the car model associated with the car.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID carId, String vin, UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR)) {
            preparedStatement.setString(1, vin);
            preparedStatement.setObject(2, modelId);
            preparedStatement.setObject(3, carId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing car.
     *
     * @param carId the UUID of the car to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID carId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR)) {
            preparedStatement.setObject(1, carId);
            preparedStatement.executeQuery();
        }
    }
}
