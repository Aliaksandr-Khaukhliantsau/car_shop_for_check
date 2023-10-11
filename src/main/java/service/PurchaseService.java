package service;

import entity.Purchase;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface PurchaseService {
    Purchase getPurchaseByPurchaseId(UUID purchaseId) throws SQLException;

    Purchase getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException;

    List<Purchase> getPurchaseByCustomerId(UUID CustomerId) throws SQLException;

    List<Purchase> getPurchaseByCarId(UUID carId) throws SQLException;

    List<Purchase> getAllPurchases() throws SQLException;

    void create(UUID customerId, UUID carId) throws SQLException;

    void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException;

    void delete(UUID purchaseId) throws SQLException;
}
