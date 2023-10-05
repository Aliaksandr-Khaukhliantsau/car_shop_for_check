package service;

import entity.Completion;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CompletionService {
    Completion getCompletionByCompletionId(UUID completionId) throws SQLException;

    Completion getCompletionByCompletionName(String completionName) throws SQLException;

    List<Completion> getAllCompletions() throws SQLException;

    void create(String completionName) throws SQLException;

    void update(UUID CompletionId, String completionName) throws SQLException;

    void delete(UUID CompletionId) throws SQLException;
}
