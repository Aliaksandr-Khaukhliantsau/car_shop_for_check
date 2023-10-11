package repository.impl;

import entity.CarOption;
import entity.Completion;
import repository.CompletionRepository;
import service.CarOptionService;
import service.impl.CarOptionServiceImpl;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompletionRepositoryImpl implements CompletionRepository {
    private static final String SQL_GET_COMPLETION_BY_COMPLETION_ID = "SELECT * FROM completions WHERE completion_id = ? ORDER BY completion_name ASC;";
    private static final String SQL_GET_COMPLETION_BY_COMPLETION_NAME = "SELECT * FROM completions WHERE completion_name = ? ORDER BY completion_name ASC;";
    private static final String SQL_GET_ALL_COMPLETIONS = "SELECT * FROM completions ORDER BY completion_name ASC;";
    private static final String SQL_ADD_A_CAR_OPTION = "INSERT INTO completions_car_options (completion_id, option_id) VALUES (?, ?) RETURNING *;";
    private static final String SQL_DELETE_A_CAR_OPTION = "DELETE FROM completions_car_options WHERE completion_id = ? AND option_id = ? RETURNING *;";
    private static final String SQL_CREATE_A_COMPLETION = "INSERT INTO completions (completion_name) VALUES (?) RETURNING *;";
    private static final String SQL_UPDATE_A_COMPLETION = "UPDATE completions SET completion_name = ? WHERE completion_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_COMPLETION = "DELETE FROM completions WHERE completion_id = ? RETURNING *;";
    private final Connection connection;

    public CompletionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

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
                List<CarOption> carOptions = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCarOptions(carOptions);

            }
            return completion;
        }
    }

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
                List<CarOption> carOptions = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCarOptions(carOptions);
            }
            return completion;
        }
    }

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
                List<CarOption> carOptions = carOptionService.getCarOptionsByCompletionId(UUID.fromString(resultSet.getString("completion_id")));
                completion.setCarOptions(carOptions);

                completions.add(completion);
            }
            return completions;
        }
    }

    @Override
    public void addCarOption(UUID completionId, UUID optionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_A_CAR_OPTION)) {
            preparedStatement.setObject(1, completionId);
            preparedStatement.setObject(2, optionId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void deleteCarOption(UUID completionId, UUID optionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CAR_OPTION)) {
            preparedStatement.setObject(1, completionId);
            preparedStatement.setObject(2, optionId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void create(String completionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_COMPLETION)) {
            preparedStatement.setString(1, completionName);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void update(UUID completionId, String completionName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_COMPLETION)) {
            preparedStatement.setString(1, completionName);
            preparedStatement.setObject(2, completionId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void delete(UUID completionId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_COMPLETION)) {
            preparedStatement.setObject(1, completionId);
            preparedStatement.executeQuery();
        }
    }
}
