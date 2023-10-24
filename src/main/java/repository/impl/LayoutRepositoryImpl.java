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
 * It provides methods to interact with the layouts table in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class LayoutRepositoryImpl implements LayoutRepository {
    private static final String SQL_GET_BY_ID = "SELECT * FROM layouts WHERE id = ? ORDER BY layout_name ASC;";
    private static final String SQL_GET_BY_LAYOUT_NAME = "SELECT * FROM layouts WHERE layout_name = ? ORDER BY layout_name ASC;";
    private static final String SQL_GET_BY_COMPLETION_ID = "SELECT * FROM layouts WHERE completion_id = ? ORDER BY layout_name ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM layouts ORDER BY layout_name ASC;";
    private static final String SQL_CREATE = "INSERT INTO layouts (layout_name, completion_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE layouts SET layout_name = ?, completion_id = ? WHERE id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM layouts WHERE id = ? RETURNING *;";
    private static final CompletionMapper COMPLETION_MAPPER = CompletionMapper.COMPLETION_MAPPER;
    private static final int PARAMETER_INDEX_ONE = 1;
    private static final int PARAMETER_INDEX_TWO = 2;
    private static final int PARAMETER_INDEX_THREE = 3;
    private final Connection connection;

    {
        try {
            connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Layout layout = new Layout();

            while (resultSet.next()) {
                layout.setId(UUID.fromString(resultSet.getString("id")));
                layout.setLayoutName(resultSet.getString("layout_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(COMPLETION_MAPPER.completionDtoToCompletion(completionService.getById(completionId)));

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
            preparedStatement.setString(PARAMETER_INDEX_ONE, layoutName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Layout> layouts = new ArrayList<>();

            while (resultSet.next()) {
                Layout layout = new Layout();
                layout.setId(UUID.fromString(resultSet.getString("id")));
                layout.setLayoutName(resultSet.getString("layout_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(COMPLETION_MAPPER.completionDtoToCompletion(completionService.getById(completionId)));

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
            preparedStatement.setObject(PARAMETER_INDEX_ONE, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Layout> layouts = new ArrayList<>();

            while (resultSet.next()) {
                Layout layout = new Layout();
                layout.setId(UUID.fromString(resultSet.getString("id")));
                layout.setLayoutName(resultSet.getString("layout_name"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(COMPLETION_MAPPER.completionDtoToCompletion(completionService.getById(completionId)));

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
                layout.setId(UUID.fromString(resultSet.getString("id")));
                layout.setLayoutName(resultSet.getString("layout_name"));
                UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
                CompletionService completionService = new CompletionServiceImpl();
                layout.setCompletion(COMPLETION_MAPPER.completionDtoToCompletion(completionService.getById(completionId)));

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
            preparedStatement.setString(PARAMETER_INDEX_ONE, layoutName);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, completionId);
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
            preparedStatement.setString(PARAMETER_INDEX_ONE, layoutName);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, completionId);
            preparedStatement.setObject(PARAMETER_INDEX_THREE, id);
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
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            preparedStatement.executeQuery();
        }
    }
}
