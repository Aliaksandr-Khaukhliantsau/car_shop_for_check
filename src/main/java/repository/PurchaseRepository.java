package repository;

import entity.Purchase;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Interface for the purchase repository.
 */
public interface PurchaseRepository {

    /**
     * Retrieves a purchase by its ID.
     *
     * @param purchaseId The ID of the purchase.
     * @return The purchase entity.
     * @throws SQLException if a database access error occurs.
     */
    Purchase getPurchaseByPurchaseId(UUID purchaseId) throws SQLException;

    /**
     * Retrieves a purchase by its number.
     *
     * @param purchaseNumber The number of the purchase.
     * @return The purchase entity.
     * @throws SQLException if a database access error occurs.
     */
    Purchase getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException;

    /**
     * Retrieves all purchases made by a specific customer.
     *
     * @param customerId The ID of the customer.
     * @return A list of purchase entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Purchase> getPurchaseByCustomerId(UUID customerId) throws SQLException;

    /**
     * Retrieves all purchases of a specific car.
     *
     * @param carId The ID of the car.
     * @return A list of purchase entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Purchase> getPurchaseByCarId(UUID carId) throws SQLException;

    /**
     * Retrieves all purchases.
     *
     * @return A list of all purchase entities.
     * @throws SQLException if a database access error occurs.
     */
    List<Purchase> getAllPurchases() throws SQLException;

    /**
     * Creates a new purchase record in the database for a specific customer and car.
     *
     * @param customerId The ID of the customer making the purchase.
     * @param carId      The ID of the car being purchased.
     * @throws SQLException if a database access error occurs.
     */
    void create(UUID customerId, UUID carId) throws SQLException;

    /**
     * Updates an existing purchase record in the database with new customer and car IDs using its ID and the new customer and car IDs.
     *
     * @param purchaseId The ID of the purchase to update.
     * @param customerId The new customer ID for the purchase record.
     * @param carId      The new car ID for the purchase record.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException;

    /**
     * Deletes a specific purchase record from the database using its ID.
     *
     * @param purchaseId The ID of the purchase to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID purchaseId) throws SQLException;
}
