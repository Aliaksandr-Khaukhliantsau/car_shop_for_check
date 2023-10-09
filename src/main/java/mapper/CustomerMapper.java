package mapper;

import dto.CustomerDTO;
import entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "customerId", target = "customer_id")
    @Mapping(source = "firstName", target = "first_name")
    @Mapping(source = "middleName", target = "middle_name")
    @Mapping(source = "lastName", target = "last_name")
    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(source = "customer_id", target = "customerId")
    @Mapping(source = "first_name", target = "firstName")
    @Mapping(source = "middle_name", target = "middleName")
    @Mapping(source = "last_name", target = "lastName")
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}