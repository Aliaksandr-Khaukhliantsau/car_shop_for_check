package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CarOptionRepository {
    ResultSet getCarOptionByOptionId(UUID optionId) throws SQLException;

    ResultSet getCarOptionByOptionName(String optionName) throws SQLException;

    ResultSet getAllCarOptions() throws SQLException;

    void create(String optionName) throws SQLException;

    void update(UUID optionId, String optionName) throws SQLException;

    void delete(UUID optionId) throws SQLException;
}
