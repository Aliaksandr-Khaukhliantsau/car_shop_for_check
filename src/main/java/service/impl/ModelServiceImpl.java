package service.impl;

import entity.Model;
import repository.ModelRepository;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelServiceImpl implements ModelService {
    ModelRepository modelRepository = new ModelRepositoryImpl();

    public ModelServiceImpl() throws SQLException {
    }

    @Override
    public List<Model> getById(String id) throws SQLException {
        ResultSet resultSet = modelRepository.getById(id);
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
    public List<Model> getByName(String name) throws SQLException {
        ResultSet resultSet = modelRepository.getByName(name);
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
    public List<Model> getByIdCompletion(String idCompletion) throws SQLException {
        ResultSet resultSet = modelRepository.getByIdCompletion(idCompletion);
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
    public List<Model> create(String name, String idCompletion) throws SQLException {
        ResultSet resultSet = modelRepository.create(name, idCompletion);
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
    public List<Model> update(String id, String name, String idCompletion) throws SQLException {
        ResultSet resultSet = modelRepository.update(id, name, idCompletion);
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
    public List<Model> delete(String id) throws SQLException {
        ResultSet resultSet = modelRepository.delete(id);
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
