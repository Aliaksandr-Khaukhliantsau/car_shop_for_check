package service;

import entity.CarModel;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarModelService {
    CarModel getCarModelByModelId(UUID modelId) throws SQLException;

    List<CarModel> getCarModelByModelName(String modelName) throws SQLException;

    List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException;

    List<CarModel> getAllCarModels() throws SQLException;

    List<CarModel> create(String modelName, UUID completionId) throws SQLException;

    List<CarModel> update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    List<CarModel> delete(UUID modelId) throws SQLException;
}
