package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ModelRepository {

    ResultSet getById(String id) throws SQLException;

    ResultSet getByName(String name) throws SQLException;

    ResultSet getByIdCompletion(String idCompletion) throws SQLException;

    ResultSet getAllModels() throws SQLException;

    ResultSet create(String name, String idCompletion) throws SQLException;

    ResultSet update(String id, String name, String idCompletion) throws SQLException;

    ResultSet delete(String id) throws SQLException;
}
