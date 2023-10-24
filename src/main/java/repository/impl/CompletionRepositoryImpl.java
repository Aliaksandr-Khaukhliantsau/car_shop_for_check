package repository.impl;

import dto.SettingDto;
import entity.Completion;
import mapper.SettingMapper;
import repository.CompletionRepository;
import service.SettingService;
import service.impl.SettingServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * The CompletionRepositoryImpl class implements the CompletionRepository interface.
 * It provides methods to interact with the completions table in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CompletionRepositoryImpl implements CompletionRepository {
    private static final String SQL_GET_BY_ID = "SELECT * FROM completions WHERE id = ? ORDER BY completion_name ASC;";
    private static final String SQL_GET_BY_COMPLETION_NAME = "SELECT * FROM completions WHERE completion_name = ? ORDER BY completion_name ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM completions ORDER BY completion_name ASC;";
    private static final String SQL_ADD_SETTING = "INSERT INTO completions_settings (completion_id, setting_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_DELETE_SETTING = "DELETE FROM completions_settings WHERE completion_id = ? AND setting_id = ? RETURNING *;";
    private static final String SQL_CREATE = "INSERT INTO completions (completion_name) VALUES (?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE completions SET completion_name = ? WHERE id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM completions WHERE id = ? RETURNING *;";
    private static final SettingMapper SETTING_MAPPER = SettingMapper.SETTING_MAPPER;
    private static final int PARAMETER_INDEX_ONE = 1;
    private static final int PARAMETER_INDEX_TWO = 2;
    private final Connection connection;

    {
        try {
            connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to get a completion by its ID.
     *
     * @param completionId the UUID of the completion.
     * @return a Completion object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Completion getById(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Completion completion = new Completion();

            while (resultSet.next()) {
                completion.setId(UUID.fromString(resultSet.getString("id")));
                completion.setCompletionName(resultSet.getString("completion_name"));
                SettingService settingService = new SettingServiceImpl();
                List<SettingDto> settingsDto = settingService.getByCompletionId(UUID.fromString(resultSet.getString("id")));
                completion.setSettings(settingsDto.stream().map(SETTING_MAPPER::settingDtoToSetting).collect(Collectors.toList()));
            }
            return completion;
        }
    }

    /**
     * Method to get a completion by its name.
     *
     * @param completionName the name of the completion.
     * @return a Completion object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Completion getByCompletionName(String completionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_COMPLETION_NAME)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, completionName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Completion completion = new Completion();

            while (resultSet.next()) {
                completion.setId(UUID.fromString(resultSet.getString("id")));
                completion.setCompletionName(resultSet.getString("completion_name"));
                SettingService settingService = new SettingServiceImpl();
                List<SettingDto> settingsDto = settingService.getByCompletionId(UUID.fromString(resultSet.getString("id")));
                completion.setSettings(settingsDto.stream().map(SETTING_MAPPER::settingDtoToSetting).collect(Collectors.toList()));
            }
            return completion;
        }
    }

    /**
     * Method to get a list of all completions.
     *
     * @return a list of Completion objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Completion> getAll() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Completion> completions = new ArrayList<>();

            while (resultSet.next()) {
                Completion completion = new Completion();
                completion.setId(UUID.fromString(resultSet.getString("id")));
                completion.setCompletionName(resultSet.getString("completion_name"));
                SettingService settingService = new SettingServiceImpl();
                List<SettingDto> settingsDto = settingService.getByCompletionId(UUID.fromString(resultSet.getString("id")));
                completion.setSettings(settingsDto.stream().map(SETTING_MAPPER::settingDtoToSetting).collect(Collectors.toList()));

                completions.add(completion);
            }
            return completions;
        }
    }

    /**
     * Method to add a car setting to a completion.
     *
     * @param id        the UUID of the completion.
     * @param settingId the UUID of the car setting.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void addSetting(UUID id, UUID settingId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_SETTING)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, settingId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete a car setting from a completion.
     *
     * @param id        the UUID of the completion.
     * @param settingId the UUID of the car setting.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void deleteSetting(UUID id, UUID settingId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_SETTING)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, settingId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to create a new completion.
     *
     * @param completionName the name of the new completion.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String completionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, completionName);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing completion.
     *
     * @param id             the UUID of the completion to be updated.
     * @param completionName the new name of the completion.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String completionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, completionName);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, id);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing completion.
     *
     * @param id the UUID of the completion to be deleted.
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
