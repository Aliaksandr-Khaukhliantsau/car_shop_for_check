package EntityToDTO;

import dto.CustomerDTO;
import entity.Customer;
import mapper.CustomerMapper;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.UUID;

public class CustomerToCustomerDTO {
    public static void main(String[] args) throws SQLException {
        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Извлечение данных из таблицы Customers по customer_id для создания экземпляра класса Customer
        System.out.println("Enter the customer's id:");
        UUID customerId = UUID.fromString(scanner.nextLine());

        Customer customer = customerService.getCustomerByCustomerId(customerId);

        // Вывод customer на консоль через .toString
        System.out.println(customer);
        System.out.println();

        // Преобразование в CustomerDTO
        CustomerDTO customerDTO = CustomerMapper.INSTANCE.customerToCustomerDTO(customer);

        // Вывод customerDTO на консоль
        System.out.println(customerDTO.getCustomerId());
        System.out.println(customerDTO.getFirstName());
        System.out.println(customerDTO.getMiddleName());
        System.out.println(customerDTO.getLastName());
        System.out.println();

        // Вывод customerDTO на консоль через .toString
        System.out.println(customerDTO);
    }
}
