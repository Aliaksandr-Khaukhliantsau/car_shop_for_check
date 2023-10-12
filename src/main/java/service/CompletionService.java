package service;

import dto.CompletionDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CompletionService {
    CompletionDto getCompletionByCompletionId(UUID completionId) throws SQLException;

    CompletionDto getCompletionByCompletionName(String completionName) throws SQLException;

    List<CompletionDto> getAllCompletions() throws SQLException;

    void addCarOption(UUID CompletionId, UUID optionId) throws SQLException;

    void deleteCarOption(UUID completionId, UUID optionId) throws SQLException;

    void create(String completionName) throws SQLException;

    void update(UUID CompletionId, String completionName) throws SQLException;

    void delete(UUID CompletionId) throws SQLException;
}
