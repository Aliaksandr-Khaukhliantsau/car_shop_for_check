package repository.impl;

import repository.CarRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class CarRepositoryImpl implements CarRepository {
    private static final String SQL_GET_CAR_BY_CAR_ID = "SELECT * FROM cars WHERE carid = ? ORDER BY vin ASC;";
    private static final String SQL_GET_CAR_BY_VIN = "SELECT * FROM cars WHERE vin = ? ORDER BY vin ASC;";
    private static final String SQL_GET_CAR_BY_MODEL_ID = "SELECT * FROM cars WHERE modelid = ? ORDER BY vin ASC;";
    private static final String SQL_GET_ALL_CARS = "SELECT * FROM cars ORDER BY vin ASC;";
    private static final String SQL_CREATE_A_CAR = "INSERT INTO cars (vin, modelid) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_CAR = "UPDATE cars SET vin = ?, modelid = ? WHERE carid = ? RETURNING *;";
    private static final String SQL_DELETE_A_CAR = "DELETE FROM cars WHERE carid = ? RETURNING *;";
    private final Connection connection;

    public CarRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public ResultSet getCarByCarId(UUID carId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_CAR_ID);
        preparedStatement.setObject(1, carId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getCarByVin(String vin) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_VIN);
        preparedStatement.setString(1, vin);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getCarByModelId(UUID modelId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_BY_MODEL_ID);
        preparedStatement.setObject(1, modelId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getAllCars() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CARS);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public void create(String vin, UUID modelId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR);
        preparedStatement.setString(1, vin);
        preparedStatement.setObject(2, modelId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void update(UUID carId, String vin, UUID modelId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR);
        preparedStatement.setString(1, vin);
        preparedStatement.setObject(2, modelId);
        preparedStatement.setObject(3, carId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void delete(UUID carId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR);
        preparedStatement.setObject(1, carId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }
}
