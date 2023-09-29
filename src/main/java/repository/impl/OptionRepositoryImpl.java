package repository.impl;

import repository.OptionRepository;

import java.sql.*;

public class OptionRepositoryImpl implements OptionRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_OPTIONS = "SELECT * FROM options ORDER BY name ASC;";
    private final Connection connection;

    public OptionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_OPTIONS_BY_ID = "SELECT * FROM options WHERE id = " + "'" + id + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_OPTIONS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByName(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_OPTIONS_BY_NAME = "SELECT * FROM options WHERE name = " + "'" + name + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_OPTIONS_BY_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllOptions() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_OPTIONS);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_OPTION = "INSERT INTO options (name) VALUES ('" + name + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_OPTION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(String id, String name) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_AN_OPTION = "UPDATE options SET name = '" + name + "' WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_AN_OPTION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_AN_OPTION = "DELETE FROM options WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_AN_OPTION);
//        statement.close();
        return resultSet;
    }
}
