package service.impl;

import entity.CarModel;
import repository.CarModelRepository;
import repository.impl.CarModelRepositoryImpl;
import service.CarModelService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CarModelServiceImpl implements CarModelService {
    CarModelRepository carModelRepository = new CarModelRepositoryImpl();

    public CarModelServiceImpl() throws SQLException {
    }

    @Override
    public CarModel getCarModelByModelId(UUID modelId) throws SQLException {
        return carModelRepository.getCarModelByModelId(modelId);
    }

    @Override
    public List<CarModel> getCarModelByModelName(String modelName) throws SQLException {
        return carModelRepository.getCarModelByModelName(modelName);
    }

    @Override
    public List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException {
        return carModelRepository.getCarModelByCompletionId(completionId);
    }

    @Override
    public List<CarModel> getAllCarModels() throws SQLException {
        return carModelRepository.getAllCarModels();
    }

    @Override
    public void create(String modelName, UUID completionId) throws SQLException {
        carModelRepository.create(modelName, completionId);
    }

    @Override
    public void update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        carModelRepository.update(modelId, modelName, completionId);
    }

    @Override
    public void delete(UUID modelId) throws SQLException {
        carModelRepository.delete(modelId);
    }
}
