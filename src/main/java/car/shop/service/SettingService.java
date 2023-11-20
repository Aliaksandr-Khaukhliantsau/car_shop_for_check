package car.shop.service;

import car.shop.dto.SettingDto;

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
     */
    SettingDto getById(UUID id);

    /**
     * Retrieves a car setting DTO by its name.
     *
     * @param settingName the name of the car setting.
     * @return the car setting DTO.
     */
    SettingDto getBySettingName(String settingName);

//    /**
//     * Retrieves all car setting DTOs for a specific completion.
//     *
//     * @param completionId the ID of the completion.
//     * @return a list of car setting DTOs.
//     */
//    List<SettingDto> getByCompletionId(UUID completionId);

    /**
     * Retrieves all car setting DTOs.
     *
     * @return a list of all car setting DTOs.
     */
    List<SettingDto> getAll();

    /**
     * Creates a new car setting record in the database with the provided name.
     *
     * @param settingName the name of the new car setting.
     */
    void create(String settingName);

    /**
     * Updates an existing car setting record in the database with a new name using its ID and the new name.
     *
     * @param id          the ID of the car setting to update.
     * @param settingName the new name for the car setting record.
     */
    void update(UUID id, String settingName);

    /**
     * Deletes a specific car setting record from the database using its ID.
     *
     * @param id the ID of the car setting to delete.
     */
    void delete(UUID id);
}
