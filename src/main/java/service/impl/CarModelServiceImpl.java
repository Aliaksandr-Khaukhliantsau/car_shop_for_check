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

//    @Override
//    public CarModel getCarModelByModelId(UUID modelId) throws SQLException {
//        ResultSet resultSet = carModelRepository.getCarModelByModelId(modelId);
//        CarModel carModel = new CarModel();
//
//        while (resultSet.next()) {
//            carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
//            carModel.setModelName(resultSet.getString("model_name"));
//            UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
//            CompletionService completionService = new CompletionServiceImpl();
//            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));
//
//        }
//        return carModel;
//    }
//
//    @Override
//    public List<CarModel> getCarModelByModelName(String modelName) throws SQLException {
//        ResultSet resultSet = carModelRepository.getCarModelByModelName(modelName);
//        List<CarModel> carModels = new ArrayList<>();
//
//        while (resultSet.next()) {
//            CarModel carModel = new CarModel();
//            carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
//            carModel.setModelName(resultSet.getString("model_name"));
//            UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
//            CompletionService completionService = new CompletionServiceImpl();
//            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));
//
//            carModels.add(carModel);
//        }
//        return carModels;
//    }
//
//    @Override
//    public List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException {
//        ResultSet resultSet = carModelRepository.getCarModelByCompletionId(completionId);
//        List<CarModel> carModels = new ArrayList<>();
//
//        while (resultSet.next()) {
//            CarModel carModel = new CarModel();
//            carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
//            carModel.setModelName(resultSet.getString("model_name"));
//            CompletionService completionService = new CompletionServiceImpl();
//            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));
//
//            carModels.add(carModel);
//        }
//        return carModels;
//    }
//
//    @Override
//    public List<CarModel> getAllCarModels() throws SQLException {
//        ResultSet resultSet = carModelRepository.getAllCarModels();
//        List<CarModel> carModels = new ArrayList<>();
//
//        while (resultSet.next()) {
//            CarModel carModel = new CarModel();
//            carModel.setModelId(UUID.fromString(resultSet.getString("model_id")));
//            carModel.setModelName(resultSet.getString("model_name"));
//            UUID completionId = UUID.fromString(resultSet.getString("completion_id"));
//            CompletionService completionService = new CompletionServiceImpl();
//            carModel.setCompletion(completionService.getCompletionByCompletionId(completionId));
//
//            carModels.add(carModel);
//        }
//        return carModels;
//    }
//
//    @Override
//    public void create(String modelName, UUID completionId) throws SQLException {
//        carModelRepository.create(modelName, completionId);
//    }
//
//    @Override
//    public void update(UUID modelId, String modelName, UUID completionId) throws SQLException {
//        carModelRepository.update(modelId, modelName, completionId);
//    }
//
//    @Override
//    public void delete(UUID modelId) throws SQLException {
//        carModelRepository.delete(modelId);
//    }
}
