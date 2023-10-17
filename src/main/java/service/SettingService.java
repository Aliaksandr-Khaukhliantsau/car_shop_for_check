package service;

import dto.SettingDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The SettingService interface provides methods for interacting with car setting data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface SettingService {
    /**
     * Retrieves a car setting DTO by its ID.
     *
     * @param id the ID of the car setting.
     * @return the car setting DTO.
     * @throws SQLException if a database access error occurs.
     */
    SettingDto getById(UUID id) throws SQLException;

    /**
     * Retrieves a car setting DTO by its name.
     *
     * @param settingName the name of the car setting.
     * @return the car setting DTO.
     * @throws SQLException if a database access error occurs.
     */
    SettingDto getBySettingName(String settingName) throws SQLException;

    /**
     * Retrieves all car setting DTOs for a specific completion.
     *
     * @param completionId the ID of the completion.
     * @return a list of car setting DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<SettingDto> getByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves all car setting DTOs.
     *
     * @return a list of all car setting DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<SettingDto> getAll() throws SQLException;

    /**
     * Creates a new car setting record in the database with the provided name.
     *
     * @param settingName the name of the new car setting.
     * @throws SQLException if a database access error occurs.
     */
    void create(String settingName) throws SQLException;

    /**
     * Updates an existing car setting record in the database with a new name using its ID and the new name.
     *
     * @param id          the ID of the car setting to update.
     * @param settingName the new name for the car setting record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID id, String settingName) throws SQLException;

    /**
     * Deletes a specific car setting record from the database using its ID.
     *
     * @param id the ID of the car setting to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID id) throws SQLException;
}
