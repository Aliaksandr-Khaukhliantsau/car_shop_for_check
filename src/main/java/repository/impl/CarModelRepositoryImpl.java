package repository.impl;

import entity.CarModel;
import mapper.CompletionMapper;
import repository.CarModelRepository;
import service.CompletionService;
import service.impl.CompletionServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The CarModelRepositoryImpl class implements the CarModelRepository interface.
 * It provides methods to interact with the car_models table in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CarModelRepositoryImpl implements CarModelRepository {
    private static final String SQL_GET_CAR_MODEL_BY_MODEL_ID = "SELECT * FROM car_models WHERE model_id = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_CAR_MODEL_BY_MODEL_NAME = "SELECT * FROM car_models WHERE model_name = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_CAR_MODEL_BY_COMPLETION_ID = "SELECT * FROM car_models WHERE completion_id = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_ALL_CAR_MODELS = "SELECT * FROM car_models ORDER BY model_name ASC;";
    private static final String SQL_CREATE_A_CAR_MODEL = "INSERT INTO car_models (model_name, completion_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_CAR_MODEL = "UPDATE car_models SET model_name = ?, completion_id = ? WHERE model_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_CAR_MODEL = "DELETE FROM car_models WHERE model_id = ? RETURNING *;";
    private static final CompletionMapper completionMapper = CompletionMapper.INSTANCE;
    private final Connection connection;

    /**
     * Constructor establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CarModelRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
    }

    /**
     * Method to get a car model by its ID.
     *
     * @param modelId the UUID of the car model.
     * @return a CarModel object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarModel getCarModelByModelId(UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_MODEL_ID)) {
            preparedStatement.setObject(1, modelId);
            ResultSet resultSet = preparedStatement.executeQuery();
            CarModel carModel = new CarModel();

            while (resultSet.next()) {
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionMapper.completionDtoToCompletion(completionService.getCompletionByCompletionId(completionId)));

            }
            return carModel;
        }
    }

    /**
     * Method to get a list of car models by model name.
     *
     * @param modelName the name of the car model(s).
     * @return a list of CarModel objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarModel> getCarModelByModelName(String modelName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_MODEL_NAME)) {
            preparedStatement.setString(1, modelName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();

            while (resultSet.next()) {
                CarModel carModel = new CarModel();
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionMapper.completionDtoToCompletion(completionService.getCompletionByCompletionId(completionId)));

                carModels.add(carModel);
            }
            return carModels;
        }
    }

    /**
     * Method to get a list of car models by completion ID.
     *
     * @param completionId the UUID of the completion.
     * @return a list of CarModel objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_MODEL_BY_COMPLETION_ID)) {
            preparedStatement.setObject(1, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();

            while (resultSet.next()) {
                CarModel carModel = new CarModel();
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionMapper.completionDtoToCompletion(completionService.getCompletionByCompletionId(completionId)));

                carModels.add(carModel);
            }
            return carModels;
        }
    }

    /**
     * Method to get a list of all car models.
     *
     * @return a list of CarModel objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarModel> getAllCarModels() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CAR_MODELS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarModel> carModels = new ArrayList<>();

            while (resultSet.next()) {
                CarModel carModel = new CarModel();
                carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
                carModel.setModelName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                carModel.setCompletion(completionMapper.completionDtoToCompletion(completionService.getCompletionByCompletionId(completionId)));

                carModels.add(carModel);
            }
            return carModels;
        }
    }

    /**
     * Method to create a new car model.
     *
     * @param modelName    the name of the new car model.
     * @param completionId the UUID of the completion associated with the new car model.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String modelName, UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR_MODEL)) {
            preparedStatement.setString(1, modelName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing car model.
     *
     * @param modelId      the UUID of the car model to be updated.
     * @param modelName    the new name of the car model.
     * @param completionId the UUID of the completion associated with the car model.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR_MODEL)) {
            preparedStatement.setString(1, modelName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.setObject(3, modelId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing car model.
     *
     * @param modelId the UUID of the car model to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID modelId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR_MODEL)) {
            preparedStatement.setObject(1, modelId);
            preparedStatement.executeQuery();
        }
    }
}
