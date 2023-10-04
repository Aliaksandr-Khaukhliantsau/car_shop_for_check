package service;

import entity.Completion;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CompletionService {
    List<Completion> getCompletionByCompletionId(UUID completionId) throws SQLException;

    List<Completion> getCompletionByCompletionName(String completionName) throws SQLException;

    List<Completion> getAllCompletions() throws SQLException;

    List<Completion> create(String completionName) throws SQLException;

    List<Completion> update(UUID CompletionId, String completionName) throws SQLException;

    List<Completion> delete(UUID CompletionId) throws SQLException;
}
