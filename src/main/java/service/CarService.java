package service;

import dto.CarDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CarService interface provides methods for interacting with car data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CarService {

    /**
     * Retrieves a car DTO by its ID.
     *
     * @param id the ID of the car.
     * @return the car DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarDto getById(UUID id) throws SQLException;

    /**
     * Retrieves a car DTO by its VIN (vehicle identification number).
     *
     * @param vin the VIN of the car.
     * @return the car DTO.
     * @throws SQLException if a database access error occurs.
     */
    CarDto getByVin(String vin) throws SQLException;

    /**
     * Retrieves all car DTOs of a specific layout.
     *
     * @param layoutId the ID of the layout.
     * @return a list of car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarDto> getByLayoutId(UUID layoutId) throws SQLException;

    /**
     * Retrieves all car DTOs.
     *
     * @return a list of all car DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CarDto> getAll() throws SQLException;

    /**
     * Creates a new car record in the database with the provided VIN and layout ID.
     *
     * @param vin      the VIN of the new car.
     * @param layoutId the ID of the layout of the new car.
     * @throws SQLException if a database access error occurs.
     */
    void create(String vin, UUID layoutId) throws SQLException;

    /**
     * Updates an existing car record in the database with a new VIN and layout ID using its ID and the new VIN and layout ID.
     *
     * @param id       the ID of the car to update.
     * @param vin      the new VIN for the car record.
     * @param layoutId the new layout ID for the car record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID id, String vin, UUID layoutId) throws SQLException;

    /**
     * Deletes a specific car record from the database using its ID.
     *
     * @param id the ID of the car to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID id) throws SQLException;
}
