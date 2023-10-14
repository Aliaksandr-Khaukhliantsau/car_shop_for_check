package service;

import dto.CarDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Interface for the car service.
 */
public interface CarService {
    /**
     * Retrieves a car by its ID.
     *
     * @param carId The ID of the car.
     * @return The car DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarDto getCarByCarId(UUID carId) throws SQLException;

    /**
     * Retrieves a car by its VIN (Vehicle Identification Number).
     *
     * @param vin The VIN of the car.
     * @return The car DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarDto getCarByVin(String vin) throws SQLException;

    /**
     * Retrieves all cars of a specific model.
     *
     * @param modelId The ID of the model.
     * @return A list of car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarDto> getCarByModelId(UUID modelId) throws SQLException;

    /**
     * Retrieves all cars.
     *
     * @return A list of all car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarDto> getAllCars() throws SQLException;

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
