package car.shop.service.impl;

import car.shop.dto.CustomerDto;
import car.shop.dto.MessageDto;
import car.shop.entity.Customer;
import car.shop.mapper.CustomerMapper;
import car.shop.repository.CustomerRepository;
import car.shop.service.CustomerService;
import car.shop.service.kafka.KafkaSenderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    KafkaSenderService kafkaSenderService;

    @Override
    @Transactional
    public CustomerDto getById(UUID id) {
        return customerMapper.customerToCustomerDto(customerRepository.getById(id));
    }

    @Override
    @Transactional
    public List<CustomerDto> getByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName).stream()
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }

    @Override
    @Transactional
    public List<CustomerDto> getByMiddleName(String middleName) {
        return customerRepository.findByMiddleName(middleName).stream()
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }

    @Override
    @Transactional
    public List<CustomerDto> getByLastName(String lastName) {
        return customerRepository.findByLastName(lastName).stream()
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }

    @Override
    @Transactional
    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream()
                .map(customerMapper::customerToCustomerDto)
                .toList();
    }

    @Override
    @Transactional
    public void create(Customer customer) {
        customerRepository.save(customer);
        MessageDto messageDto = new MessageDto(LocalDateTime.now(), "Customer created: " + customer.getId());
        kafkaSenderService.sendMessage("customer-topic", messageDto);
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        customerRepository.deleteById(id);
    }
}
