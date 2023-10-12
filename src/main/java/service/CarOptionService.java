package service;

import dto.CarOptionDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarOptionService {
    CarOptionDto getCarOptionByOptionId(UUID optionId) throws SQLException;

    CarOptionDto getCarOptionByOptionName(String optionName) throws SQLException;

    List<CarOptionDto> getCarOptionsByCompletionId(UUID completionId) throws SQLException;

    List<CarOptionDto> getAllCarOptions() throws SQLException;

    void create(String optionName) throws SQLException;

    void update(UUID optionId, String optionName) throws SQLException;

    void delete(UUID optionId) throws SQLException;
}
