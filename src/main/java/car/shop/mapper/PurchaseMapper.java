package car.shop.mapper;

import car.shop.dto.PurchaseDto;
import car.shop.entity.Purchase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, CarMapper.class})
public interface PurchaseMapper {

    PurchaseDto purchaseToPurchaseDto(Purchase purchase);

    Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto);
}