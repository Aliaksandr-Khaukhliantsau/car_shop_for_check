package repository.impl;

import dto.CarOptionDto;
import entity.Completion;
import mapper.CarOptionMapper;
import repository.CompletionRepository;
import service.CarOptionService;
import service.impl.CarOptionServiceImpl;
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
    private static final String SQL_GET_COMPLETION_BY_COMPLETION_ID = "SELECT * FROM completions WHERE completion_id = ? ORDER BY completion_name ASC;";
    private static final String SQL_GET_COMPLETION_BY_COMPLETION_NAME = "SELECT * FROM completions WHERE completion_name = ? ORDER BY completion_name ASC;";
    private static final String SQL_GET_ALL_COMPLETIONS = "SELECT * FROM completions ORDER BY completion_name ASC;";
    private static final String SQL_ADD_A_CAR_OPTION = "INSERT INTO completions_car_options (completion_id, option_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_DELETE_A_CAR_OPTION = "DELETE FROM completions_car_options WHERE completion_id = ? AND option_id = ? RETURNING *;";
    private static final String SQL_CREATE_A_COMPLETION = "INSERT INTO completions (completion_name) VALUES (?) RETURNING *;";
    private static final String SQL_UPDATE_A_COMPLETION = "UPDATE completions SET completion_name = ? WHERE completion_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_COMPLETION = "DELETE FROM completions WHERE completion_id = ? RETURNING *;";
    private static final CarOptionMapper carOptionMapper = CarOptionMapper.INSTANCE;
    private final Connection connection;

    /**
     * Constructor establishes a connection to the database.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CompletionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
    }

    /**
     * Method to get a completion by its ID.
     *
     * @param completionId the UUID of the completion.
     * @return a Completion object.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Completion getCompletionByCompletionId(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_COMPLETION_BY_COMPLETION_ID)) {
            preparedStatement.setObject(1, completionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Completion completion = new Completion();

            while (resultSet.next()) {
                completion.setCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCompletionName(resultSet.getString("completion_name"));
                CarOptionService carOptionService = new CarOptionServiceImpl();
                List<CarOptionDto> carOptionsDto = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCarOptions(carOptionsDto.stream().map(carOptionMapper::carOptionDtoToCarOption).collect(Collectors.toList()));
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
    public Completion getCompletionByCompletionName(String completionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_COMPLETION_BY_COMPLETION_NAME)) {
            preparedStatement.setString(1, completionName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Completion completion = new Completion();

            while (resultSet.next()) {
                completion.setCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCompletionName(resultSet.getString("completion_name"));
                CarOptionService carOptionService = new CarOptionServiceImpl();
                List<CarOptionDto> carOptionsDto = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCarOptions(carOptionsDto.stream().map(carOptionMapper::carOptionDtoToCarOption).collect(Collectors.toList()));
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
    public List<Completion> getAllCompletions() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_COMPLETIONS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Completion> completions = new ArrayList<>();

            while (resultSet.next()) {
                Completion completion = new Completion();
                completion.setCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCompletionName(resultSet.getString("completion_name"));
                CarOptionService carOptionService = new CarOptionServiceImpl();
                List<CarOptionDto> carOptionsDto = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCarOptions(carOptionsDto.stream().map(carOptionMapper::carOptionDtoToCarOption).collect(Collectors.toList()));

                completions.add(completion);
            }
            return completions;
        }
    }

    /**
     * Method to add a car option to a completion.
     *
     * @param completionId the UUID of the completion.
     * @param optionId     the UUID of the car option.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void addCarOption(UUID completionId, UUID optionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_A_CAR_OPTION)) {
            preparedStatement.setObject(1, completionId);
            preparedStatement.setObject(2, optionId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete a car option from a completion.
     *
     * @param completionId the UUID of the completion.
     * @param optionId     the UUID of the car option.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void deleteCarOption(UUID completionId, UUID optionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR_OPTION)) {
            preparedStatement.setObject(1, completionId);
            preparedStatement.setObject(2, optionId);
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_COMPLETION)) {
            preparedStatement.setString(1, completionName);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to update an existing completion.
     *
     * @param completionId   the UUID of the completion to be updated.
     * @param completionName the new name of the completion.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID completionId, String completionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_COMPLETION)) {
            preparedStatement.setString(1, completionName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.executeQuery();
        }
    }

    /**
     * Method to delete an existing completion.
     *
     * @param completionId the UUID of the completion to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_COMPLETION)) {
            preparedStatement.setObject(1, completionId);
            preparedStatement.executeQuery();
        }
    }
}
