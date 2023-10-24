package repository;

import entity.Layout;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The LayoutRepository interface provides methods for interacting with car layout data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface LayoutRepository {

    /**
     * Retrieves a car layout by its ID.
     *
     * @param id the ID of the car layout.
     * @return the car layout entity.
     * @throws SQLException if a database access error occurs.
     */
    Layout getById(UUID id) throws SQLException;

    /**
     * Retrieves all car layouts with a specific name.
     *
     * @param layoutName the name of the car layouts.
     * @return a list of car layout entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Layout> getByLayoutName(String layoutName) throws SQLException;

    /**
     * Retrieves all car layouts for a specific completion.
     *
     * @param completionId the ID of the completion.
     * @return a list of car layout entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Layout> getByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves all car layouts.
     *
     * @return a list of all car layout entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Layout> getAll() throws SQLException;

    /**
     * Creates a new car layout record in the database with the provided name and completion ID.
     *
     * @param layoutName   the name of the new car layout.
     * @param completionId the ID of the completion of the new car layout.
     * @throws SQLException if a database access error occurs.
     */
    void create(String layoutName, UUID completionId) throws SQLException;

    /**
     * Updates an existing car layout record in the database with a new name and completion ID using its ID and the new name and completion ID.
     *
     * @param id           the ID of the car layout to update.
     * @param layoutName   the new name for the car layout record.
     * @param completionId the new completion ID for the car layout record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID id, String layoutName, UUID completionId) throws SQLException;

    /**
     * Deletes a specific car layout record from the database using its ID.
     *
     * @param id the ID of the car layout to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID id) throws SQLException;
}
