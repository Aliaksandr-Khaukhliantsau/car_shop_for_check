package mapper;

import dto.PurchaseDto;
import entity.Purchase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The PurchaseMapper interface provides methods for mapping between Purchase and PurchaseDto objects.
 * It uses MapStruct, a code generator that simplifies the implementation of mappings between Java bean types.
 * This mapper also uses the CustomerMapper and CarMapper for mapping between Customer, Car and their respective DTOs.
 */
@Mapper(uses = {CustomerMapper.class, CarMapper.class})
public interface PurchaseMapper {

    /**
     * An instance of the PurchaseMapper, created by the MapStruct library.
     */
    PurchaseMapper INSTANCE = Mappers.getMapper(PurchaseMapper.class);

    /**
     * Maps a Purchase entity to a PurchaseDto. Also maps the Customer and Car entities to their respective DTOs.
     *
     * @param purchase The Purchase entity to be mapped.
     * @return The mapped PurchaseDto.
     */
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "car", target = "car")
    PurchaseDto purchaseToPurchaseDto(Purchase purchase);

    /**
     * Maps a PurchaseDto to a Purchase entity.
     *
     * @param purchaseDto The PurchaseDto to be mapped.
     * @return The mapped Purchase entity.
     */
    Purchase purchaseDtoToPurchase(PurchaseDto purchaseDto);
}