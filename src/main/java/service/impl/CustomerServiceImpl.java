package service.impl;

import entity.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public CustomerServiceImpl() throws SQLException {
    }

    @Override
    public Customer getServiceById(String id) throws SQLException {
        ResultSet resultSet = customerRepository.getById(id);

        Customer customer = new Customer();
        customer.setId(resultSet.getString("id"));
        customer.setFirstName(resultSet.getString("firstname"));
        customer.setMiddleName(resultSet.getString("middlename"));
        customer.setLastName(resultSet.getString("lastname"));

        return customer;
    }

    @Override
    public List<Customer> getByFirstName(String firstName) throws SQLException {
        ResultSet resultSet = customerRepository.getByFirstName(firstName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getString("id"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> getByMiddleName(String middleName) throws SQLException {
        ResultSet resultSet = customerRepository.getByMiddleName(middleName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getString("id"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> getByLastName(String lastName) throws SQLException {
        ResultSet resultSet = customerRepository.getByLastName(lastName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getString("id"));
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
            customer.setId(resultSet.getString("id"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> create(String firstName, String middleName, String lastName) throws SQLException {
        ResultSet resultSet = customerRepository.create(firstName, middleName, lastName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getString("id"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> update(String id, String firstName, String middleName, String lastName) throws SQLException {
        ResultSet resultSet = customerRepository.update(id, firstName, middleName, lastName);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getString("id"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }

    @Override
    public List<Customer> delete(String id) throws SQLException {
        ResultSet resultSet = customerRepository.delete(id);
        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setId(resultSet.getString("id"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setLastName(resultSet.getString("lastname"));

            customerList.add(customer);
        }
        return customerList;
    }
}
