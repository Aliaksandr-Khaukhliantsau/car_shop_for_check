package mapper;

import dto.CustomerDto;
import entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDTO);
}
