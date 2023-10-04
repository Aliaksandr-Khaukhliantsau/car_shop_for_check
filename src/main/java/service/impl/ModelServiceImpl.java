package service.impl;

import entity.Model;
import repository.ModelRepository;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ModelServiceImpl implements ModelService {
    ModelRepository modelRepository = new ModelRepositoryImpl();

    public ModelServiceImpl() throws SQLException {
    }

    @Override
    public Model getModelById(UUID modelId) throws SQLException {
        ResultSet resultSet = modelRepository.getById(modelId);
        Model model = new Model();

        while (resultSet.next()) {
            model.setId(resultSet.getString("id"));
            model.setName(resultSet.getString("name"));
            model.setIdCompletion(resultSet.getString("idcompletion"));

        }
        return model;
    }

    @Override
    public List<Model> getModelByName(String modelName) throws SQLException {
        ResultSet resultSet = modelRepository.getByName(modelName);
        List<Model> modelList = new ArrayList<>();

        while (resultSet.next()) {
            Model model = new Model();
            model.setId(resultSet.getString("id"));
            model.setName(resultSet.getString("name"));
            model.setIdCompletion(resultSet.getString("idcompletion"));

            modelList.add(model);
        }
        return modelList;
    }

    @Override
    public List<Model> getModelByCompletionId(UUID completionId) throws SQLException {
        ResultSet resultSet = modelRepository.getByIdCompletion(completionId);
        List<Model> modelList = new ArrayList<>();

        while (resultSet.next()) {
            Model model = new Model();
            model.setId(resultSet.getString("id"));
            model.setName(resultSet.getString("name"));
            model.setIdCompletion(resultSet.getString("idcompletion"));

            modelList.add(model);
        }
        return modelList;
    }

    @Override
    public List<Model> getAllModels() throws SQLException {
        ResultSet resultSet = modelRepository.getAllModels();
        List<Model> modelList = new ArrayList<>();

        while (resultSet.next()) {
            Model model = new Model();
            model.setId(resultSet.getString("id"));
            model.setName(resultSet.getString("name"));
            model.setIdCompletion(resultSet.getString("idcompletion"));

            modelList.add(model);
        }
        return modelList;
    }

    @Override
    public List<Model> create(String modelName, UUID completionId) throws SQLException {
        ResultSet resultSet = modelRepository.create(modelName, completionId);
        List<Model> modelList = new ArrayList<>();

        while (resultSet.next()) {
            Model model = new Model();
            model.setId(resultSet.getString("id"));
            model.setName(resultSet.getString("name"));
            model.setIdCompletion(resultSet.getString("idcompletion"));

            modelList.add(model);
        }
        return modelList;
    }

    @Override
    public List<Model> update(UUID modelId, String modelName, UUID completionId) throws SQLException {
        ResultSet resultSet = modelRepository.update(modelId, modelName, completionId);
        List<Model> modelList = new ArrayList<>();

        while (resultSet.next()) {
            Model model = new Model();
            model.setId(resultSet.getString("id"));
            model.setName(resultSet.getString("name"));
            model.setIdCompletion(resultSet.getString("idcompletion"));

            modelList.add(model);
        }
        return modelList;
    }

    @Override
    public List<Model> delete(UUID modelId) throws SQLException {
        ResultSet resultSet = modelRepository.delete(modelId);
        List<Model> modelList = new ArrayList<>();

        while (resultSet.next()) {
            Model model = new Model();
            model.setId(resultSet.getString("id"));
            model.setName(resultSet.getString("name"));
            model.setIdCompletion(resultSet.getString("idcompletion"));

            modelList.add(model);
        }
        return modelList;
    }
}
