package repository;

import entity.CarModel;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CarModelRepository {
    CarModel getCarModelByModelId(UUID modelId) throws SQLException;

    List<CarModel> getCarModelByModelName(String modelName) throws SQLException;

    List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException;

    List<CarModel> getAllCarModels() throws SQLException;

    void create(String modelName, UUID completionId) throws SQLException;

    void update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    void delete(UUID modelId) throws SQLException;
}
