package service;

import entity.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CustomerService {
    Customer getCustomerByCustomerId(UUID customerId) throws SQLException;

    List<Customer> getCustomerByFirstName(String firstName) throws SQLException;

    List<Customer> getCustomerByLastName(String lastName) throws SQLException;

    List<Customer> getCustomerByMiddleName(String middleName) throws SQLException;

    List<Customer> getAllCustomers() throws SQLException;

//    List<Customer> create(String firstName, String middleName, String lastName) throws SQLException;
//
//    List<Customer> update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException;
//
//    List<Customer> delete(UUID customerId) throws SQLException;

    void create(String firstName, String middleName, String lastName) throws SQLException;

    void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException;

    void delete(UUID customerId) throws SQLException;
}
