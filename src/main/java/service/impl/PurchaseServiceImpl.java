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

public class PurchaseServiceImpl implements PurchaseService {
    private static final PurchaseMapper purchaseMapper = PurchaseMapper.INSTANCE;

    PurchaseRepository purchaseRepository = new PurchaseRepositoryImpl();

    public PurchaseServiceImpl() throws SQLException {
    }

    @Override
    public PurchaseDto getPurchaseByPurchaseId(UUID purchaseId) throws SQLException {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.getPurchaseByPurchaseId(purchaseId));
    }

    @Override
    public PurchaseDto getPurchaseByPurchaseNumber(String purchaseNumber) throws SQLException {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.getPurchaseByPurchaseNumber(purchaseNumber));
    }

    @Override
    public List<PurchaseDto> getPurchaseByCustomerId(UUID customerId) throws SQLException {
        return purchaseRepository.getPurchaseByCustomerId(customerId).stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDto> getPurchaseByCarId(UUID carId) throws SQLException {
        return purchaseRepository.getPurchaseByCarId(carId).stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDto> getAllPurchases() throws SQLException {
        return purchaseRepository.getAllPurchases().stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
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
