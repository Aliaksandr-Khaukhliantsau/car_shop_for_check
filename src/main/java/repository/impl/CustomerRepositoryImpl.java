package repository.impl;

import entity.Customer;
import repository.CustomerRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The CustomerRepositoryImpl class implements the CustomerRepository interface.
 * This class provides methods to interact with the customers data in the database.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SQL_GET_BY_ID = "SELECT * FROM customers WHERE id = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_BY_FIRST_NAME = "SELECT * FROM customers WHERE first_name = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_BY_MIDDLE_NAME = "SELECT * FROM customers WHERE middle_name = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_BY_LAST_NAME = "SELECT * FROM customers WHERE last_name = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_ALL = "SELECT * FROM customers ORDER BY last_name ASC;";
    private static final String SQL_CREATE = "INSERT INTO customers (first_name, middle_name, last_name) VALUES (?, ?, ?) RETURNING *;";
    private static final String SQL_UPDATE = "UPDATE customers SET first_name = ?, middle_name = ?, last_name = ? WHERE id = ? RETURNING *;";
    private static final String SQL_DELETE = "DELETE FROM customers WHERE id = ? RETURNING *;";
    private static final int PARAMETER_INDEX_ONE = 1;
    private static final int PARAMETER_INDEX_TWO = 2;
    private static final int PARAMETER_INDEX_THREE = 3;
    private static final int PARAMETER_INDEX_FOUR = 4;
    private final Connection connection;

    {
        try {
            connection = DriverManager.getConnection(PropertiesUtil.get("postgres.url"), PropertiesUtil.get("postgres.user"), PropertiesUtil.get("postgres.password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method retrieves a customer by its ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return the customer corresponding to the provided ID.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public Customer getById(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_ID)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();

            while (resultSet.next()) {
                customer.setId(UUID.fromString(resultSet.getString("id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));
            }
            return customer;
        }
    }

    /**
     * This method retrieves all customers with a specific first name.
     *
     * @param firstName the first name of the customers to retrieve.
     * @return a list of customers with the specified first name.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Customer> getByFirstName(String firstName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_FIRST_NAME)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(UUID.fromString(resultSet.getString("id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customers.add(customer);
            }
            return customers;
        }
    }

    /**
     * This method retrieves all customers with a specific middle name.
     *
     * @param middleName the middle name of the customers to retrieve.
     * @return a list of customers with the specified middle name.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Customer> getByMiddleName(String middleName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_MIDDLE_NAME)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, middleName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(UUID.fromString(resultSet.getString("id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));

                customers.add(customer);
            }
            return customers;
        }
    }

    /**
     * This method retrieves all customers with a specific last name.
     *
     * @param lastName the last name of the customers to retrieve.
     * @return a list of customers with the specified last name.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Customer> getByLastName(String lastName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BY_LAST_NAME)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(UUID.fromString(resultSet.getString("id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));

                customers.add(customer);
            }
            return customers;
        }
    }

    /**
     * This method retrieves all customers.
     *
     * @return a list of all customers.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public List<Customer> getAll() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(UUID.fromString(resultSet.getString("id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));

                customers.add(customer);
            }
            return customers;
        }
    }

    /**
     * This method creates a new customer.
     *
     * @param firstName  the first name of the customer.
     * @param middleName the middle name of the customer.
     * @param lastName   the last name of the customer.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void create(String firstName, String middleName, String lastName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, firstName);
            preparedStatement.setString(PARAMETER_INDEX_TWO, middleName);
            preparedStatement.setString(PARAMETER_INDEX_THREE, lastName);
            preparedStatement.executeQuery();
        }
    }

    /**
     * This method updates an existing customer.
     *
     * @param id         the ID of the customer to update.
     * @param firstName  the new first name for the customer.
     * @param middleName the new middle name for the customer.
     * @param lastName   the new last name for the customer.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void update(UUID id, String firstName, String middleName, String lastName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE)) {
            preparedStatement.setString(PARAMETER_INDEX_ONE, firstName);
            preparedStatement.setString(PARAMETER_INDEX_TWO, middleName);
            preparedStatement.setString(PARAMETER_INDEX_THREE, lastName);
            preparedStatement.setObject(PARAMETER_INDEX_FOUR, id);
            preparedStatement.executeQuery();
        }
    }

    /**
     * This method deletes a customer.
     *
     * @param id the ID of the customer to delete.
     * @throws SQLException if a database access error occurs.
     */
    @Override
    public void delete(UUID id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
            preparedStatement.setObject(PARAMETER_INDEX_ONE, id);
            preparedStatement.executeQuery();
        }
    }
}
