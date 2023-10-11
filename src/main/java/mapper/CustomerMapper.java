package mapper;

import dto.CustomerDto;
import entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDto customerDTO);
}
