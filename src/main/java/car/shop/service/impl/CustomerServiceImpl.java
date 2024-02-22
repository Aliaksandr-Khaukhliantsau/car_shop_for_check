package car.shop.service.impl;

import car.shop.dto.CustomerDto;
import car.shop.entity.Customer;
import car.shop.mapper.CustomerMapper;
import car.shop.repository.CustomerRepository;
import car.shop.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    @Transactional
    public CustomerDto getById(UUID id) {
        return customerMapper.customerToCustomerDto(customerRepository.getById(id));
    }

    @Override
    @Transactional
    public List<CustomerDto> getByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName).stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CustomerDto> getByMiddleName(String middleName) {
        return customerRepository.findByMiddleName(middleName).stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CustomerDto> getByLastName(String lastName) {
        return customerRepository.findByLastName(lastName).stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(String firstName, String middleName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setMiddleName(middleName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void update(UUID id, String firstName, String middleName, String lastName) {
        Customer customer = customerRepository.getById(id);
        if (customer != null) {
            customer.setFirstName(firstName);
            customer.setMiddleName(middleName);
            customer.setLastName(lastName);
            customerRepository.save(customer);
        }
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }
}

