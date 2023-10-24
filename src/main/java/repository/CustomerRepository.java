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
     * @param id the ID of the customer to retrieve.
     * @return the customer with the specified ID.
     * @throws SQLException if a database access error occurs.
     */
    Customer getById(UUID id) throws SQLException;

    /**
     * Retrieves all customers with a specific first name.
     *
     * @param firstName the first name of the customers to retrieve.
     * @return a list of customers with the specified first name.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getByFirstName(String firstName) throws SQLException;

    /**
     * Retrieves all customers with a specific middle name.
     *
     * @param middleName the middle name of the customers to retrieve.
     * @return a list of customers with the specified middle name.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getByMiddleName(String middleName) throws SQLException;

    /**
     * Retrieves all customers with a specific last name.
     *
     * @param lastName the last name of the customers to retrieve.
     * @return a list of customers with the specified last name.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getByLastName(String lastName) throws SQLException;

    /**
     * Retrieves all customers.
     *
     * @return a list of all customers.
     * @throws SQLException if a database access error occurs.
     */
    List<Customer> getAll() throws SQLException;

    /**
     * Creates a new customer.
     *
     * @param firstName  the first name of the new customer.
     * @param lastName   the last name of the new customer.
     * @param middleName the middle name of the new customer.
     * @throws SQLException if a database access error occurs.
     */
    void create(String firstName, String lastName, String middleName) throws SQLException;

    /**
     * Updates an existing customer's information.
     *
     * @param id         the ID of the customer to update.
     * @param firstName  the new first name for the customer.
     * @param lastName   the new last name for the customer.
     * @param middleName the new middle name for the customer.
     * @throws SQLException if a database access error occurs.
     */
    void update(UUID id, String firstName, String lastName, String middleName) throws SQLException;

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete.
     * @throws SQLException if a database access error occurs.
     */
    void delete(UUID id) throws SQLException;
}
