package service;

import dto.PurchaseDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The PurchaseService interface provides methods for interacting with purchase data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface PurchaseService {
    /**
     * Retrieves a purchase DTO by its ID.
     *
     * @param purchaseId the ID of the purchase.
     * @return the purchase DTO.
     * @throws SQLException if a database access error occurs.
     */
    PurchaseDto getPurchaseByPurchaseId(UUID purchaseId) throws SQLException;

    /**
     * Retrieves a purchase DTO by its number.
     *
     * @param purchaseNumber the number of the purchase.
     * @return the purchase DTO.
     * @throws SQLException if a database access error occurs.
     */
    PurchaseDto getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException;

    /**
     * Retrieves all purchase DTOs made by a specific customer.
     *
     * @param customerId the ID of the customer.
     * @return a list of purchase DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<PurchaseDto> getPurchaseByCustomerId(UUID customerId) throws SQLException;

    /**
     * Retrieves all purchase DTOs of a specific car.
     *
     * @param carId the ID of the car.
     * @return a list of purchase DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<PurchaseDto> getPurchaseByCarId(UUID carId) throws SQLException;

    /**
     * Retrieves all purchase DTOs.
     *
     * @return a list of all purchase DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<PurchaseDto> getAllPurchases() throws SQLException;

    /**
     * Creates a new purchase record in the database for a specific customer and car.
     *
     * @param customerId the ID of the customer making the purchase.
     * @param carId      the ID of the car being purchased.
     * @throws SQLException if a database access error occurs.
     */
    void create(UUID customerId, UUID carId) throws SQLException;

    /**
     * Updates an existing purchase record in the database with new customer and car IDs.
     *
     * @param purchaseId the ID of the purchase to update.
     * @param customerId the new customer ID for the purchase record.
     * @param carId      the new car ID for the purchase record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException;

    /**
     * Deletes a specific purchase record from the database using its ID.
     *
     * @param purchaseId the ID of the purchase to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID purchaseId) throws SQLException;
}
