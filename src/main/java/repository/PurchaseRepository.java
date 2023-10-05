package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface PurchaseRepository {
    ResultSet getPurchaseByPurchaseId(UUID purchaseId) throws SQLException;

    ResultSet getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException;

    ResultSet getPurchaseByCustomerId(UUID customerId) throws SQLException;

    ResultSet getPurchaseByCarId(UUID carId) throws SQLException;

    ResultSet getAllPurchases() throws SQLException;

    void create(UUID customerId, UUID carId) throws SQLException;

    void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException;

    void delete(UUID purchaseId) throws SQLException;
}
