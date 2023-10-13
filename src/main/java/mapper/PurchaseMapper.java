package mapper;

import dto.PurchaseDto;
import entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CustomerMapper.class, CarMapper.class})
public interface PurchaseMapper {
    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "car", target = "car")
    PurchaseDto purchaseToPurchaseDto(Purchase purchase);

    Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto);
}