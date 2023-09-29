package repository.impl;

import repository.CompletionRepository;

import java.sql.*;

public class CompletionRepositoryImpl implements CompletionRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_COMPLETIONS = "SELECT * FROM completions ORDER BY name ASC;";
    private final Connection connection;

    public CompletionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_BY_ID = "SELECT * FROM completions WHERE id = " + "'" + id + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_COMPLETIONS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByName(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_BY_NAME = "SELECT * FROM completions WHERE name = " + "'" + name + "'" + " ORDER BY name ASC;";
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
    public ResultSet create(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_COMPLETION = "INSERT INTO completions (name) VALUES ('" + name + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_COMPLETION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(String id, String name) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_COMPLETION = "UPDATE completions SET name = '" + name + "' WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_A_COMPLETION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_COMPLETION = "DELETE FROM completions WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_COMPLETION);
//        statement.close();
        return resultSet;
    }
}
