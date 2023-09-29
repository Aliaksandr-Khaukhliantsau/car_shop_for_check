package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CompletionOptionRepository {

    ResultSet getByIdCompletion(String idCompletion) throws SQLException;

    ResultSet getByIdOption(String idOption) throws SQLException;

    ResultSet getAllCompletionsOptions() throws SQLException;

    ResultSet create(String idCompletion, String idOption) throws SQLException;

//    ResultSet update(String idCompletion, String idOption) throws SQLException;

    ResultSet delete(String idCompletion, String idOption) throws SQLException;
}
