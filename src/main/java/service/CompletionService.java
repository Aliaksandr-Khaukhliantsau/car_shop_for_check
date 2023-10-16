package service;

import dto.CompletionDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CompletionService interface provides methods for interacting with completion data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CompletionService {
    /**
     * Retrieves a completion DTO by its ID.
     *
     * @param completionId the ID of the completion.
     * @return the completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    CompletionDto getCompletionByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves a completion DTO by its name.
     *
     * @param completionName the name of the completion.
     * @return the completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    CompletionDto getCompletionByCompletionName(String completionName) throws SQLException;

    /**
     * Retrieves all completion DTOs.
     *
     * @return a list of all completion DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CompletionDto> getAllCompletions() throws SQLException;

    /**
     * Adds a car option to a specific completion in the database.
     *
     * @param CompletionId the ID of the completion to add the car option to.
     * @param optionId     the ID of the car option to add.
     * @throws SQLException if a database access error occurs.
     */
    void addCarOption(UUID CompletionId, UUID optionId) throws SQLException;

    /**
     * Deletes a car option from a specific completion in the database using its ID and the ID of the car option.
     *
     * @param completionId the ID of the completion to delete the car option from.
     * @param optionId     the ID of the car option to delete.
     * @throws SQLException if a database access error occurs.
     */
    void deleteCarOption(UUID completionId, UUID optionId) throws SQLException;

    /**
     * Creates a new completion record in the database with the provided name.
     *
     * @param completionName the name of the new completion.
     * @throws SQLException if a database access error occurs.
     */
    void create(String completionName) throws SQLException;

    /**
     * Updates an existing completion record in the database with a new name using its ID and the new name.
     *
     * @param CompletionId   the ID of the completion to update.
     * @param completionName the new name for the completion record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID CompletionId, String completionName) throws SQLException;

    /**
     * Deletes a specific completion record from the database using its ID.
     *
     * @param CompletionId the ID of the completion to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID CompletionId) throws SQLException;
}
