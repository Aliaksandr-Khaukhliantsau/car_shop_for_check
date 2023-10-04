package service;

import entity.Model;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface ModelService {

    Model getModelById(UUID modelId) throws SQLException;

    List<Model> getModelByName(String modelName) throws SQLException;

    List<Model> getModelByCompletionId(UUID completionId) throws SQLException;

    List<Model> getAllModels() throws SQLException;

    List<Model> create(String modelName, UUID completionId) throws SQLException;

    List<Model> update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    List<Model> delete(UUID modelId) throws SQLException;
}
