package car.shop.service.impl;

import car.shop.dto.PurchaseDto;
import car.shop.entity.Purchase;
import car.shop.mapper.PurchaseMapper;
import car.shop.repository.PurchaseRepository;
import car.shop.service.PurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;

    @Override
    @Transactional
    public PurchaseDto getById(UUID id) {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.getById(id));
    }

    @Override
    @Transactional
    public PurchaseDto getByPurchaseNumber(int purchaseNumber) {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.getByPurchaseNumber(purchaseNumber));
    }

    @Override
    @Transactional
    public List<PurchaseDto> getByCustomerId(UUID customerId) {
        return purchaseRepository.findByCustomerId(customerId).stream()
                .map(purchaseMapper::purchaseToPurchaseDto)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public List<PurchaseDto> getByCarId(UUID carId) {
        return purchaseRepository.findByCarId(carId).stream()
                .map(purchaseMapper::purchaseToPurchaseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<PurchaseDto> getAll() {
        return purchaseRepository.findAll().stream()
                .map(purchaseMapper::purchaseToPurchaseDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    @Transactional
    public void update(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Purchase purchase = purchaseRepository.getById(id);
        if (purchase != null) {
            purchase.getCar().setPurchase(null);
            purchase.getCustomer().getPurchases().remove(purchase);
            purchaseRepository.delete(purchase);
        }
    }
}
