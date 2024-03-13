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

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testGetById() {
        UUID customerId = UUID.randomUUID();
        Customer customer = new Customer();
        customer.setId(customerId);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customerId);

        when(customerRepository.getById(customerId)).thenReturn(customer);
        when(customerMapper.customerToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getById(customerId);

        assertEquals(customerDto, result);
        verify(customerRepository, times(1)).getById(customerId);
        verify(customerMapper, times(1)).customerToCustomerDto(customer);
    }

    @Test
    public void testGetByFirstName() {
        String firstName = "Иван";
        Customer customer1 = new Customer();
        customer1.setId(UUID.randomUUID());
        Customer customer2 = new Customer();
        customer2.setId(UUID.randomUUID());
        CustomerDto customerDto1 = new CustomerDto();
        CustomerDto customerDto2 = new CustomerDto();

        when(customerRepository.findByFirstName(firstName)).thenReturn(Arrays.asList(customer1, customer2));
        when(customerMapper.customerToCustomerDto(customer1)).thenReturn(customerDto1);
        when(customerMapper.customerToCustomerDto(customer2)).thenReturn(customerDto2);

        List<CustomerDto> result = customerService.getByFirstName(firstName);

        assertEquals(2, result.size());
        assertEquals(customerDto1, result.get(0));
        assertEquals(customerDto2, result.get(1));
        verify(customerRepository, times(1)).findByFirstName(firstName);
        verify(customerMapper, times(2)).customerToCustomerDto(any());
    }

    @Test
    public void testGetByMiddleName() {
        String middleName = "Иванов";
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());
        List<CustomerDto> expectedDtos = Arrays.asList(new CustomerDto(), new CustomerDto());
        when(customerRepository.findByMiddleName(middleName)).thenReturn(customers);
        when(customerMapper.customerToCustomerDto(any())).thenReturn(expectedDtos.get(0), expectedDtos.get(1));

        List<CustomerDto> actualDtos = customerService.getByMiddleName(middleName);

        assertEquals(expectedDtos, actualDtos);
    }

    @Test
    public void testGetByLastName() {
        String lastName = "Иванович";
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());
        List<CustomerDto> expectedDtos = Arrays.asList(new CustomerDto(), new CustomerDto());
        when(customerRepository.findByLastName(lastName)).thenReturn(customers);
        when(customerMapper.customerToCustomerDto(any())).thenReturn(expectedDtos.get(0), expectedDtos.get(1));

        List<CustomerDto> actualDtos = customerService.getByLastName(lastName);

        assertEquals(expectedDtos, actualDtos);
    }

    @Test
    public void testGetAll() {
        List<Customer> customers = Arrays.asList(new Customer(), new Customer());
        List<CustomerDto> expectedDtos = Arrays.asList(new CustomerDto(), new CustomerDto());
        when(customerRepository.findAll()).thenReturn(customers);
        when(customerMapper.customerToCustomerDto(any())).thenReturn(expectedDtos.get(0), expectedDtos.get(1));

        List<CustomerDto> actualDtos = customerService.getAll();

        assertEquals(expectedDtos, actualDtos);
    }

    @Test
    public void testCreate() {
        Customer customer = new Customer();
        customerService.create(customer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customerService.update(customer);
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    public void testDelete() {
        UUID id = UUID.randomUUID();
        customerService.delete(id);
        verify(customerRepository, times(1)).deleteById(id);
    }
}
