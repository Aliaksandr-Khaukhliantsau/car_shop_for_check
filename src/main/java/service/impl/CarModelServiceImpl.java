package service.impl;

import entity.CarModel;
import repository.CarModelRepository;
import repository.impl.CarModelRepositoryImpl;
import service.CarModelService;
import service.CompletionService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CarModelServiceImpl implements CarModelService {
    CarModelRepository carModelRepository = new CarModelRepositoryImpl();

    public CarModelServiceImpl() throws SQLException {
    }

    @Override
    public CarModel getCarModelByModelId(UUID modelId) throws SQLException {
        ResultSet resultSet = carModelRepository.getCarModelByModelId(modelId);
        CarModel carModel = new CarModel();

        while (resultSet.next()) {
            carModel.setModelId(UUID.fromString(resultSet.getString("id")));
            carModel.setModelName(resultSet.getString("name"));
            UUID completionId = UUID.fromString(resultSet.getString("idcompletion"));
            CompletionService completionService = new CompletionServiceImpl();
            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

        }
        return carModel;
    }

    @Override
    public List<CarModel> getCarModelByModelName(String modelName) throws SQLException {
        ResultSet resultSet = carModelRepository.getCarModelByModelName(modelName);
        List<CarModel> carModels = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(UUID.fromString(resultSet.getString("id")));
            carModel.setModelName(resultSet.getString("name"));
            UUID completionId = UUID.fromString(resultSet.getString("idcompletion"));
            CompletionService completionService = new CompletionServiceImpl();
            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

            carModels.add(carModel);
        }
        return carModels;
    }

    @Override
    public List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet = carModelRepository.getCarModelByCompletionId(completionId);
        List<CarModel> carModels = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(UUID.fromString(resultSet.getString("id")));
            carModel.setModelName(resultSet.getString("name"));
            CompletionService completionService = new CompletionServiceImpl();
            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

            carModels.add(carModel);
        }
        return carModels;
    }

    @Override
    public List<CarModel> getAllCarModels() throws SQLException {
        ResultSet resultSet = carModelRepository.getAllCarModels();
        List<CarModel> carModels = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(UUID.fromString(resultSet.getString("id")));
            carModel.setModelName(resultSet.getString("name"));
            UUID completionId = UUID.fromString(resultSet.getString("idcompletion"));
            CompletionService completionService = new CompletionServiceImpl();
            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));

            carModels.add(carModel);
        }
        return carModels;
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
