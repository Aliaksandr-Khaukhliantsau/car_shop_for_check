package car.shop.mapper;

import car.shop.dto.PurchaseDto;
import car.shop.entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, CarMapper.class})
public interface PurchaseMapper {

    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "car", target = "car")
    PurchaseDto purchaseToPurchaseDto(Purchase purchase);

    Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto);
}