package repository.impl;

import repository.CompletionCarOptionRepository;

import java.sql.*;
import java.util.UUID;

public class CompletionCarOptionRepositoryImpl implements CompletionCarOptionRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_COMPLETIONS_OPTIONS = "SELECT * FROM completionsoptions ORDER BY idcompletion ASC;";
    private final Connection connection;

    public CompletionCarOptionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getCompletionCarOptionByCompletionId(UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_COMPLETION = "SELECT * FROM completionsoptions WHERE idcompletion = " + "'" + completionId + "'" + " ORDER BY idcompletion ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_COMPLETION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCompletionCarOptionByOptionId(UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_OPTION = "SELECT * FROM completionsoptions WHERE idoption = " + "'" + optionId + "'" + " ORDER BY idcompletion ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_OPTION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCompletionCarOptions() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_COMPLETIONS_OPTIONS);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(UUID completionId, UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_COMPLETION_OPTION = "INSERT INTO completionsoptions (idcompletion, idoption) VALUES ('" + completionId + "', '" + optionId + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_COMPLETION_OPTION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(UUID completionId, UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_COMPLETION_OPTION = "DELETE FROM completionsoptions WHERE idcompletion = '" + completionId + "' AND idoption = '" + optionId + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_COMPLETION_OPTION);
//        statement.close();
        return resultSet;
    }
}
