package service;

import dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerByCustomerId(UUID customerId) throws SQLException;

    List<CustomerDto> getCustomerByFirstName(String firstName) throws SQLException;

    List<CustomerDto> getCustomerByLastName(String lastName) throws SQLException;

    List<CustomerDto> getCustomerByMiddleName(String middleName) throws SQLException;

    List<CustomerDto> getAllCustomers() throws SQLException;

    void create(String firstName, String middleName, String lastName) throws SQLException;

    void update(UUID customerId, String firstName, String middleName, String lastName) throws SQLException;

    void delete(UUID customerId) throws SQLException;
}
