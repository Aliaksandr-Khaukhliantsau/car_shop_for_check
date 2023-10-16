package repository;

import entity.CarOption;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CarOptionRepository interface provides methods for interacting with car option data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CarOptionRepository {

    /**
     * Retrieves a car option by its ID.
     *
     * @param optionId the ID of the car option.
     * @return the car option entity.
     * @throws SQLException if a database access error occurs.
     */
    CarOption getCarOptionByOptionId(UUID optionId) throws SQLException;

    /**
     * Retrieves a car option by its name.
     *
     * @param optionName the name of the car option.
     * @return the car option entity.
     * @throws SQLException if a database access error occurs.
     */
    CarOption getCarOptionByOptionName(String optionName) throws SQLException;

    /**
     * Retrieves all car options for a specific completion.
     *
     * @param completionId the ID of the completion.
     * @return a list of car option entities.
     * @throws SQLException if a database access error occurs.
     */
    List<CarOption> getCarOptionsByCompletionId(UUID completionId) throws SQLException;

    /**
     * Retrieves all car options.
     *
     * @return a list of all car option entities.
     * @throws SQLException if a database access error occurs.
     */
    List<CarOption> getAllCarOptions() throws SQLException;

    /**
     * Creates a new car option record in the database with the provided name.
     *
     * @param optionName the name of the new car option.
     * @throws SQLException if a database access error occurs.
     */
    void create(String optionName) throws SQLException;

    /**
     * Updates an existing car option record in the database with a new name using its ID and the new name.
     *
     * @param optionId   the ID of the car option to update.
     * @param optionName the new name for the car option record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID optionId, String optionName) throws SQLException;

    /**
     * Deletes a specific car option record from the database using its ID.
     *
     * @param optionId the ID of the car option to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID optionId) throws SQLException;
}
