package repository.impl;

import repository.CarOptionRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class CarOptionRepositoryImpl implements CarOptionRepository {
    private static final String SQL_GET_ALL_CAR_OPTIONS = "SELECT * FROM options ORDER BY name ASC;";
    private final Connection connection;

    public CarOptionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public ResultSet getCarOptionByOptionId(UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_CAR_OPTION_BY_OPTION_ID = "SELECT * FROM options WHERE id = " + "'" + optionId + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_GET_CAR_OPTION_BY_OPTION_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCarOptionByOptionName(String optionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_CAR_OPTION_BY_OPTION_NAME = "SELECT * FROM options WHERE name = " + "'" + optionName + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_GET_CAR_OPTION_BY_OPTION_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_CAR_OPTIONS_BY_COMPLETION_ID = "SELECT * FROM completionsoptions JOIN options ON completionsoptions.idoption = public.options.id WHERE completionsoptions.idcompletion = '" + completionId + "' ORDER BY options.name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_GET_CAR_OPTIONS_BY_COMPLETION_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCarOptions() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_CAR_OPTIONS);
//        statement.close();
        return resultSet;
    }

    @Override
    public void create(String optionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CREATE_A_CAR_OPTION = "INSERT INTO options (name) VALUES ('" + optionName + "') RETURNING *;";
        statement.executeQuery(SQL_CREATE_A_CAR_OPTION);
        statement.close();
    }

    @Override
    public void update(UUID optionId, String optionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_UPDATE_A_CAR_OPTION = "UPDATE options SET name = '" + optionName + "' WHERE id = '" + optionId + "' RETURNING *;";
        statement.executeQuery(SQL_UPDATE_A_CAR_OPTION);
        statement.close();
    }

    @Override
    public void delete(UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_CAR_OPTION = "DELETE FROM options WHERE id = '" + optionId + "' RETURNING *;";
        statement.executeQuery(SQL_DELETE_A_CAR_OPTION);
        statement.close();
    }
}
