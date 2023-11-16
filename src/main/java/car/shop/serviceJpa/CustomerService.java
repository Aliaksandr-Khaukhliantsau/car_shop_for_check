package car.shop.serviceJpa;

import car.shop.dtoJpa.CustomerDto;
import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDto getById(UUID id);
    List<CustomerDto> getByFirstName(String firstName);
    List<CustomerDto> getByMiddleName(String middleName);
    List<CustomerDto> getByLastName(String lastName);
    List<CustomerDto> getAll();
    void create(String firstName, String middleName, String lastName);
    void update(UUID id, String firstName, String middleName, String lastName);
    void delete(UUID id);
}