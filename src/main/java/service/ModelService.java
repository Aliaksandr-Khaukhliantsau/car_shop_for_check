package service;

import entity.Model;

import java.sql.SQLException;
import java.util.List;

public interface ModelService {

    List<Model> getById(String id) throws SQLException;

    List<Model> getByName(String name) throws SQLException;

    List<Model> getByIdCompletion(String idCompletion) throws SQLException;

    List<Model> getAllModels() throws SQLException;

    List<Model> create(String name, String idCompletion) throws SQLException;

    List<Model> update(String id, String name, String idCompletion) throws SQLException;

    List<Model> delete(String id) throws SQLException;
}
