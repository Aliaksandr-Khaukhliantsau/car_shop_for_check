package repository.impl;

import entity.Setting;
import repository.SettingRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The SettingRepositoryImpl class implements the SettingRepository interface.
 * It provides methods to interact with the settings table in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class SettingRepositoryImpl implements SettingRepository {
    private static final String SQL_GET_BY_ID = "SELECT * FROM settings WHERE id = ? ORDER BY setting_name ASC;";
    private static final String SQL_GET_BY_SETTING_NAME = "SELECT * FROM settings WHERE setting_name = ? ORDER BY setting_name ASC;";
    private static final String SQL_GET_BY_COMPLETION_ID = "SELECT * FROM completions_settings JOIN settings ON completions_settings.setting_id = settings.id WHERE completions_settings.completion_id = ? ORDER BY settings.setting_name ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM settings ORDER BY setting_name ASC;";
    private static final String SQL_CREATE = "INSERT INTO settings (setting_name) VALUES (?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE settings SET setting_name = ? WHERE id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM settings WHERE id = ? RETURNING *;";
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
     * Method to get a car setting by its ID.
     *
     * @param id the UUID of the car setting.
     * @return a Setting object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Setting getById(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Setting setting = new Setting();

            while (resultSet.next()) {
                setting.setId(UUID.fromString(resultSet.getString("id")));
                setting.setSettingName(resultSet.getString("setting_name"));
            }
            return setting;
        }
    }

    /**
     * Method to get a car setting by its name.
     *
     * @param settingName the name of the car setting.
     * @return a Setting object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Setting getBySettingName(String settingName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_SETTING_NAME)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, settingName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Setting setting = new Setting();

            while (resultSet.next()) {
                setting.setId(UUID.fromString(resultSet.getString("id")));
                setting.setSettingName(resultSet.getString("setting_name"));
            }
            return setting;
        }
    }

    /**
     * Method to get a list of car settings by completion ID.
     *
     * @param completionId the UUID of the completion.
     * @return a list of Setting objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Setting> getByCompletionId(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_COMPLETION_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Setting> settings = new ArrayList<>();

            while (resultSet.next()) {
                Setting setting = new Setting();
                setting.setId(UUID.fromString(resultSet.getString("id")));
                setting.setSettingName(resultSet.getString("setting_name"));

                settings.add(setting);
            }
            return settings;
        }
    }

    /**
     * Method to get a list of all car setting.
     *
     * @return a list of Setting objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Setting> getAll() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Setting> settings = new ArrayList<>();

            while (resultSet.next()) {
                Setting setting = new Setting();
                setting.setId(UUID.fromString(resultSet.getString("id")));
                setting.setSettingName(resultSet.getString("setting_name"));

                settings.add(setting);
            }
            return settings;
        }
    }

    /**
     * Method to create a new car setting.
     *
     * @param settingName the name of the new car setting.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String settingName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, settingName);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing car setting.
     *
     * @param id          the UUID of the car setting to be updated.
     * @param settingName the new name of the car setting.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String settingName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, settingName);
            preparedStatement.setObject(PARAMETER_INDEX_TWO, id);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing car setting.
     *
     * @param id the UUID of the car setting to be deleted.
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
