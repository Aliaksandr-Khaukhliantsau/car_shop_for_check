package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CarModelRepository {
    ResultSet getCarModelByModelId(UUID modelId) throws SQLException;

    ResultSet getCarModelByModelName(String modelName) throws SQLException;

    ResultSet getCarModelByCompletionId(UUID completionId) throws SQLException;

    ResultSet getAllCarModels() throws SQLException;

    ResultSet create(String modelName, UUID completionId) throws SQLException;

    ResultSet update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    ResultSet delete(UUID modelId) throws SQLException;
}
