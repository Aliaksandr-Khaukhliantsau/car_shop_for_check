package repository.impl;

import repository.CarRepository;

import java.sql.*;
import java.util.UUID;

public class CarRepositoryImpl implements CarRepository {
    // настройки подключения к бд должны быть в 1 месте, в файле .properties.
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_CARS = "SELECT * FROM cars ORDER BY vin ASC;";
    private final Connection connection;

    public CarRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getCarByCarId(UUID carId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CARS_BY_ID = "SELECT * FROM cars WHERE id = " + "'" + carId + "'" + " ORDER BY vin ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CARS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCarByVin(String vin) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CARS_BY_VIN = "SELECT * FROM cars WHERE vin = " + "'" + vin + "'" + " ORDER BY vin ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CARS_BY_VIN);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCarByModelId(UUID modelId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CARS_BY_ID_MODEL = "SELECT * FROM cars WHERE idmodel = " + "'" + modelId + "'" + " ORDER BY vin ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CARS_BY_ID_MODEL);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCars() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_CARS);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(String vin, UUID modelId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_CAR = "INSERT INTO cars (vin, idmodel) VALUES ('" + vin + "', '" + modelId + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_CAR);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(UUID carId, String vin, UUID modelId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_CAR = "UPDATE cars SET vin = '" + vin + "', idmodel = '" + modelId + "' WHERE id = '" + carId + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_A_CAR);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(UUID carId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_CAR = "DELETE FROM cars WHERE id = '" + carId + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_CAR);
//        statement.close();
        return resultSet;
    }
}
