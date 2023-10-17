package repository.impl;

import entity.Layout;
import mapper.CompletionMapper;
import repository.LayoutRepository;
import service.CompletionService;
import service.impl.CompletionServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The LayoutRepositoryImpl class implements the LayoutRepository interface.
 * It provides methods to interact with the car_models table in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class LayoutRepositoryImpl implements LayoutRepository {
    private static final String SQL_GET_BY_ID = "SELECT * FROM car_models WHERE model_id = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_BY_LAYOUT_NAME = "SELECT * FROM car_models WHERE model_name = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_BY_COMPLETION_ID = "SELECT * FROM car_models WHERE completion_id = ? ORDER BY model_name ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM car_models ORDER BY model_name ASC;";
    private static final String SQL_CREATE = "INSERT INTO car_models (model_name, completion_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE car_models SET model_name = ?, completion_id = ? WHERE model_id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM car_models WHERE model_id = ? RETURNING *;";
    private static final CompletionMapper completionMapper = CompletionMapper.INSTANCE;
    private final Connection connection;

    /**
     * Constructor establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs.
     */
    public LayoutRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
    }

    /**
     * Method to get a car layout by its ID.
     *
     * @param id the UUID of the car layout.
     * @return a Layout object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Layout getById(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Layout layout = new Layout();

            while (resultSet.next()) {
                layout.setId(UUID.fromString(resultSet.getString("model_id")));
                layout.setLayoutName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(completionMapper.completionDtoToCompletion(completionService.getById(completionId)));

            }
            return layout;
        }
    }

    /**
     * Method to get a list of car layouts by layout name.
     *
     * @param layoutName the name of the car layout.
     * @return a list of Layout objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Layout> getByLayoutName(String layoutName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_LAYOUT_NAME)) {
            preparedStatement.setString(1, layoutName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Layout> layouts = new ArrayList<>();

            while (resultSet.next()) {
                Layout layout = new Layout();
                layout.setId(UUID.fromString(resultSet.getString("model_id")));
                layout.setLayoutName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(completionMapper.completionDtoToCompletion(completionService.getById(completionId)));

                layouts.add(layout);
            }
            return layouts;
        }
    }

    /**
     * Method to get a list of car layouts by completion ID.
     *
     * @param completionId the UUID of the completion.
     * @return a list of Layout objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Layout> getByCompletionId(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_COMPLETION_ID)) {
            preparedStatement.setObject(1, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Layout> layouts = new ArrayList<>();

            while (resultSet.next()) {
                Layout layout = new Layout();
                layout.setId(UUID.fromString(resultSet.getString("model_id")));
                layout.setLayoutName(resultSet.getString("model_name"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(completionMapper.completionDtoToCompletion(completionService.getById(completionId)));

                layouts.add(layout);
            }
            return layouts;
        }
    }

    /**
     * Method to get a list of all car layouts.
     *
     * @return a list of Layout objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Layout> getAll() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Layout> layouts = new ArrayList<>();

            while (resultSet.next()) {
                Layout layout = new Layout();
                layout.setId(UUID.fromString(resultSet.getString("model_id")));
                layout.setLayoutName(resultSet.getString("model_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(completionMapper.completionDtoToCompletion(completionService.getById(completionId)));

                layouts.add(layout);
            }
            return layouts;
        }
    }

    /**
     * Method to create a new car layout.
     *
     * @param layoutName   the name of the new car layout.
     * @param completionId the UUID of the completion associated with the new car layout.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String layoutName, UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE)) {
            preparedStatement.setString(1, layoutName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing car layout.
     *
     * @param id           the UUID of the car layout to be updated.
     * @param layoutName   the new name of the car layout.
     * @param completionId the UUID of the completion associated with the car layout.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String layoutName, UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(1, layoutName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.setObject(3, id);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing car layout.
     *
     * @param id the UUID of the car layout to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeQuery();
        }
    }
}
