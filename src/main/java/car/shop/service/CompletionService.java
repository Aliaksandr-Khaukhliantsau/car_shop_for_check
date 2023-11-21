//package car.shop.service;
//
//import car.shop.dto.CompletionDto;
//
//import java.util.List;
//import java.util.UUID;
//
///**
// * The CompletionService interface provides methods for interacting with completion data.
// *
// * @author Aliaksandr Khaukhliantsau
// * @version 1.0
// */
//public interface CompletionService {
//    /**
//     * Retrieves a completion DTO by its ID.
//     *
//     * @param id the ID of the completion.
//     * @return the completion DTO.
//     */
//    CompletionDto getById(UUID id);
//
//    /**
//     * Retrieves a completion DTO by its name.
//     *
//     * @param completionName the name of the completion.
//     * @return the completion DTO.
//     */
//    CompletionDto getByCompletionName(String completionName);
//
//    /**
//     * Retrieves all completion DTOs.
//     *
//     * @return a list of all completion DTOs.
//     */
//    List<CompletionDto> getAll();
//
////    /**
////     * Adds a car setting to a specific completion in the database.
////     *
////     * @param id        the ID of the completion to add the car setting to.
////     * @param settingId the ID of the car setting to add.
////     * @throws SQLException if a database access error occurs.
////     */
////    void addSetting(UUID id, UUID settingId) throws SQLException;
////
////    /**
////     * Deletes a car setting from a specific completion in the database using its ID and the ID of the car setting.
////     *
////     * @param id        the ID of the completion to delete the car setting from.
////     * @param settingId the ID of the car setting to delete.
////     * @throws SQLException if a database access error occurs.
////     */
////    void deleteSetting(UUID id, UUID settingId) throws SQLException;
//
//    /**
//     * Creates a new completion record in the database with the provided name.
//     *
//     * @param completionName the name of the new completion.
//     */
//    void create(String completionName);
//
//    /**
//     * Updates an existing completion record in the database with a new name using its ID and the new name.
//     *
//     * @param id             the ID of the completion to update.
//     * @param completionName the new name for the completion record.
//     */
//    void update(UUID id, String completionName);
//
//    /**
//     * Deletes a specific completion record from the database using its ID.
//     *
//     * @param id the ID of the completion to delete.
//     */
//    void delete(UUID id);
//}

package car.shop.service;

import car.shop.dto.CompletionDto;

import java.util.List;
import java.util.UUID;

public interface CompletionService {
    CompletionDto getById(UUID id);

    CompletionDto getByCompletionName(String completionName);

    List<CompletionDto> getAll();

    void addSettingToCompletion(UUID completionId, UUID settingId);

    void removeSettingFromCompletion(UUID completionId, UUID settingId);

    void create(String completionName);

    void update(UUID id, String completionName);

    void delete(UUID id);
}
