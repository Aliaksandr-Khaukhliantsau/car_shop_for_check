package repository;

import entity.Completion;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CompletionRepository {
    Completion getCompletionByCompletionId(UUID completionId) throws SQLException;

    Completion getCompletionByCompletionName(String completionName) throws SQLException;

    List<Completion> getAllCompletions() throws SQLException;

    void addCarOption(UUID completionId, UUID optionId) throws SQLException;

    void deleteCarOption(UUID completionId, UUID optionId) throws SQLException;

    void create(String completionName) throws SQLException;

    void update(UUID completionId, String completionName) throws SQLException;

    void delete(UUID completionId) throws SQLException;
//    ResultSet getCompletionByCompletionId(UUID completionId) throws SQLException;
//
//    ResultSet getCompletionByCompletionName(String completionName) throws SQLException;
//
//    ResultSet getAllCompletions() throws SQLException;
//
//    void addCarOption(UUID completionId, UUID optionId) throws SQLException;
//
//    void deleteCarOption(UUID completionId, UUID optionId) throws SQLException;
//
//    void create(String completionName) throws SQLException;
//
//    void update(UUID completionId, String completionName) throws SQLException;
//
//    void delete(UUID completionId) throws SQLException;
}
