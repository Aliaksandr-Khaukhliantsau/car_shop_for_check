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

/**
 * Implementation of the CustomerService interface.
 * This class provides methods to interact with customer data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CustomerServiceImpl implements CustomerService {
    private static final CustomerMapper CUSTOMER_MAPPER = CustomerMapper.CUSTOMER_MAPPER;
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    /**
     * This method retrieves a customer DTO by their ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return the customer DTO.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public CustomerDto getById(UUID id) throws SQLException {
        return CUSTOMER_MAPPER.customerToCustomerDto(customerRepository.getById(id));
    }

    /**
     * This method retrieves all customer DTOs with a specific first name.
     *
     * @param firstName the first name of the customers to retrieve.
     * @return a list of customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CustomerDto> getByFirstName(String firstName) throws SQLException {
        return customerRepository.getByFirstName(firstName).stream().map(CUSTOMER_MAPPER::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method retrieves all customer DTOs with a specific middle name.
     *
     * @param middleName the middle name of the customers to retrieve.
     * @return a list of customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CustomerDto> getByMiddleName(String middleName) throws SQLException {
        return customerRepository.getByMiddleName(middleName).stream().map(CUSTOMER_MAPPER::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method retrieves all customer DTOs with a specific last name.
     *
     * @param lastName the last name of the customers to retrieve.
     * @return a list of customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CustomerDto> getByLastName(String lastName) throws SQLException {
        return customerRepository.getByLastName(lastName).stream().map(CUSTOMER_MAPPER::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method retrieves all customer DTOs.
     *
     * @return a list of all customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<CustomerDto> getAll() throws SQLException {
        return customerRepository.getAll().stream().map(CUSTOMER_MAPPER::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method creates a new customer record in the database with the provided names.
     *
     * @param firstName  the first name of the new customer.
     * @param middleName the middle name of the new customer.
     * @param lastName   the last name of the new customer.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String firstName, String middleName, String lastName) throws SQLException {
        customerRepository.create(firstName, middleName, lastName);
    }

    /**
     * This method updates an existing customer's information.
     *
     * @param id         the ID of the customer to update.
     * @param firstName  the new first name for the customer.
     * @param middleName the new middle name for the customer.
     * @param lastName   the new last name for the customer.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String firstName, String middleName, String lastName) throws SQLException {
        customerRepository.update(id, firstName, middleName, lastName);
    }

    /**
     * This method deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        customerRepository.delete(id);
    }
}
