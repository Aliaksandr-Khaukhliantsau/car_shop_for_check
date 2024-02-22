package car.shop.service;

import car.shop.dto.PurchaseDto;
import car.shop.entity.Purchase;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {

    PurchaseDto getById(UUID id);

    PurchaseDto getByPurchaseNumber(int purchaseNumber);

    List<PurchaseDto> getByCustomerId(UUID customerId);

    List<PurchaseDto> getByCarId(UUID carId);

    List<PurchaseDto> getAll();

    void create(Purchase purchase);

    void update(Purchase purchase);

    void delete(UUID id);
}
