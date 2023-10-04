package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CarOptionRepository {
    ResultSet getCarOptionByOptionId(UUID optionId) throws SQLException;

    ResultSet getCarOptionByOptionName(String optionName) throws SQLException;

    ResultSet getAllCarOptions() throws SQLException;

    ResultSet create(String optionName) throws SQLException;

    ResultSet update(UUID optionId, String optionName) throws SQLException;

    ResultSet delete(UUID optionId) throws SQLException;
}
