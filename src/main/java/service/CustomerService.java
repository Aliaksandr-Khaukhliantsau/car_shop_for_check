package service;

import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CustomerService interface provides methods for interacting with customer data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CustomerService {

    /**
     * Retrieves a customer DTO by their ID.
     *
     * @param customerId the ID of the customer to retrieve.
     * @return the customer DTO.
     * @throws SQLException if a database access error occurs.
     */
    CustomerDto getCustomerByCustomerId(UUID customerId) throws SQLException;

    /**
     * Retrieves all customer DTOs with a specific first name.
     *
     * @param firstName the first name of the customers to retrieve.
     * @return a list of customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CustomerDto> getCustomerByFirstName(String firstName) throws SQLException;

    /**
     * Retrieves all customer DTOs with a specific last name.
     *
     * @param lastName the last name of the customers to retrieve.
     * @return a list of customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CustomerDto> getCustomerByLastName(String lastName) throws SQLException;

    /**
     * Retrieves all customer DTOs with a specific middle name.
     *
     * @param middleName the middle name of the customers to retrieve.
     * @return a list of customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CustomerDto> getCustomerByMiddleName(String middleName) throws SQLException;

    /**
     * Retrieves all customer DTOs.
     *
     * @return a list of all customer DTOs.
     * @throws SQLException if a database access error occurs.
     */
    List<CustomerDto> getAllCustomers() throws SQLException;

    /**
     * Creates a new customer record in the database with the provided names.
     *
     * @param firstName  the first name of the new customer.
     * @param middleName the middle name of the new customer.
     * @param lastName   the last name of the new customer.
     * @throws SQLException if a database access error occurs.
     */
    void create(String firstName, String middleName, String lastName) throws SQLException;

    /**
     * Updates an existing customer's information.
     *
     * @param customerId the ID of the customer to update.
     * @param firstName  the new first name for the customer.
     * @param middleName the new middle name for the customer.
     * @param lastName   the new last name for the customer.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException;

    /**
     * Deletes a customer by their ID.
     *
     * @param customerId the ID of the customer to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID customerId) throws SQLException;
}
