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
 * The CustomerServiceImpl class implements the CustomerService interface.
 * This class provides methods to interact with customer data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CustomerServiceImpl implements CustomerService {
    private static final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    /**
     * Constructor for the CustomerServiceImpl class.
     *
     * @throws SQLException if a database access error occurs.
     */
    public CustomerServiceImpl() throws SQLException {
    }

    /**
     * This method retrieves a customer by their ID.
     *
     * @param customerId The ID of the customer to retrieve.
     * @return The customer with the specified ID.
     * @throws SQLException If an SQL error occurs while retrieving the customer.
     */
    @Override
    public CustomerDto getCustomerByCustomerId(UUID customerId) throws SQLException {
        return customerMapper.customerToCustomerDto(customerRepository.getCustomerByCustomerId(customerId));
    }

    /**
     * This method retrieves all customers with a specific first name.
     *
     * @param firstName The first name of the customers to retrieve.
     * @return A list of customers with the specified first name.
     * @throws SQLException If an SQL error occurs while retrieving the customers.
     */
    @Override
    public List<CustomerDto> getCustomerByFirstName(String firstName) throws SQLException {
        return customerRepository.getCustomerByFirstName(firstName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method retrieves all customers with a specific middle name.
     *
     * @param middleName The middle name of the customers to retrieve.
     * @return A list of customers with the specified middle name.
     * @throws SQLException If an SQL error occurs while retrieving the customers.
     */
    @Override
    public List<CustomerDto> getCustomerByMiddleName(String middleName) throws SQLException {
        return customerRepository.getCustomerByMiddleName(middleName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method retrieves all customers with a specific last name.
     *
     * @param lastName The last name of the customers to retrieve.
     * @return A list of customer DTOs with the specified last name.
     * @throws SQLException If an SQL error occurs while retrieving the customers.
     */
    @Override
    public List<CustomerDto> getCustomerByLastName(String lastName) throws SQLException {
        return customerRepository.getCustomerByLastName(lastName).stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method retrieves all customers.
     *
     * @return A list of all customer DTOs.
     * @throws SQLException If an SQL error occurs while retrieving the customers.
     */
    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        return customerRepository.getAllCustomers().stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }

    /**
     * This method creates a new customer record in the database with the provided names.
     *
     * @param firstName  The first name of the new customer.
     * @param middleName The middle name of the new customer.
     * @param lastName   The last name of the new customer.
     * @throws SQLException If an SQL error occurs while creating the new customer.
     */
    @Override
    public void create(String firstName, String middleName, String lastName) throws SQLException {
        customerRepository.create(firstName, middleName, lastName);
    }

    /**
     * This method updates an existing customer's information.
     *
     * @param customerId The ID of the customer to update.
     * @param firstName  The new first name for the customer.
     * @param middleName The new middle name for the customer.
     * @param lastName   The new last name for the customer.
     * @throws SQLException If an SQL error occurs while updating the customer's information.
     */
    @Override
    public void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
        customerRepository.update(customerId, firstName, middleName, lastName);
    }

    /**
     * This method deletes a customer by their ID.
     *
     * @param customerId The ID of the customer to delete.
     * @throws SQLException If an SQL error occurs while deleting the customer.
     */
    @Override
    public void delete(UUID customerId) throws SQLException {
        customerRepository.delete(customerId);
    }
}
