package repository.impl;

import repository.CustomerRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.UUID;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SQL_GET_ALL_CUSTOMERS = "SELECT * FROM customers ORDER BY lastname ASC;";
    private final Connection connection;

    public CustomerRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public ResultSet getCustomerByCustomerId(UUID customerId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_CUSTOMER_BY_CUSTOMER_ID = "SELECT * FROM customers WHERE id = " + "'" + customerId + "'" + " ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_GET_CUSTOMER_BY_CUSTOMER_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCustomerByFirstName(String firstName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_CUSTOMER_BY_FIRST_NAME = "SELECT * FROM customers WHERE firstname = " + "'" + firstName + "'" + " ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_GET_CUSTOMER_BY_FIRST_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCustomerByMiddleName(String middleName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_CUSTOMER_BY_MIDDLE_NAME = "SELECT * FROM customers WHERE middlename = '" + middleName + "' ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_GET_CUSTOMER_BY_MIDDLE_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCustomerByLastName(String lastName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_GET_CUSTOMER_BY_LAST_NAME = "SELECT * FROM customers WHERE lastname = " + "'" + lastName + "'" + " ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_GET_CUSTOMER_BY_LAST_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCustomers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_GET_ALL_CUSTOMERS);
//        statement.close();
        return resultSet;
    }

    @Override
    public void create(String firstName, String middleName, String lastName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CREATE_A_CUSTOMER = "INSERT INTO customers (firstname, middlename, lastname) VALUES ('" + firstName + "', '" + middleName + "', '" + lastName + "') RETURNING *;";
        statement.executeQuery(SQL_CREATE_A_CUSTOMER);
        statement.close();
    }

    @Override
    public void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_UPDATE_A_CUSTOMER = "UPDATE customers SET firstname = '" + firstName + "', middlename = '" + middleName + "', lastname = '" + lastName + "' WHERE id = '" + customerId + "' RETURNING *;";
        statement.executeQuery(SQL_UPDATE_A_CUSTOMER);
        statement.close();
    }

    @Override
    public void delete(UUID customerId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_CUSTOMER = "DELETE FROM customers WHERE id = '" + customerId + "' RETURNING *;";
        statement.executeQuery(SQL_DELETE_A_CUSTOMER);
        statement.close();
    }
}
