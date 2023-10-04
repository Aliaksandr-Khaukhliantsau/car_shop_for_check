package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CompletionCarOptionRepository {
    ResultSet getCompletionCarOptionByCompletionId(UUID completionId) throws SQLException;

    ResultSet getCompletionCarOptionByOptionId(UUID optionId) throws SQLException;

    ResultSet getAllCompletionCarOptions() throws SQLException;

    ResultSet create(UUID completionId, UUID optionId) throws SQLException;

    ResultSet delete(UUID completionId, UUID optionId) throws SQLException;
}
