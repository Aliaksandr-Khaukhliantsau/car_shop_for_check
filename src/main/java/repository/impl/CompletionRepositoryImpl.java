package repository.impl;

import repository.CompletionRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class CompletionRepositoryImpl implements CompletionRepository {
    private static final String SQL_SHOW_ALL_COMPLETIONS = "SELECT * FROM completions ORDER BY name ASC;";
    private final Connection connection;

    public CompletionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public ResultSet getCompletionByCompletionId(UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_BY_ID = "SELECT * FROM completions WHERE id = " + "'" + completionId + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_COMPLETIONS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCompletionByCompletionName(String completionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_BY_NAME = "SELECT * FROM completions WHERE name = " + "'" + completionName + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_COMPLETIONS_BY_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCompletions() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_COMPLETIONS);
//        statement.close();
        return resultSet;
    }

    @Override
    public void addCarOption(UUID completionId, UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_COMPLETION_OPTION = "INSERT INTO completionsoptions (idcompletion, idoption) VALUES ('" + completionId + "', '" + optionId + "') RETURNING *;";
        statement.executeQuery(SQL_ADD_A_NEW_COMPLETION_OPTION);
        statement.close();
    }

    @Override
    public void deleteCarOption(UUID completionId, UUID optionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_COMPLETION_OPTION = "DELETE FROM completionsoptions WHERE idcompletion = '" + completionId + "' AND idoption = '" + optionId + "' RETURNING *;";
        statement.executeQuery(SQL_DELETE_A_COMPLETION_OPTION);
        statement.close();
    }

    @Override
    public void create(String completionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_COMPLETION = "INSERT INTO completions (name) VALUES ('" + completionName + "') RETURNING *;";
        statement.executeQuery(SQL_ADD_A_NEW_COMPLETION);
        statement.close();
    }

    @Override
    public void update(UUID completionId, String completionName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_COMPLETION = "UPDATE completions SET name = '" + completionName + "' WHERE id = '" + completionId + "' RETURNING *;";
        statement.executeQuery(SQL_CHANGE_A_COMPLETION);
        statement.close();
    }

    @Override
    public void delete(UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_COMPLETION = "DELETE FROM completions WHERE id = '" + completionId + "' RETURNING *;";
        statement.executeQuery(SQL_DELETE_A_COMPLETION);
        statement.close();
    }
}
