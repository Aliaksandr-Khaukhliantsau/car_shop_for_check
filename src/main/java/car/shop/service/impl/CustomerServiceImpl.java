package car.shop.service.impl;

import car.shop.dto.CustomerDto;
import car.shop.entity.Customer;
import car.shop.mapper.CustomerMapper;
import car.shop.repository.CustomerRepository;
import car.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto getById(UUID id) {
        return customerRepository.findById(id).map(customerMapper::customerToCustomerDto).orElse(null);
    }

    @Override
    public List<CustomerDto> getByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getByMiddleName(String middleName) {
        return customerRepository.findByMiddleName(middleName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getByLastName(String lastName) {
        return customerRepository.findByLastName(lastName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public void create(String firstName, String middleName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setMiddleName(middleName);
        customer.setLastName(lastName);
        customerRepository.save(customer);
    }

    @Override
    public void update(UUID id, String firstName, String middleName, String lastName) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setFirstName(firstName);
            customer.setMiddleName(middleName);
            customer.setLastName(lastName);
            customerRepository.save(customer);
        }
    }

    @Override
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }
}

