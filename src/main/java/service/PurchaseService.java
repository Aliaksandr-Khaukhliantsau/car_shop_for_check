package service;

import entity.Car;
import entity.Customer;
import entity.Purchase;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface PurchaseService {
    List<Purchase> getPurchaseByPurchaseId(UUID purchaseId) throws SQLException;

    List<Purchase> getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException;

    List<Purchase> getPurchaseByCustomerId(UUID CustomerId) throws SQLException;

    List<Purchase> getPurchaseByCarId(UUID carId) throws SQLException;

    List<Purchase> getPurchaseByCustomer(Customer customer) throws SQLException;

    List<Purchase> getPurchaseByCar(Car car) throws SQLException;

    List<Purchase> getAllPurchases() throws SQLException;

    List<Purchase> create(UUID customerId, UUID carId) throws SQLException;

    List<Purchase> update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException;

    List<Purchase> delete(UUID purchaseId) throws SQLException;
}
