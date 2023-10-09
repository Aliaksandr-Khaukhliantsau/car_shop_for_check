package repository.impl;

import entity.Customer;
import repository.CustomerRepository;
import util.PropertiesUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SQL_GET_CUSTOMER_BY_CUSTOMER_ID = "SELECT * FROM customers WHERE customer_id = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_CUSTOMER_BY_FIRST_NAME = "SELECT * FROM customers WHERE first_name = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_CUSTOMER_BY_MIDDLE_NAME = "SELECT * FROM customers WHERE middle_name = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_CUSTOMER_BY_LAST_NAME = "SELECT * FROM customers WHERE last_name = ? ORDER BY last_name ASC;";
    private static final String SQL_GET_ALL_CUSTOMERS = "SELECT * FROM customers ORDER BY last_name ASC;";
    private static final String SQL_CREATE_A_CUSTOMER = "INSERT INTO customers (first_name, middle_name, last_name) VALUES (?, ?, ?) RETURNING *;";
    private static final String SQL_UPDATE_A_CUSTOMER = "UPDATE customers SET first_name = ?, middle_name = ?, last_name = ? WHERE customer_id = ? RETURNING *;";
    private static final String SQL_DELETE_A_CUSTOMER = "DELETE FROM customers WHERE customer_id = ? RETURNING *;";
    private final Connection connection;

    public CustomerRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(PropertiesUtil.get("postgres_url"), PropertiesUtil.get("postgres_user"), PropertiesUtil.get("postgres_password"));
    }

    @Override
    public Customer getCustomerByCustomerId(UUID customerId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_CUSTOMER_ID)) {
            preparedStatement.setObject(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer = new Customer();

            while (resultSet.next()) {
                customer.setCustomerId(UUID.fromString(resultSet.getString("customer_id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));
            }
            return customer;
        }
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_FIRST_NAME)) {
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(UUID.fromString(resultSet.getString("customer_id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customers.add(customer);
            }
            return customers;
        }
    }

    @Override
    public List<Customer> getCustomerByMiddleName(String middleName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_MIDDLE_NAME)) {
            preparedStatement.setString(1, middleName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(UUID.fromString(resultSet.getString("customer_id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));

                customers.add(customer);
            }
            return customers;
        }
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_LAST_NAME)) {
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(UUID.fromString(resultSet.getString("customer_id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));

                customers.add(customer);
            }
            return customers;
        }
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CUSTOMERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(UUID.fromString(resultSet.getString("customer_id")));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setMiddleName(resultSet.getString("middle_name"));
                customer.setLastName(resultSet.getString("last_name"));

                customers.add(customer);
            }
            return customers;
        }
    }

    @Override
    public void create(String firstName, String middleName, String lastName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CUSTOMER)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CUSTOMER)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, middleName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setObject(4, customerId);
            preparedStatement.executeQuery();
        }
    }

    @Override
    public void delete(UUID customerId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CUSTOMER)) {
            preparedStatement.setObject(1, customerId);
            preparedStatement.executeQuery();
        }
    }

//    @Override
//    public ResultSet getCustomerByCustomerId(UUID customerId) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_CUSTOMER_ID);
//        preparedStatement.setObject(1, customerId);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        return resultSet;
//    }
//
//    @Override
//    public ResultSet getCustomerByFirstName(String firstName) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_FIRST_NAME);
//        preparedStatement.setString(1, firstName);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        return resultSet;
//    }
//
//    @Override
//    public ResultSet getCustomerByMiddleName(String middleName) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_MIDDLE_NAME);
//        preparedStatement.setString(1, middleName);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        return resultSet;
//    }
//
//    @Override
//    public ResultSet getCustomerByLastName(String lastName) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER_BY_LAST_NAME);
//        preparedStatement.setString(1, lastName);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        return resultSet;
//    }
//
//    @Override
//    public ResultSet getAllCustomers() throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_CUSTOMERS);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        return resultSet;
//    }
//
//    @Override
//    public void create(String firstName, String middleName, String lastName) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE_A_CUSTOMER);
//        preparedStatement.setString(1, firstName);
//        preparedStatement.setString(2, middleName);
//        preparedStatement.setString(3, lastName);
//        preparedStatement.executeQuery();
//        preparedStatement.close();
//    }
//
//    @Override
//    public void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_A_CUSTOMER);
//        preparedStatement.setString(1, firstName);
//        preparedStatement.setString(2, middleName);
//        preparedStatement.setString(3, lastName);
//        preparedStatement.setObject(4, customerId);
//        preparedStatement.executeQuery();
//        preparedStatement.close();
//    }
//
//    @Override
//    public void delete(UUID customerId) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_A_CUSTOMER);
//        preparedStatement.setObject(1, customerId);
//        preparedStatement.executeQuery();
//        preparedStatement.close();
//    }
}
