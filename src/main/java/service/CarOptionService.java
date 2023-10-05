package service;

import entity.CarOption;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarOptionService {
    CarOption getCarOptionByOptionId(UUID optionId) throws SQLException;

    CarOption getCarOptionByOptionName(String optionName) throws SQLException;

    List<CarOption> getAllCarOptions() throws SQLException;

    void create(String optionName) throws SQLException;

    void update(UUID optionId, String optionName) throws SQLException;

    void delete(UUID optionId) throws SQLException;
}
