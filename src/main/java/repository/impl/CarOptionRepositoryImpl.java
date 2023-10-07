package repository.impl;

import repository.CarOptionRepository;

import java.sql.*;
import java.util.UUID;

public class CarOptionRepositoryImpl implements CarOptionRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_OPTIONS = "SELECT * FROM options ORDER BY name ASC;";
    private final Connection connection;

    public CarOptionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getCarOptionByOptionId(UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_OPTIONS_BY_ID = "SELECT * FROM options WHERE id = " + "'" + optionId + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_OPTIONS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCarOptionByOptionName(String optionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_OPTIONS_BY_NAME = "SELECT * FROM options WHERE name = " + "'" + optionName + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_OPTIONS_BY_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CAR_OPTIONS_BY_COMPLETION_ID = "SELECT * FROM completionsoptions JOIN options ON completionsoptions.idoption = public.options.id WHERE completionsoptions.idcompletion = '" + completionId + "' ORDER BY options.name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CAR_OPTIONS_BY_COMPLETION_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCarOptions() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_OPTIONS);
//        statement.close();
        return resultSet;
    }

    @Override
    public void create(String optionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_OPTION = "INSERT INTO options (name) VALUES ('" + optionName + "') RETURNING *;";
        statement.executeQuery(SQL_ADD_A_NEW_OPTION);
        statement.close();
    }

    @Override
    public void update(UUID optionId, String optionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_AN_OPTION = "UPDATE options SET name = '" + optionName + "' WHERE id = '" + optionId + "' RETURNING *;";
        statement.executeQuery(SQL_CHANGE_AN_OPTION);
        statement.close();
    }

    @Override
    public void delete(UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_AN_OPTION = "DELETE FROM options WHERE id = '" + optionId + "' RETURNING *;";
        statement.executeQuery(SQL_DELETE_AN_OPTION);
        statement.close();
    }
}
