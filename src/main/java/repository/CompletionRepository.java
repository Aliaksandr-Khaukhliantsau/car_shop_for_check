package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CompletionRepository {

    ResultSet getById(String id) throws SQLException;

    ResultSet getByName(String name) throws SQLException;

    ResultSet getAllCompletions() throws SQLException;

    ResultSet create(String name) throws SQLException;

    ResultSet update(String id, String name) throws SQLException;

    ResultSet delete(String id) throws SQLException;
}
