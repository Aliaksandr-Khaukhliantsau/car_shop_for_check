package service;

import entity.Completion;

import java.sql.SQLException;
import java.util.List;

public interface CompletionService {

    List<Completion> getById(String id) throws SQLException;

    List<Completion> getByName(String name) throws SQLException;

    List<Completion> getAllCompletions() throws SQLException;

    List<Completion> create(String name) throws SQLException;

    List<Completion> update(String id, String name) throws SQLException;

    List<Completion> delete(String id) throws SQLException;
}
