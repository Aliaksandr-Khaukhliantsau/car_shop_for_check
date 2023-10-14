package repository.impl;

import entity.CarOption;
import repository.CarOptionRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The CarOptionRepositoryImpl class implements the CarOptionRepository interface.
 * It provides methods to interact with the car_options table in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CarOptionRepositoryImpl implements CarOptionRepository {
    private static final String SQL_GET_CAR_OPTION_BY_OPTION_ID = "SELECT * FROM car_options WHERE option_id = ? ORDER BY option_name ASC;";
    private static final String SQL_GET_CAR_OPTION_BY_OPTION_NAME = "SELECT * FROM car_options WHERE option_name = ? ORDER BY option_name ASC;";
    private static final String SQL_GET_CAR_OPTIONS_BY_COMPLETION_ID = "SELECT * FROM completions_car_options JOIN car_options ON completions_car_options.option_id = car_options.option_id WHERE completions_car_options.completion_id = ? ORDER BY car_options.option_name ASC;";
    private static final String SQL_GET_ALL_CAR_OPTIONS = "SELECT * FROM car_options ORDER BY option_name ASC;";
    private static final String SQL_CREATE_A_CAR_OPTION = "INSERT INTO car_options (option_name) VALUES (?) RETURNING *;";
    private static final String SQL_UPDATE_A_CAR_OPTION = "UPDATE car_options SET option_name = ? WHERE option_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_CAR_OPTION = "DELETE FROM car_options WHERE option_id = ? RETURNING *;";
    private final Connection connection;

    /**
     * Constructor establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CarOptionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    /**
     * Method to get a car option by its ID.
     *
     * @param optionId The UUID of the car option.
     * @return A CarOption object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarOption getCarOptionByOptionId(UUID optionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_OPTION_BY_OPTION_ID)) {
            preparedStatement.setObject(1, optionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            CarOption carOption = new CarOption();

            while (resultSet.next()) {
                carOption.setOptionId(UUID.fromString(resultSet.getString("option_id")));
                carOption.setOptionName(resultSet.getString("option_name"));
            }
            return carOption;
        }
    }

    /**
     * Method to get a car option by its name.
     *
     * @param optionName The name of the car option.
     * @return A CarOption object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CarOption getCarOptionByOptionName(String optionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_OPTION_BY_OPTION_NAME)) {
            preparedStatement.setString(1, optionName);
            ResultSet resultSet = preparedStatement.executeQuery();
            CarOption carOption = new CarOption();

            while (resultSet.next()) {
                carOption.setOptionId(UUID.fromString(resultSet.getString("option_id")));
                carOption.setOptionName(resultSet.getString("option_name"));
            }
            return carOption;
        }
    }

    /**
     * Method to get a list of car options by completion ID.
     *
     * @param completionId The UUID of the completion.
     * @return A list of CarOption objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarOption> getCarOptionsByCompletionId(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CAR_OPTIONS_BY_COMPLETION_ID)) {
            preparedStatement.setObject(1, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarOption> carOptions = new ArrayList<>();

            while (resultSet.next()) {
                CarOption carOption = new CarOption();
                carOption.setOptionId(UUID.fromString(resultSet.getString("option_id")));
                carOption.setOptionName(resultSet.getString("option_name"));

                carOptions.add(carOption);
            }
            return carOptions;
        }
    }

    /**
     * Method to get a list of all car options.
     *
     * @return A list of CarOption objects.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CarOption> getAllCarOptions() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CAR_OPTIONS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarOption> carOptions = new ArrayList<>();

            while (resultSet.next()) {
                CarOption carOption = new CarOption();
                carOption.setOptionId(UUID.fromString(resultSet.getString("option_id")));
                carOption.setOptionName(resultSet.getString("option_name"));

                carOptions.add(carOption);
            }
            return carOptions;
        }
    }

    /**
     * Method to create a new car option.
     *
     * @param optionName The name of the new car option.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String optionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CAR_OPTION)) {
            preparedStatement.setString(1, optionName);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing car option.
     *
     * @param optionId   The UUID of the car option to be updated.
     * @param optionName The new name of the car option.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID optionId, String optionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CAR_OPTION)) {
            preparedStatement.setString(1, optionName);
            preparedStatement.setObject(2, optionId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing car option.
     *
     * @param optionId The UUID of the car option to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID optionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR_OPTION)) {
            preparedStatement.setObject(1, optionId);
            preparedStatement.executeQuery();
        }
    }
}
