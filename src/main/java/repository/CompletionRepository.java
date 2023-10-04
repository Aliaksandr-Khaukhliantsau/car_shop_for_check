package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CompletionRepository {
    ResultSet getCompletionByCompletionId(UUID completionId) throws SQLException;

    ResultSet getCompletionByCompletionName(String completionName) throws SQLException;

    ResultSet getAllCompletions() throws SQLException;

    ResultSet create(String completionName) throws SQLException;

    ResultSet update(UUID completionId, String completionName) throws SQLException;

    ResultSet delete(UUID completionId) throws SQLException;
}
