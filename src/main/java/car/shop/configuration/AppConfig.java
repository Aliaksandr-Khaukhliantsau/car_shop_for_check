//package car.shop.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import car.shop.mapper.CustomerMapper;
//import car.shop.service.CustomerService;
//import car.shop.service.impl.CustomerServiceImpl;
//import car.shop.repository.CustomerRepository;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public CustomerService customerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
//        return new CustomerServiceImpl(customerRepository, customerMapper);
//    }
//}
