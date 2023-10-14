package service;

import dto.CarModelDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Interface for the car model service.
 */
public interface CarModelService {
    /**
     * Retrieves a car model by its ID.
     *
     * @param modelId The ID of the car model.
     * @return The car model DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarModelDto getCarModelByModelId(UUID modelId) throws SQLException;

    /**
     * Retrieves all car models with a specific name.
     *
     * @param modelName The name of the car models.
     * @return A list of car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarModelDto> getCarModelByModelName(String modelName) throws SQLException;

    /**
     * Retrieves all car models for a specific completion.
     *
     * @param completionId The ID of the completion.
     * @return A list of car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarModelDto> getCarModelByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves all car models.
     *
     * @return A list of all car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarModelDto> getAllCarModels() throws SQLException;

    /**
     * Creates a new car model record in the database with the provided name and completion ID.
     *
     * @param modelName    The name of the new car model.
     * @param completionId The ID of the completion of the new car model.
     * @throws SQLException if a database access error occurs.
     */
    void create(String modelName, UUID completionId) throws SQLException;

    /**
     * Updates an existing car model record in the database with a new name and completion ID using its ID and the new name and completion ID.
     *
     * @param modelId      The ID of the car model to update.
     * @param modelName    The new name for the car model record.
     * @param completionId The new completion ID for the car model record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    /**
     * Deletes a specific car model record from the database using its ID.
     *
     * @param modelId The ID of the car model to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID modelId) throws SQLException;
}
