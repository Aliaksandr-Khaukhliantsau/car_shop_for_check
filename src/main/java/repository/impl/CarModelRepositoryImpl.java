package repository.impl;

import entity.CarModel;
import repository.CarModelRepository;
import service.CompletionService;
import service.impl.CompletionServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    public CarModel getCarModelByModelId(UUID modelId) throws SQLException {
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_MODEL_ID)) {
            preparedStatement.setObject(1, modelId);
            resultSet = preparedStatement.executeQuery();
            CarModel carModel = new CarModel();

            while (resultSet.next()) {
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

            }
            return carModel;
        }
    }

    @Override
    public List<CarModel> getCarModelByModelName(String modelName) throws SQLException {
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_MODEL_NAME)) {
            preparedStatement.setString(1, modelName);
            resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();

            while (resultSet.next()) {
                CarModel carModel = new CarModel();
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

                carModels.add(carModel);
            }
            return carModels;
        }
    }

    @Override
    public List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_COMPLETION_ID)) {
            preparedStatement.setObject(1, completionId);
            resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();

            while (resultSet.next()) {
                CarModel carModel = new CarModel();
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

                carModels.add(carModel);
            }
            return carModels;
        }
    }

    @Override
    public List<CarModel> getAllCarModels() throws SQLException {
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CAR_MODELS)) {
            resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();

            while (resultSet.next()) {
                CarModel carModel = new CarModel();
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

                carModels.add(carModel);
            }
            return carModels;
        }
    }

    @Override
    public void create(String modelName, UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR_MODEL)) {
            preparedStatement.setString(1, modelName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR_MODEL)) {
            preparedStatement.setString(1, modelName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.setObject(3, modelId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void delete(UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR_MODEL)) {
            preparedStatement.setObject(1, modelId);
            preparedStatement.executeQuery();
        }
    }
}
