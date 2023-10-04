package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public interface CustomerRepository {
    ResultSet getCustomerByCustomerId(UUID customerId) throws SQLException;

    ResultSet getCustomerByFirstName(String firstName) throws SQLException;

    ResultSet getCustomerByMiddleName(String middleName) throws SQLException;

    ResultSet getCustomerByLastName(String lastName) throws SQLException;

    ResultSet getAllCustomers() throws SQLException;

//    ResultSet create(String firstName, String lastName, String middleName) throws SQLException;
//
//    ResultSet update(UUID customerId, String firstName, String lastName, String middleName) throws SQLException;
//
//    ResultSet delete(UUID customerId) throws SQLException;

    void create(String firstName, String lastName, String middleName) throws SQLException;

    void update(UUID customerId, String firstName, String lastName, String middleName) throws SQLException;

    void delete(UUID customerId) throws SQLException;
}
