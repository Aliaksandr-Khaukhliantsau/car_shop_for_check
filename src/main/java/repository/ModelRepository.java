package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface ModelRepository {

    ResultSet getById(UUID modelId) throws SQLException;

    ResultSet getByName(String name) throws SQLException;

    ResultSet getByIdCompletion(UUID completionId) throws SQLException;

    ResultSet getAllModels() throws SQLException;

    ResultSet create(String name, UUID completionId) throws SQLException;

    ResultSet update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    ResultSet delete(UUID modelId) throws SQLException;
}
