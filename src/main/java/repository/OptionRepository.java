package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OptionRepository {

    ResultSet getById(String id) throws SQLException;

    ResultSet getByName(String name) throws SQLException;

    ResultSet getAllOptions() throws SQLException;

    ResultSet create(String name) throws SQLException;

    ResultSet update(String id, String name) throws SQLException;

    ResultSet delete(String id) throws SQLException;
}
