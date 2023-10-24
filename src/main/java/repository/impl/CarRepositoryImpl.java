package repository.impl;

import entity.Car;
import mapper.LayoutMapper;
import repository.CarRepository;
import service.LayoutService;
import service.impl.LayoutServiceImpl;
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
    private static final String SQL_GET_BY_ID = "SELECT * FROM cars WHERE id = ? ORDER BY vin ASC;";
    private static final String SQL_GET_BY_VIN = "SELECT * FROM cars WHERE vin = ? ORDER BY vin ASC;";
    private static final String SQL_GET_BY_LAYOUT_ID = "SELECT * FROM cars WHERE layout_id = ? ORDER BY vin ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM cars ORDER BY vin ASC;";
    private static final String SQL_CREATE = "INSERT INTO cars (vin, layout_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE cars SET vin = ?, layout_id = ? WHERE id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM cars WHERE id = ? RETURNING *;";
    private static final LayoutMapper LAYOUT_MAPPER = LayoutMapper.LAYOUT_MAPPER;
    private static final int PARAMETER_INDEX_ONE = 1;
    private static final int PARAMETER_INDEX_TWO = 2;
    private static final int PARAMETER_INDEX_THREE = 3;
    private final Connection connection;

    {
        try {
            connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to get a car by its ID.
     *
     * @param id the UUID of the car.
     * @return a Car object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Car getById(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = new Car();

            while (resultSet.next()) {
                car.setId(UUID.fromString(resultSet.getString("id")));
                car.setVin(resultSet.getString("vin"));
                UUID layoutId = UUID.fromString(resultSet.getString("layout_id"));
                LayoutService layoutService = new LayoutServiceImpl();
                car.setLayout(LAYOUT_MAPPER.layoutDtoToLayout(layoutService.getById(layoutId)));
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
    public Car getByVin(String vin) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_VIN)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, vin);
            ResultSet resultSet = preparedStatement.executeQuery();
            Car car = new Car();

            while (resultSet.next()) {
                car.setId(UUID.fromString(resultSet.getString("id")));
                car.setVin(resultSet.getString("vin"));
                UUID layoutId = UUID.fromString(resultSet.getString("layout_id"));
                LayoutService layoutService = new LayoutServiceImpl();
                car.setLayout(LAYOUT_MAPPER.layoutDtoToLayout(layoutService.getById(layoutId)));
            }
            return car;
        }
    }

    /**
     * Method to get a list of cars by layout ID.
     *
     * @param layoutId the UUID of the car layout.
     * @return a list of Car objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Car> getByLayoutId(UUID layoutId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_LAYOUT_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, layoutId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(UUID.fromString(resultSet.getString("id")));
                car.setVin(resultSet.getString("vin"));
                LayoutService layoutService = new LayoutServiceImpl();
                car.setLayout(LAYOUT_MAPPER.layoutDtoToLayout(layoutService.getById(layoutId)));

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
    public List<Car> getAll() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(UUID.fromString(resultSet.getString("id")));
                car.setVin(resultSet.getString("vin"));
                UUID layoutId = UUID.fromString(resultSet.getString("layout_id"));
                LayoutService layoutService = new LayoutServiceImpl();
                car.setLayout(LAYOUT_MAPPER.layoutDtoToLayout(layoutService.getById(layoutId)));

                cars.add(car);
            }
            return cars;
        }
    }

    /**
     * Method to create a new car.
     *
     * @param vin      the VIN (vehicle identification number) of the new car.
     * @param layoutId the UUID of the car layout associated with the new car.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String vin, UUID layoutId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, vin);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, layoutId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing car.
     *
     * @param id       the UUID of the car to be updated.
     * @param vin      the new VIN (vehicle identification number) of the car.
     * @param layoutId the UUID of the car layout associated with the car.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String vin, UUID layoutId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, vin);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, layoutId);
            preparedStatement.setObject(PARAMETER_INDEX_THREE, id);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing car.
     *
     * @param id the UUID of the car to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            preparedStatement.executeQuery();
        }
    }
}
