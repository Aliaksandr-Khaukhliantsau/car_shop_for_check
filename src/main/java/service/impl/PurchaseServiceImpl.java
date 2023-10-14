package service.impl;

import dto.PurchaseDto;
import mapper.PurchaseMapper;
import repository.PurchaseRepository;
import repository.impl.PurchaseRepositoryImpl;
import service.PurchaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of the PurchaseService interface.
 */
public class PurchaseServiceImpl implements PurchaseService {
    private static final PurchaseMapper purchaseMapper = PurchaseMapper.INSTANCE;

    PurchaseRepository purchaseRepository = new PurchaseRepositoryImpl();

    /**
     * Constructor for the PurchaseServiceImpl class.
     *
     * @throws SQLException if a database access error occurs.
     */
    public PurchaseServiceImpl() throws SQLException {
    }

    /**
     * Retrieves a purchase by its ID.
     *
     * @param purchaseId The ID of the purchase.
     * @return The purchase DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public PurchaseDto getPurchaseByPurchaseId(UUID purchaseId) throws SQLException {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.getPurchaseByPurchaseId(purchaseId));
    }

    /**
     * Retrieves a purchase by its number.
     *
     * @param purchaseNumber The number of the purchase.
     * @return The purchase DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public PurchaseDto getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.getPurchaseByPurchaseNumber(purchaseNumber));
    }

    /**
     * Retrieves all purchases made by a specific customer.
     *
     * @param customerId The ID of the customer.
     * @return A list of purchase DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<PurchaseDto> getPurchaseByCustomerId(UUID customerId) throws SQLException {
        return purchaseRepository.getPurchaseByCustomerId(customerId).stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all purchases of a specific car.
     *
     * @param carId The ID of the car.
     * @return A list of purchase DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<PurchaseDto> getPurchaseByCarId(UUID carId) throws SQLException {
        return purchaseRepository.getPurchaseByCarId(carId).stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }

    /**
     * Retrieves all purchases.
     *
     * @return A list of all purchase DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<PurchaseDto> getAllPurchases() throws SQLException {
        return purchaseRepository.getAllPurchases().stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }

    /**
     * Creates a new purchase record in the database for a specific customer and car.
     *
     * @param customerId The ID of the customer making the purchase.
     * @param carId      The ID of the car being purchased.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(UUID customerId, UUID carId) throws SQLException {
        purchaseRepository.create(customerId, carId);
    }

    /**
     * Updates an existing purchase record in the database with new customer and car IDs.
     *
     * @param purchaseId The ID of the purchase to update.
     * @param customerId The new customer ID for the purchase record.
     * @param carId      The new car ID for the purchase record.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException {
        purchaseRepository.update(purchaseId, customerId, carId);
    }

    /**
     * Deletes a specific purchase record from the database using its ID.
     *
     * @param purchaseId The ID of the purchase to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID purchaseId) throws SQLException {
        purchaseRepository.delete(purchaseId);
    }
}
