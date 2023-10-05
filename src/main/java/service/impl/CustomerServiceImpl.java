package service.impl;

import entity.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public CustomerServiceImpl() throws SQLException {
    }

    @Override
    public Customer getCustomerByCustomerId(UUID customerId) throws SQLException {
        ResultSet resultSet = customerRepository.getCustomerByCustomerId(customerId);
        Customer customer = new Customer();

        while (resultSet.next()) {
            customer.setCustomerId(UUID.fromString(resultSet.getString("id")));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) throws SQLException {
        ResultSet resultSet = customerRepository.getCustomerByFirstName(firstName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(UUID.fromString(resultSet.getString("id")));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> getCustomerByMiddleName(String middleName) throws SQLException {
        ResultSet resultSet = customerRepository.getCustomerByMiddleName(middleName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(UUID.fromString(resultSet.getString("id")));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) throws SQLException {
        ResultSet resultSet = customerRepository.getCustomerByLastName(lastName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(UUID.fromString(resultSet.getString("id")));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet resultSet = customerRepository.getAllCustomers();
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(UUID.fromString(resultSet.getString("id")));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
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
