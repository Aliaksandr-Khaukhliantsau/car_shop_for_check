package service;

import dto.CarModelDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarModelService {
    CarModelDto getCarModelByModelId(UUID modelId) throws SQLException;

    List<CarModelDto> getCarModelByModelName(String modelName) throws SQLException;

    List<CarModelDto> getCarModelByCompletionId(UUID completionId) throws SQLException;

    List<CarModelDto> getAllCarModels() throws SQLException;

    void create(String modelName, UUID completionId) throws SQLException;

    void update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    void delete(UUID modelId) throws SQLException;
}
