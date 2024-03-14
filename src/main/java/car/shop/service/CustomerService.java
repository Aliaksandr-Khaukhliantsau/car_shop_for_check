package car.shop.service;

import car.shop.dto.CustomerDto;
import car.shop.entity.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID id);

    List<CustomerDto> getByFirstName(String firstName);

    List<CustomerDto> getByMiddleName(String middleName);

    List<CustomerDto> getByLastName(String lastName);

    List<CustomerDto> getAll();

    void create(Customer customer);

    void update(Customer customer);

    void delete(UUID id);
}