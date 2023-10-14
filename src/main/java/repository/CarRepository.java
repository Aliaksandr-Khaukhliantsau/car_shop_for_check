package repository;

import entity.Car;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CarRepository interface provides methods for interacting with car data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CarRepository {

    /**
     * Retrieves a car by its ID.
     *
     * @param carId The ID of the car.
     * @return The car entity.
     * @throws SQLException if a database access error occurs.
     */
    Car getCarByCarId(UUID carId) throws SQLException;

    /**
     * Retrieves a car by its VIN (Vehicle Identification Number).
     *
     * @param vin The VIN of the car.
     * @return The car entity.
     * @throws SQLException if a database access error occurs.
     */
    Car getCarByVin(String vin) throws SQLException;

    /**
     * Retrieves all cars of a specific model.
     *
     * @param modelId The ID of the model.
     * @return A list of car entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Car> getCarByModelId(UUID modelId) throws SQLException;

    /**
     * Retrieves all cars.
     *
     * @return A list of all car entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Car> getAllCars() throws SQLException;

    /**
     * Creates a new car record in the database with the provided VIN and model ID.
     *
     * @param vin     The VIN of the new car.
     * @param modelId The ID of the model of the new car.
     * @throws SQLException if a database access error occurs.
     */
    void create(String vin, UUID modelId) throws SQLException;

    /**
     * Updates an existing car record in the database with a new VIN and model ID using its ID and the new VIN and model ID.
     *
     * @param carId   The ID of the car to update.
     * @param vin     The new VIN for the car record.
     * @param modelId The new model ID for the car record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID carId, String vin, UUID modelId) throws SQLException;

    /**
     * Deletes a specific car record from the database using its ID.
     *
     * @param carId The ID of the car to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID carId) throws SQLException;
}
