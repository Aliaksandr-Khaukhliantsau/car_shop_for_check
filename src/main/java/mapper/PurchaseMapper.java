package mapper;

import dto.PurchaseDto;
import entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The PurchaseMapper interface provides methods for mapping between Purchase and PurchaseDto objects.
 * This mapper also uses the CustomerMapper and CarMapper for mapping between Customer, Car and their respective DTOs.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(uses = {CustomerMapper.class, CarMapper.class})
public interface PurchaseMapper {

    /**
     * The singleton instance of the mapper.
     */
    PurchaseMapper PURCHASE_MAPPER = Mappers.getMapper(PurchaseMapper.class);

    /**
     * Maps a Purchase entity to a PurchaseDto. Also maps the Customer and Car entities to their respective DTOs.
     *
     * @param purchase the Purchase entity to be mapped.
     * @return the mapped PurchaseDto.
     */
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "car", target = "car")
    PurchaseDto purchaseToPurchaseDto(Purchase purchase);

    /**
     * Maps a PurchaseDto to a Purchase entity.
     *
     * @param purchaseDto the PurchaseDto to be mapped.
     * @return the mapped Purchase entity.
     */
    Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto);
}