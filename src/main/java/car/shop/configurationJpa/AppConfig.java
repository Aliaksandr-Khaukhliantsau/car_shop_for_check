package car.shop.configurationJpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import car.shop.mapperJpa.CustomerMapper;
import car.shop.serviceJpa.CustomerService;
import car.shop.serviceJpa.impl.CustomerServiceImpl;
import car.shop.repositoryJpa.CustomerRepository;

@Configuration
public class AppConfig {

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        return new CustomerServiceImpl(customerRepository, customerMapper);
    }
}
