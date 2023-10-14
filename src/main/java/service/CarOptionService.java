package service;

import dto.CarOptionDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Interface for the car option service.
 */
public interface CarOptionService {
    /**
     * Retrieves a car option by its ID.
     *
     * @param optionId The ID of the car option.
     * @return The car option DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarOptionDto getCarOptionByOptionId(UUID optionId) throws SQLException;

    /**
     * Retrieves a car option by its name.
     *
     * @param optionName The name of the car option.
     * @return The car option DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarOptionDto getCarOptionByOptionName(String optionName) throws SQLException;

    /**
     * Retrieves all car options for a specific completion.
     *
     * @param completionId The ID of the completion.
     * @return A list of car option DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarOptionDto> getCarOptionsByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves all car options.
     *
     * @return A list of all car option DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarOptionDto> getAllCarOptions() throws SQLException;

    /**
     * Creates a new car option record in the database with the provided name.
     *
     * @param optionName The name of the new car option.
     * @throws SQLException if a database access error occurs.
     */
    void create(String optionName) throws SQLException;

    /**
     * Updates an existing car option record in the database with a new name using its ID and the new name.
     *
     * @param optionId   The ID of the car option to update.
     * @param optionName The new name for the car option record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID optionId, String optionName) throws SQLException;

    /**
     * Deletes a specific car option record from the database using its ID.
     *
     * @param optionId The ID of the car option to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID optionId) throws SQLException;
}
