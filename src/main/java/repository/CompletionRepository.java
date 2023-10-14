package repository;

import entity.Completion;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CompletionRepository interface provides methods for interacting with completion data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CompletionRepository {

    /**
     * Retrieves a completion by its ID.
     *
     * @param completionId The ID of the completion.
     * @return The completion entity.
     * @throws SQLException if a database access error occurs.
     */
    Completion getCompletionByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves a completion by its name.
     *
     * @param completionName The name of the completion.
     * @return The completion entity.
     * @throws SQLException if a database access error occurs.
     */
    Completion getCompletionByCompletionName(String completionName) throws SQLException;

    /**
     * Retrieves all completions.
     *
     * @return A list of all completion entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Completion> getAllCompletions() throws SQLException;

    /**
     * Adds a car option to a specific completion in the database using its ID and the ID of the car option.
     *
     * @param completionId The ID of the completion to add the car option to.
     * @param optionId     The ID of the car option to add.
     * @throws SQLException if a database access error occurs.
     */
    void addCarOption(UUID completionId, UUID optionId) throws SQLException;

    /**
     * Deletes a car option from a specific completion in the database using its ID and the ID of the car option.
     *
     * @param completionId The ID of the completion to delete the car option from.
     * @param optionId     The ID of the car option to delete.
     * @throws SQLException if a database access error occurs.
     */
    void deleteCarOption(UUID completionId, UUID optionId) throws SQLException;

    /**
     * Creates a new completion record in the database with the provided name.
     *
     * @param completionName The name of the new completion.
     * @throws SQLException if a database access error occurs.
     */
    void create(String completionName) throws SQLException;

    /**
     * Updates an existing completion record in the database with a new name using its ID and the new name.
     *
     * @param completionId   The ID of the completion to update.
     * @param completionName The new name for the completion record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID completionId, String completionName) throws SQLException;

    /**
     * Deletes a specific completion record from the database using its ID.
     *
     * @param completionId The ID of the completion to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID completionId) throws SQLException;
}
