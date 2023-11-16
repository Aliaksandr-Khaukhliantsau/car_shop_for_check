//package car.shop.controllerJpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import car.shop.dtoJpa.CustomerDto;
//import car.shop.serviceJpa.CustomerService;
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/customers")
//public class CustomerController {
//
//    private final CustomerService customerService;
//
//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    @GetMapping("/firstName/{firstName}")
//    public List<CustomerDto> findByFirstName(@PathVariable String firstName) {
//        return customerService.getByFirstName(firstName);
//    }
//
//    @GetMapping("/middleName/{middleName}")
//    public List<CustomerDto> findByMiddleName(@PathVariable String middleName) {
//        return customerService.getByMiddleName(middleName);
//    }
//
//    @GetMapping("/lastName/{lastName}")
//    public List<CustomerDto> findByLastName(@PathVariable String lastName) {
//        return customerService.getByLastName(lastName);
//    }
//
//    @GetMapping("/{id}")
//    public CustomerDto findById(@PathVariable UUID id) {
//        return customerService.getById(id);
//    }
//
//    @PostMapping
//    public void save(@RequestBody CustomerDto customerDto) {
//        customerService.create(customerDto.getFirstName(), customerDto.getMiddleName(), customerDto.getLastName());
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable UUID id, @RequestBody CustomerDto customerDto) {
//        customerService.update(id, customerDto.getFirstName(), customerDto.getMiddleName(), customerDto.getLastName());
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable UUID id) {
//        customerService.delete(id);
//    }
//}
