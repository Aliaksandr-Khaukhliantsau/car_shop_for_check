package service.impl;

import entity.CarModel;
import repository.CarModelRepository;
import repository.impl.CarModelRepositoryImpl;
import service.CarModelService;

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
            carModel.setModelId(resultSet.getString("id"));
            carModel.setModelName(resultSet.getString("name"));
            carModel.setCompletionId(resultSet.getString("idcompletion"));

        }
        return carModel;
    }

    @Override
    public List<CarModel> getCarModelByModelName(String modelName) throws SQLException {
        ResultSet resultSet = carModelRepository.getCarModelByModelName(modelName);
        List<CarModel> carModelList = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(resultSet.getString("id"));
            carModel.setModelName(resultSet.getString("name"));
            carModel.setCompletionId(resultSet.getString("idcompletion"));

            carModelList.add(carModel);
        }
        return carModelList;
    }

    @Override
    public List<CarModel> getCarModelByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet = carModelRepository.getCarModelByCompletionId(completionId);
        List<CarModel> carModelList = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(resultSet.getString("id"));
            carModel.setModelName(resultSet.getString("name"));
            carModel.setCompletionId(resultSet.getString("idcompletion"));

            carModelList.add(carModel);
        }
        return carModelList;
    }

    @Override
    public List<CarModel> getAllCarModels() throws SQLException {
        ResultSet resultSet = carModelRepository.getAllCarModels();
        List<CarModel> carModelList = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(resultSet.getString("id"));
            carModel.setModelName(resultSet.getString("name"));
            carModel.setCompletionId(resultSet.getString("idcompletion"));

            carModelList.add(carModel);
        }
        return carModelList;
    }

    @Override
    public List<CarModel> create(String modelName, UUID completionId) throws SQLException {
        ResultSet resultSet = carModelRepository.create(modelName, completionId);
        List<CarModel> carModelList = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(resultSet.getString("id"));
            carModel.setModelName(resultSet.getString("name"));
            carModel.setCompletionId(resultSet.getString("idcompletion"));

            carModelList.add(carModel);
        }
        return carModelList;
    }

    @Override
    public List<CarModel> update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        ResultSet resultSet = carModelRepository.update(modelId, modelName, completionId);
        List<CarModel> carModelList = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(resultSet.getString("id"));
            carModel.setModelName(resultSet.getString("name"));
            carModel.setCompletionId(resultSet.getString("idcompletion"));

            carModelList.add(carModel);
        }
        return carModelList;
    }

    @Override
    public List<CarModel> delete(UUID modelId) throws SQLException {
        ResultSet resultSet = carModelRepository.delete(modelId);
        List<CarModel> carModelList = new ArrayList<>();

        while (resultSet.next()) {
            CarModel carModel = new CarModel();
            carModel.setModelId(resultSet.getString("id"));
            carModel.setModelName(resultSet.getString("name"));
            carModel.setCompletionId(resultSet.getString("idcompletion"));

            carModelList.add(carModel);
        }
        return carModelList;
    }
}
