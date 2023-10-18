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
     * @param id the ID of the completion.
     * @return the completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    CompletionDto getById(UUID id) throws SQLException;

    /**
     * Retrieves a completion DTO by its name.
     *
     * @param completionName the name of the completion.
     * @return the completion DTO.
     * @throws SQLException if a database access error occurs.
     */
    CompletionDto getByCompletionName(String completionName) throws SQLException;

    /**
     * Retrieves all completion DTOs.
     *
     * @return a list of all completion DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CompletionDto> getAll() throws SQLException;

    /**
     * Adds a car setting to a specific completion in the database.
     *
     * @param id        the ID of the completion to add the car setting to.
     * @param settingId the ID of the car setting to add.
     * @throws SQLException if a database access error occurs.
     */
    void addSetting(UUID id, UUID settingId) throws SQLException;

    /**
     * Deletes a car setting from a specific completion in the database using its ID and the ID of the car setting.
     *
     * @param id        the ID of the completion to delete the car setting from.
     * @param settingId the ID of the car setting to delete.
     * @throws SQLException if a database access error occurs.
     */
    void deleteSetting(UUID id, UUID settingId) throws SQLException;

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
     * @param id             the ID of the completion to update.
     * @param completionName the new name for the completion record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID id, String completionName) throws SQLException;

    /**
     * Deletes a specific completion record from the database using its ID.
     *
     * @param id the ID of the completion to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID id) throws SQLException;
}
