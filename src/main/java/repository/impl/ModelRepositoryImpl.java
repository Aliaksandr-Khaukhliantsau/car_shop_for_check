package repository.impl;

import repository.ModelRepository;

import java.sql.*;
import java.util.UUID;

public class ModelRepositoryImpl implements ModelRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_MODELS = "SELECT * FROM models ORDER BY name ASC;";
    private final Connection connection;

    public ModelRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getById(UUID modelId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_MODELS_BY_ID = "SELECT * FROM models WHERE id = " + "'" + modelId + "'" + " ORDER BY name ASC;";
        // prepare statement, строки в константы.
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_MODELS_BY_ID);
//        statement.close(); не должно быть ничего закоменченого, край ToDo
        // закрыть любым способом все ресурсы
        return resultSet;
    }

    @Override
    public ResultSet getByName(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_MODELS_BY_NAME = "SELECT * FROM models WHERE name = " + "'" + name + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_MODELS_BY_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByIdCompletion(UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_MODELS_BY_ID_COMPLETION = "SELECT * FROM models WHERE idcompletion = " + "'" + completionId + "'" + " ORDER BY name ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_MODELS_BY_ID_COMPLETION);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllModels() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_MODELS);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(String name, UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_MODEL = "INSERT INTO models (name, idcompletion) VALUES ('" + name + "', '" + completionId + "') RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_MODEL);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_MODEL = "UPDATE models SET name = '" + modelName + "', idcompletion = '" + completionId + "' WHERE id = '" + modelId + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_A_MODEL);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(UUID modelId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_MODEL = "DELETE FROM models WHERE id = '" + modelId + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_MODEL);
//        statement.close();
        return resultSet;
    }
}
