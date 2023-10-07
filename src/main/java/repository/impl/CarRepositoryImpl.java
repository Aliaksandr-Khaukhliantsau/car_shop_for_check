package repository.impl;

import repository.CarRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class CarRepositoryImpl implements CarRepository {
    private static final String SQL_SHOW_ALL_CARS = "SELECT * FROM cars ORDER BY vin ASC;";
    private final Connection connection;

    public CarRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
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
    public void create(String vin, UUID modelId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_CAR = "INSERT INTO cars (vin, idmodel) VALUES ('" + vin + "', '" + modelId + "') RETURNING *;";
        statement.executeQuery(SQL_ADD_A_NEW_CAR);
        statement.close();
    }

    @Override
    public void update(UUID carId, String vin, UUID modelId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_CAR = "UPDATE cars SET vin = '" + vin + "', idmodel = '" + modelId + "' WHERE id = '" + carId + "' RETURNING *;";
        statement.executeQuery(SQL_CHANGE_A_CAR);
        statement.close();
    }

    @Override
    public void delete(UUID carId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_CAR = "DELETE FROM cars WHERE id = '" + carId + "' RETURNING *;";
        statement.executeQuery(SQL_DELETE_A_CAR);
        statement.close();
    }
}
