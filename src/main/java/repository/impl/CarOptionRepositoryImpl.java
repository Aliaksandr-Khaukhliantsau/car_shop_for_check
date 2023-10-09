package repository.impl;

import repository.CarOptionRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class CarOptionRepositoryImpl implements CarOptionRepository {
    private static final String SQL_GET_CAR_OPTION_BY_OPTION_ID = "SELECT * FROM caroptions WHERE optionid = ? ORDER BY optionname ASC;";
    private static final String SQL_GET_CAR_OPTION_BY_OPTION_NAME = "SELECT * FROM options WHERE name = ? ORDER BY optionname ASC;";
    private static final String SQL_GET_CAR_OPTIONS_BY_COMPLETION_ID = "SELECT * FROM completionscaroptions JOIN caroptions ON completionscaroptions.optionid = caroptions.optionid WHERE completionscaroptions.completionid = ? ORDER BY caroptions.optionname ASC;";
    private static final String SQL_GET_ALL_CAR_OPTIONS = "SELECT * FROM caroptions ORDER BY optionname ASC;";
    private static final String SQL_CREATE_A_CAR_OPTION = "INSERT INTO caroptions (optionname) VALUES (?) RETURNING *;";
    private static final String SQL_UPDATE_A_CAR_OPTION = "UPDATE caroptions SET optionname = ? WHERE optionid = ? RETURNING *;";
    private static final String SQL_DELETE_A_CAR_OPTION = "DELETE FROM caroptions WHERE optionid = ? RETURNING *;";
    private final Connection connection;

    public CarOptionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public ResultSet getCarOptionByOptionId(UUID optionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_OPTION_BY_OPTION_ID);
        preparedStatement.setObject(1, optionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getCarOptionByOptionName(String optionName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_OPTION_BY_OPTION_NAME);
        preparedStatement.setString(1, optionName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_OPTIONS_BY_COMPLETION_ID);
        preparedStatement.setObject(1, completionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getAllCarOptions() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CAR_OPTIONS);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public void create(String optionName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR_OPTION);
        preparedStatement.setString(1, optionName);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void update(UUID optionId, String optionName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR_OPTION);
        preparedStatement.setString(1, optionName);
        preparedStatement.setObject(2, optionId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void delete(UUID optionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR_OPTION);
        preparedStatement.setObject(1, optionId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }
}
