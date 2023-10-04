package repository.impl;

import repository.CustomerRepository;

import java.sql.*;
import java.util.UUID;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_CUSTOMERS = "SELECT * FROM customers ORDER BY lastname ASC;";
    private final Connection connection;

    public CustomerRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    @Override
    public ResultSet getCustomerByCustomerId(UUID customerId) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_ID = "SELECT * FROM customers WHERE id = " + "'" + customerId + "'" + " ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_ID);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCustomerByFirstName(String firstName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_FIRST_NAME = "SELECT * FROM customers WHERE firstname = " + "'" + firstName + "'" + " ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_FIRST_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCustomerByMiddleName(String middleName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_MIDDLE_NAME = "SELECT * FROM customers WHERE middlename = '" + middleName + "' ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_MIDDLE_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getCustomerByLastName(String lastName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_LAST_NAME = "SELECT * FROM customers WHERE lastname = " + "'" + lastName + "'" + " ORDER BY lastname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_LAST_NAME);
//        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCustomers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_ALL_CUSTOMERS);
//        statement.close();
        return resultSet;
    }

//    @Override
//    public ResultSet create(String firstName, String middleName, String lastName) throws SQLException {
//        Statement statement = connection.createStatement();
//        String SQL_ADD_A_NEW_CUSTOMER = "INSERT INTO customers (firstname, middlename, lastname) VALUES ('" + firstName + "', '" + middleName + "', '" + lastName + "') RETURNING *;";
//        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_CUSTOMER);
////        statement.close();
//        return resultSet;
//    }
//
//    @Override
//    public ResultSet update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
//        Statement statement = connection.createStatement();
//        String SQL_CHANGE_A_CUSTOMER = "UPDATE customers SET firstname = '" + firstName + "', middlename = '" + middleName + "', lastname = '" + lastName + "' WHERE id = '" + customerId + "' RETURNING *;";
//        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_A_CUSTOMER);
////        statement.close();
//        return resultSet;
//    }
//
//    @Override
//    public ResultSet delete(UUID customerId) throws SQLException {
//        Statement statement = connection.createStatement();
//        String SQL_DELETE_A_CUSTOMER = "DELETE FROM customers WHERE id = '" + customerId + "' RETURNING *;";
//        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_CUSTOMER);
////        statement.close();
//        return resultSet;
//    }

    @Override
    public void create(String firstName, String middleName, String lastName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_CUSTOMER = "INSERT INTO customers (firstname, middlename, lastname) VALUES ('" + firstName + "', '" + middleName + "', '" + lastName + "') RETURNING *;";
        statement.executeQuery(SQL_ADD_A_NEW_CUSTOMER);
        statement.close();
    }

    @Override
    public void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_CUSTOMER = "UPDATE customers SET firstname = '" + firstName + "', middlename = '" + middleName + "', lastname = '" + lastName + "' WHERE id = '" + customerId + "' RETURNING *;";
        statement.executeQuery(SQL_CHANGE_A_CUSTOMER);
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
