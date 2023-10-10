package repository.impl;

import repository.CarModelRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class CarModelRepositoryImpl implements CarModelRepository {
    private static final String SQL_GET_CAR_MODEL_BY_MODEL_ID = "SELECT * FROM car_models WHERE model_id = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_CAR_MODEL_BY_MODEL_NAME = "SELECT * FROM car_models WHERE model_name = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_CAR_MODEL_BY_COMPLETION_ID = "SELECT * FROM car_models WHERE completion_id = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_ALL_CAR_MODELS = "SELECT * FROM car_models ORDER BY model_name ASC;";
    private static final String SQL_CREATE_A_CAR_MODEL = "INSERT INTO car_models (model_name, completion_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_CAR_MODEL = "UPDATE car_models SET model_name = ?, completion_id = ? WHERE model_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_CAR_MODEL = "DELETE FROM car_models WHERE model_id = ? RETURNING *;";
    private final Connection connection;

    public CarModelRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public ResultSet getCarModelByModelId(UUID modelId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_MODEL_ID);
        preparedStatement.setObject(1, modelId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getCarModelByModelName(String modelName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_MODEL_NAME);
        preparedStatement.setString(1, modelName);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getCarModelByCompletionId(UUID completionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_COMPLETION_ID);
        preparedStatement.setObject(1, completionId);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public ResultSet getAllCarModels() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CAR_MODELS);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    @Override
    public void create(String modelName, UUID completionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR_MODEL);
        preparedStatement.setString(1, modelName);
        preparedStatement.setObject(2, completionId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR_MODEL);
        preparedStatement.setString(1, modelName);
        preparedStatement.setObject(2, completionId);
        preparedStatement.setObject(3, modelId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }

    @Override
    public void delete(UUID modelId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR_MODEL);
        preparedStatement.setObject(1, modelId);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }
}
