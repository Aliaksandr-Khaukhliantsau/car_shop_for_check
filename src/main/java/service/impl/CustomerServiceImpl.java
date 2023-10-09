package service.impl;

import entity.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    public CustomerServiceImpl() throws SQLException {
    }

    @Override
    public Customer getCustomerByCustomerId(UUID customerId) throws SQLException {
        return customerRepository.getCustomerByCustomerId(customerId);
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) throws SQLException {
        return customerRepository.getCustomerByFirstName(firstName);
    }

    @Override
    public List<Customer> getCustomerByMiddleName(String middleName) throws SQLException {
        return customerRepository.getCustomerByMiddleName(middleName);
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) throws SQLException {
        return customerRepository.getCustomerByLastName(lastName);
    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        return customerRepository.getAllCustomers();
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

//    @Override
//    public Customer getCustomerByCustomerId(UUID customerId) throws SQLException {
//        ResultSet resultSet = customerRepository.getCustomerByCustomerId(customerId);
//        Customer customer = new Customer();
//
//        while (resultSet.next()) {
//            customer.setCustomerId(UUID.fromString(resultSet.getString("customerid")));
//            customer.setFirstName(resultSet.getString("firstname"));
//            customer.setMiddleName(resultSet.getString("middlename"));
//            customer.setLastName(resultSet.getString("lastname"));
//        }
//        return customer;
//    }
//
//    @Override
//    public List<Customer> getCustomerByFirstName(String firstName) throws SQLException {
//        ResultSet resultSet = customerRepository.getCustomerByFirstName(firstName);
//        List<Customer> customers = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Customer customer = new Customer();
//            customer.setCustomerId(UUID.fromString(resultSet.getString("customerid")));
//            customer.setFirstName(resultSet.getString("firstname"));
//            customer.setMiddleName(resultSet.getString("middlename"));
//            customer.setLastName(resultSet.getString("lastname"));
//
//            customers.add(customer);
//        }
//        return customers;
//    }
//
//    @Override
//    public List<Customer> getCustomerByMiddleName(String middleName) throws SQLException {
//        ResultSet resultSet = customerRepository.getCustomerByMiddleName(middleName);
//        List<Customer> customers = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Customer customer = new Customer();
//            customer.setCustomerId(UUID.fromString(resultSet.getString("customerid")));
//            customer.setFirstName(resultSet.getString("firstname"));
//            customer.setMiddleName(resultSet.getString("middlename"));
//            customer.setLastName(resultSet.getString("lastname"));
//
//            customers.add(customer);
//        }
//        return customers;
//    }
//
//    @Override
//    public List<Customer> getCustomerByLastName(String lastName) throws SQLException {
//        ResultSet resultSet = customerRepository.getCustomerByLastName(lastName);
//        List<Customer> customers = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Customer customer = new Customer();
//            customer.setCustomerId(UUID.fromString(resultSet.getString("customerid")));
//            customer.setFirstName(resultSet.getString("firstname"));
//            customer.setMiddleName(resultSet.getString("middlename"));
//            customer.setLastName(resultSet.getString("lastname"));
//
//            customers.add(customer);
//        }
//        return customers;
//    }
//
//    @Override
//    public List<Customer> getAllCustomers() throws SQLException {
//        ResultSet resultSet = customerRepository.getAllCustomers();
//        List<Customer> customers = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Customer customer = new Customer();
//            customer.setCustomerId(UUID.fromString(resultSet.getString("customerid")));
//            customer.setFirstName(resultSet.getString("firstname"));
//            customer.setMiddleName(resultSet.getString("middlename"));
//            customer.setLastName(resultSet.getString("lastname"));
//
//            customers.add(customer);
//        }
//        return customers;
//    }
//
//    @Override
//    public void create(String firstName, String middleName, String lastName) throws SQLException {
//        customerRepository.create(firstName, middleName, lastName);
//    }
//
//    @Override
//    public void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException {
//        customerRepository.update(customerId, firstName, middleName, lastName);
//    }
//
//    @Override
//    public void delete(UUID customerId) throws SQLException {
//        customerRepository.delete(customerId);
//    }
}
