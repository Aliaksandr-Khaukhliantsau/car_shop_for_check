package repository.impl;

import repository.CarRepository;

import java.sql.*;

public class CarRepositoryImpl implements CarRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_CARS = "SELECT * FROM cars ORDER BY vin ASC;";
    private final Connection connection;

    public CarRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CARS_BY_ID = "SELECT * FROM cars WHERE id = " + "'" + id + "'" + " ORDER BY vin ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CARS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByVin(String vin) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CARS_BY_VIN = "SELECT * FROM cars WHERE vin = " + "'" + vin + "'" + " ORDER BY vin ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CARS_BY_VIN);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByIdModel(String idModel) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CARS_BY_ID_MODEL = "SELECT * FROM cars WHERE idmodel = " + "'" + idModel + "'" + " ORDER BY vin ASC;";
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
    public ResultSet create(String vin, String idModel) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_CAR = "INSERT INTO cars (vin, idmodel) VALUES ('" + vin + "', '" + idModel + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_CAR);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(String id, String vin, String idModel) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_CAR = "UPDATE cars SET vin = '" + vin + "', idmodel = '" + idModel + "' WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_A_CAR);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_CAR = "DELETE FROM cars WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_CAR);
//        statement.close();
        return resultSet;
    }
}
