//package entityToDto;
//
//import dto.CustomerDto;
//import entity.Customer;
//import mapper.CustomerMapper;
//import service.CustomerService;
//import service.impl.CustomerServiceImpl;
//
//import java.sql.SQLException;
//import java.util.Scanner;
//import java.util.UUID;
//
//public class CustomerToCustomerDto {
//    public static void main(String[] args) throws SQLException {
//        CustomerService customerService = new CustomerServiceImpl();
//        Scanner scanner = new Scanner(System.in);
//
//        // Извлечение данных из таблицы Customers по customer_id для создания экземпляра класса Customer
//        System.out.println("Enter the customer's id:");
//        UUID customerId = UUID.fromString(scanner.nextLine());
//
//        Customer customer = customerService.getCustomerByCustomerId(customerId);
//
//        // Вывод customer на консоль через .toString
//        System.out.println(customer);
//        System.out.println();
//
//        // Преобразование в CustomerDTO
//        CustomerDto customerDto = CustomerMapper.INSTANCE.customerToCustomerDto(customer);
//
//        // Вывод customerDto на консоль
//        System.out.println(customerDto.getCustomerId());
//        System.out.println(customerDto.getFirstName());
//        System.out.println(customerDto.getMiddleName());
//        System.out.println(customerDto.getLastName());
//        System.out.println();
//
//        // Вывод customerDto на консоль через .toString
//        System.out.println(customerDto);
//    }
//}
