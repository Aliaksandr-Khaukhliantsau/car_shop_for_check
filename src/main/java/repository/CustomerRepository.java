package repository;

import entity.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * The CustomerRepository interface provides methods for interacting with customer data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public interface CustomerRepository {

    /**
     * Retrieves a customer by their ID.
     *
     * @param customerId The ID of the customer to retrieve.
     * @return The customer with the specified ID.
     * @throws SQLException if a database access error occurs.
     */
    Customer getCustomerByCustomerId(UUID customerId) throws SQLException;

    /**
     * Retrieves all customers with a specific first name.
     *
     * @param firstName The first name of the customers to retrieve.
     * @return A list of customers with the specified first name.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getCustomerByFirstName(String firstName) throws SQLException;

    /**
     * Retrieves all customers with a specific middle name.
     *
     * @param middleName The middle name of the customers to retrieve.
     * @return A list of customers with the specified middle name.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getCustomerByMiddleName(String middleName) throws SQLException;

    /**
     * Retrieves all customers with a specific last name.
     *
     * @param lastName The last name of the customers to retrieve.
     * @return A list of customers with the specified last name.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getCustomerByLastName(String lastName) throws SQLException;

    /**
     * Retrieves all customers.
     *
     * @return A list of all customers.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getAllCustomers() throws SQLException;

    /**
     * Creates a new customer.
     *
     * @param firstName  The first name of the new customer.
     * @param lastName   The last name of the new customer.
     * @param middleName The middle name of the new customer.
     * @throws SQLException if a database access error occurs.
     */
    void create(String firstName, String lastName, String middleName) throws SQLException;

    /**
     * Updates an existing customer's information.
     *
     * @param customerId The ID of the customer to update.
     * @param firstName  The new first name for the customer.
     * @param lastName   The new last name for the customer.
     * @param middleName The new middle name for the customer.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID customerId, String firstName, String lastName, String middleName) throws SQLException;

    /**
     * Deletes a customer by their ID.
     *
     * @param customerId The ID of the customer to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID customerId) throws SQLException;
}
