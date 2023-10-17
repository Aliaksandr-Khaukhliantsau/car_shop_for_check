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
    private static final String SQL_GET_BY_ID = "SELECT * FROM car_options WHERE option_id = ? ORDER BY option_name ASC;";
    private static final String SQL_GET_BY_SETTING_NAME = "SELECT * FROM car_options WHERE option_name = ? ORDER BY option_name ASC;";
    private static final String SQL_GET_BY_COMPLETION_ID = "SELECT * FROM completions_car_options JOIN car_options ON completions_car_options.option_id = car_options.option_id WHERE completions_car_options.completion_id = ? ORDER BY car_options.option_name ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM car_options ORDER BY option_name ASC;";
    private static final String SQL_CREATE = "INSERT INTO car_options (option_name) VALUES (?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE car_options SET option_name = ? WHERE option_id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM car_options WHERE option_id = ? RETURNING *;";
    private final Connection connection;

    /**
     * Constructor establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs.
     */
    public SettingRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
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
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Setting setting = new Setting();

            while (resultSet.next()) {
                setting.setId(UUID.fromString(resultSet.getString("option_id")));
                setting.setSettingName(resultSet.getString("option_name"));
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
            preparedStatement.setString(1, settingName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Setting setting = new Setting();

            while (resultSet.next()) {
                setting.setId(UUID.fromString(resultSet.getString("option_id")));
                setting.setSettingName(resultSet.getString("option_name"));
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
            preparedStatement.setObject(1, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Setting> settings = new ArrayList<>();

            while (resultSet.next()) {
                Setting setting = new Setting();
                setting.setId(UUID.fromString(resultSet.getString("option_id")));
                setting.setSettingName(resultSet.getString("option_name"));

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
                setting.setId(UUID.fromString(resultSet.getString("option_id")));
                setting.setSettingName(resultSet.getString("option_name"));

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
            preparedStatement.setString(1, settingName);
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
            preparedStatement.setString(1, settingName);
            preparedStatement.setObject(2, id);
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
            preparedStatement.setObject(1, id);
            preparedStatement.executeQuery();
        }
    }
}
