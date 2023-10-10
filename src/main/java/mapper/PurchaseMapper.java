package mapper;

import dto.PurchaseDTO;
import entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CustomerMapper.class, CarMapper.class})
public interface PurchaseMapper {
    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "car", target = "car")
    PurchaseDTO purchaseToPurchaseDTO(Purchase purchase);

//    CustomerDTO map(Customer customer);

//    CarDTO map(Car car);

    Purchase purchaseDTOToPurchase(PurchaseDTO purchaseDTO);

//    Customer mapDto(CustomerDTO customer);

//    Car mapDto(CarDTO car);
}