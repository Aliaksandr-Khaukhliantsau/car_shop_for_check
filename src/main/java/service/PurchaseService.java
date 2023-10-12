package service;

import dto.PurchaseDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface PurchaseService {
    PurchaseDto getPurchaseByPurchaseId(UUID purchaseId) throws SQLException;

    PurchaseDto getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException;

    List<PurchaseDto> getPurchaseByCustomerId(UUID CustomerId) throws SQLException;

    List<PurchaseDto> getPurchaseByCarId(UUID carId) throws SQLException;

    List<PurchaseDto> getAllPurchases() throws SQLException;

    void create(UUID customerId, UUID carId) throws SQLException;

    void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException;

    void delete(UUID purchaseId) throws SQLException;
}
