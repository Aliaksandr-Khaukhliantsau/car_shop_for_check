package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CompletionRepository {
    ResultSet getCompletionByCompletionId(UUID completionId) throws SQLException;

    ResultSet getCompletionByCompletionName(String completionName) throws SQLException;

    ResultSet getAllCompletions() throws SQLException;

    void create(String completionName) throws SQLException;

    void update(UUID completionId, String completionName) throws SQLException;

    void delete(UUID completionId) throws SQLException;
}
