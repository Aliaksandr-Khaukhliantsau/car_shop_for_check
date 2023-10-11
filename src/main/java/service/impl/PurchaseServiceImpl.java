package service.impl;

import entity.Purchase;
import repository.PurchaseRepository;
import repository.impl.PurchaseRepositoryImpl;
import service.PurchaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class PurchaseServiceImpl implements PurchaseService {
    PurchaseRepository purchaseRepository = new PurchaseRepositoryImpl();

    public PurchaseServiceImpl() throws SQLException {
    }

    @Override
    public Purchase getPurchaseByPurchaseId(UUID purchaseId) throws SQLException {
        return purchaseRepository.getPurchaseByPurchaseId(purchaseId);
    }

    @Override
    public Purchase getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException {
        return purchaseRepository.getPurchaseByPurchaseNumber(purchaseNumber);
    }

    @Override
    public List<Purchase> getPurchaseByCustomerId(UUID customerId) throws SQLException {
        return purchaseRepository.getPurchaseByCustomerId(customerId);
    }

    @Override
    public List<Purchase> getPurchaseByCarId(UUID carId) throws SQLException {
        return purchaseRepository.getPurchaseByCarId(carId);
    }

    @Override
    public List<Purchase> getAllPurchases() throws SQLException {
        return purchaseRepository.getAllPurchases();
    }

    @Override
    public void create(UUID customerId, UUID carId) throws SQLException {
        purchaseRepository.create(customerId, carId);
    }

    @Override
    public void update(UUID purchaseId, UUID customerId, UUID carId) throws SQLException {
        purchaseRepository.update(purchaseId, customerId, carId);
    }

    @Override
    public void delete(UUID purchaseId) throws SQLException {
        purchaseRepository.delete(purchaseId);
    }
}
