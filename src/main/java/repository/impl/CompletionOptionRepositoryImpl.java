package repository.impl;

import repository.CompletionOptionRepository;

import java.sql.*;

public class CompletionOptionRepositoryImpl implements CompletionOptionRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_COMPLETIONS_OPTIONS = "SELECT * FROM completionsoptions ORDER BY idcompletion ASC;";
    private final Connection connection;

    public CompletionOptionRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getByIdCompletion(String idCompletion) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_COMPLETION = "SELECT * FROM completionsoptions WHERE idcompletion = " + "'" + idCompletion + "'" + " ORDER BY idcompletion ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_COMPLETION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByIdOption(String idOption) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_OPTION = "SELECT * FROM completionsoptions WHERE idoption = " + "'" + idOption + "'" + " ORDER BY idcompletion ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_COMPLETIONS_OPTIONS_BY_ID_OPTION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCompletionsOptions() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_COMPLETIONS_OPTIONS);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(String idCompletion, String idOption) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_COMPLETION_OPTION = "INSERT INTO completionsoptions (idcompletion, idoption) VALUES ('" + idCompletion + "', '" + idOption + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_COMPLETION_OPTION);
//        statement.close();
        return resultSet;
    }

//    @Override
//    public ResultSet update(String idCompletion, String idOption) throws SQLException {
//        Statement statement = connection.createStatement();
//        String SQL_CHANGE_A_COMPLETION_OPTION = "UPDATE completionsoptions SET idcompletion = '" + idCompletion + ", idoption = '" + idOption + "' WHERE idcompletion = '" + idCompletion + "' AND idoption = '" + idOption + "' RETURNING *;";
//        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_A_COMPLETION_OPTION);
////        statement.close();
//        return resultSet;
//    }

    @Override
    public ResultSet delete(String idCompletion, String idOption) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_COMPLETION_OPTION = "DELETE FROM completionsoptions WHERE idcompletion = '" + idCompletion + "' AND idoption = '" + idOption + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_COMPLETION_OPTION);
//        statement.close();
        return resultSet;
    }
}
