package car.shop.service.impl;

import car.shop.dto.CustomerDto;
import car.shop.entity.Customer;
import car.shop.mapper.CustomerMapper;
import car.shop.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @Test
    public void testGetById() {
//        UUID id = UUID.randomUUID();
        String id = "9eaefad3-b9d6-4476-a21e-93a698d4f4ef";

        Customer customer = new Customer();
        CustomerDto customerDto = new CustomerDto();

//        when(customerRepository.findById(id)).thenReturn(Optional.ofNullable(customer));
        when(customerRepository.findById(UUID.fromString(id))).thenReturn(Optional.ofNullable(customer));
        when(customerMapper.customerToCustomerDto(customer)).thenReturn(customerDto);

//        CustomerDto result = customerService.getById(id);
        CustomerDto result = customerService.getById(UUID.fromString(id));

//        verify(customerRepository, times(1)).findById(id);
        verify(customerRepository, times(1)).findById(UUID.fromString(id));
        verify(customerMapper, times(1)).customerToCustomerDto(customer);

        assertEquals(customerDto, result);
    }

    @Test
    public void testGetByFirstName() {
        String firstName = "Иван";

        List<Customer> customers = List.of(new Customer());
        List<CustomerDto> customerDtos = List.of(new CustomerDto());


        when(customerRepository.findByFirstName(firstName)).thenReturn(customers);
        when(customerMapper.customerToCustomerDto(customers.getFirst())).thenReturn(customerDtos.getFirst());

        List<CustomerDto> result = customerService.getByFirstName(firstName);

        verify(customerRepository, times(1)).findByFirstName(firstName);
        verify(customerMapper, times(1)).customerToCustomerDto(customers.getFirst());

        assertEquals(customerDtos, result);
    }

    @Test
    public void testGetByMiddleName() {
        String middleName = "Иванович";
        List<Customer> customers = List.of(new Customer());
        List<CustomerDto> customerDtos = List.of(new CustomerDto());

        when(customerRepository.findByMiddleName(middleName)).thenReturn(customers);
        when(customerMapper.customerToCustomerDto(customers.getFirst())).thenReturn(customerDtos.getFirst());

        List<CustomerDto> results = customerService.getByMiddleName(middleName);

        assertEquals(customerDtos, results);
        verify(customerRepository, times(1)).findByMiddleName(middleName);
        verify(customerMapper, times(1)).customerToCustomerDto(customers.getFirst());
    }

    @Test
    public void testGetByLastName() {
        String lastName = "Иванов";
        List<Customer> customers = List.of(new Customer());
        List<CustomerDto> customerDtos = List.of(new CustomerDto());

        when(customerRepository.findByLastName(lastName)).thenReturn(customers);
        when(customerMapper.customerToCustomerDto(customers.getFirst())).thenReturn(customerDtos.getFirst());

        List<CustomerDto> results = customerService.getByLastName(lastName);

        assertEquals(customerDtos, results);
        verify(customerRepository, times(1)).findByLastName(lastName);
        verify(customerMapper, times(1)).customerToCustomerDto(customers.getFirst());
    }

    @Test
    public void testGetAll() {
        List<Customer> customers = List.of(new Customer());
        List<CustomerDto> customerDtos = List.of(new CustomerDto());

        when(customerRepository.findAll()).thenReturn(customers);
        when(customerMapper.customerToCustomerDto(customers.getFirst())).thenReturn(customerDtos.getFirst());

        List<CustomerDto> results = customerService.getAll();

        assertEquals(customerDtos, results);
        verify(customerRepository, times(1)).findAll();
        verify(customerMapper, times(1)).customerToCustomerDto(customers.getFirst());
    }

    @Test
    public void testCreate() {
        String firstName = "Иван";
        String middleName = "Иванович";
        String lastName = "Иванов";
        Customer customer = new Customer();

        customerService.create(firstName, middleName, lastName);

        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void testUpdate() {
        UUID id = UUID.randomUUID();
//        String id = "9eaefad3-b9d6-4476-a21e-93a698d4f4ef";
        String firstName = "Test";
        String middleName = "Test";
        String lastName = "Test";
        Customer customer = new Customer();

        when(customerRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(customer));

        customerService.update(id, firstName, middleName, lastName);

        verify(customerRepository, times(1)).findById(id);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void testDelete() {
        UUID id = UUID.randomUUID();
//        String id = "9eaefad3-b9d6-4476-a21e-93a698d4f4ef";

        customerService.delete(id);

        verify(customerRepository, times(1)).deleteById(id);
    }
}
