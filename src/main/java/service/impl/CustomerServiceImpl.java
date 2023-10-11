package service.impl;

import dto.CustomerDto;
import mapper.CustomerMapper;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private static final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public CustomerServiceImpl() throws SQLException {
    }

    @Override
    public CustomerDto getCustomerByCustomerId(UUID customerId) throws SQLException {
        return customerMapper.customerToCustomerDto(customerRepository.getCustomerByCustomerId(customerId));
    }

    @Override
    public List<CustomerDto> getCustomerByFirstName(String firstName) throws SQLException {
        return customerRepository.getCustomerByFirstName(firstName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomerByMiddleName(String middleName) throws SQLException {
        return customerRepository.getCustomerByMiddleName(middleName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomerByLastName(String lastName) throws SQLException {
        return customerRepository.getCustomerByLastName(lastName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        return customerRepository.getAllCustomers().stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    @Override
    public void create(String firstName, String middleName, String lastName) throws SQLException {
        customerRepository.create(firstName, middleName, lastName);
    }

    @Override
    public void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
        customerRepository.update(customerId, firstName, middleName, lastName);
    }

    @Override
    public void delete(UUID customerId) throws SQLException {
        customerRepository.delete(customerId);
    }
}
