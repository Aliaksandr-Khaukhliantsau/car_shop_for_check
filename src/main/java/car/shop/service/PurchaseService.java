package car.shop.service;

import car.shop.dto.PurchaseDto;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {

    PurchaseDto getById(UUID id);

    PurchaseDto getByPurchaseNumber(String purchaseNumber);

    List<PurchaseDto> getByCustomerId(UUID customerId);

    List<PurchaseDto> getByCarId(UUID carId);

    List<PurchaseDto> getAll();

    void create(UUID customerId, UUID carId);

    void update(UUID id, UUID customerId, UUID carId);

    void delete(UUID id);
}
