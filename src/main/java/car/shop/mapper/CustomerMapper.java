package car.shop.mapper;

import car.shop.dto.CustomerDto;
import car.shop.entity.Customer;
import org.mapstruct.Mapper;

/**
 * The CustomerMapper interface provides methods for mapping between Customer entities and CustomerDto data transfer objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    /**
     * The singleton instance of the mapper.
     */
//    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    /**
     * Maps a Customer entity to a CustomerDto.
     *
     * @param customer the Customer entity to map.
     * @return the mapped CustomerDto.
     */
    CustomerDto customerToCustomerDto(Customer customer);

    /**
     * Maps a CustomerDto to a Customer entity.
     *
     * @param customerDto the CustomerDto to map.
     * @return the mapped Customer entity.
     */
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
