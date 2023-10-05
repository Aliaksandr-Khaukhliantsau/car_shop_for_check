package service;

import entity.CompletionCarOption;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CompletionCarOptionService {
    List<CompletionCarOption> getCompletionCarOptionByCompletionId(UUID completionId) throws SQLException;

    List<CompletionCarOption> getCompletionCarOptionByOptionId(UUID optionId) throws SQLException;

    List<CompletionCarOption> getAllCompletionCarOptions() throws SQLException;

    void create(UUID completionId, UUID optionId) throws SQLException;

    void delete(UUID completionId, UUID optionId) throws SQLException;
}
