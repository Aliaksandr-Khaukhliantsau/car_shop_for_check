package car.shop.service.impl;

import car.shop.dto.PurchaseDto;
import car.shop.entity.Car;
import car.shop.entity.Customer;
import car.shop.entity.Purchase;
import car.shop.mapper.PurchaseMapper;
import car.shop.repository.CarRepository;
import car.shop.repository.CustomerRepository;
import car.shop.repository.PurchaseRepository;
import car.shop.service.PurchaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final PurchaseMapper purchaseMapper;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, CustomerRepository customerRepository, CarRepository carRepository, PurchaseMapper purchaseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public PurchaseDto getById(UUID id) {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.findById(id).orElse(null));
    }

    @Override
    public PurchaseDto getByPurchaseNumber(String purchaseNumber) {
        return purchaseMapper.purchaseToPurchaseDto(purchaseRepository.findByPurchaseNumber(purchaseNumber).orElse(null));
    }

    @Override
    public List<PurchaseDto> getByCustomerId(UUID customerId) {
        return purchaseRepository.findByCustomerId(customerId).stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }


    @Override
    public List<PurchaseDto> getByCarId(UUID carId) {
        return purchaseRepository.findByCarId(carId).stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }

    @Override
    public List<PurchaseDto> getAll() {
        return purchaseRepository.findAll().stream().map(purchaseMapper::purchaseToPurchaseDto).collect(Collectors.toList());
    }

    @Override
    public void create(UUID customerId, UUID carId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Car car = carRepository.findById(carId).orElse(null);
        if (customer != null && car != null) {
            Purchase purchase = new Purchase();
            purchase.setCustomerId(customerId);
            purchase.setCarId(carId);
            purchaseRepository.save(purchase);
        }
    }

    @Override
    public void update(UUID id, UUID customerId, UUID carId) {
        Purchase purchase = purchaseRepository.findById(id).orElse(null);
        Customer customer = customerRepository.findById(customerId).orElse(null);
        Car car = carRepository.findById(carId).orElse(null);
        if (purchase != null && customer != null && car != null) {
            purchase.setCustomerId(customerId);
            purchase.setCarId(carId);
            purchaseRepository.save(purchase);
        }
    }

    @Override
    public void delete(UUID id) {
        purchaseRepository.deleteById(id);
    }
}
