package service;

import entity.CarOption;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarOptionService {
    List<CarOption> getCarOptionByOptionId(UUID optionId) throws SQLException;

    List<CarOption> getCarOptionByOptionName(String optionName) throws SQLException;

    List<CarOption> getAllCarOptions() throws SQLException;

    List<CarOption> create(String optionName) throws SQLException;

    List<CarOption> update(UUID optionId, String optionName) throws SQLException;

    List<CarOption> delete(UUID optionId) throws SQLException;
}
