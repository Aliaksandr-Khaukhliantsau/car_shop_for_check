package service;

import dto.CarModelDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CarModelService interface provides methods for interacting with car model data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CarModelService {
    /**
     * Retrieves a car model DTO by its ID.
     *
     * @param modelId the ID of the car model.
     * @return the car model DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarModelDto getCarModelByModelId(UUID modelId) throws SQLException;

    /**
     * Retrieves all car model DTOs with a specific name.
     *
     * @param modelName the name of the car models.
     * @return a list of car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarModelDto> getCarModelByModelName(String modelName) throws SQLException;

    /**
     * Retrieves all car model DTOs for a specific completion.
     *
     * @param completionId the ID of the completion.
     * @return a list of car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarModelDto> getCarModelByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves all car model DTOs.
     *
     * @return a list of all car model DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarModelDto> getAllCarModels() throws SQLException;

    /**
     * Creates a new car model record in the database with the provided name and completion ID.
     *
     * @param modelName    the name of the new car model.
     * @param completionId the ID of the completion of the new car model.
     * @throws SQLException if a database access error occurs.
     */
    void create(String modelName, UUID completionId) throws SQLException;

    /**
     * Updates an existing car model record in the database with a new name and completion ID using its ID and the new name and completion ID.
     *
     * @param modelId      the ID of the car model to update.
     * @param modelName    the new name for the car model record.
     * @param completionId the new completion ID for the car model record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID modelId, String modelName, UUID completionId) throws SQLException;

    /**
     * Deletes a specific car model record from the database using its ID.
     *
     * @param modelId the ID of the car model to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID modelId) throws SQLException;
}
