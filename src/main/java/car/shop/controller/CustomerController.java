package car.shop.controller;

import car.shop.dto.CustomerDto;
import car.shop.entity.Customer;
import car.shop.mapper.CustomerMapper;
import car.shop.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customers", description = "Methods for working with customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get information about the customer by his ID",
            description = "Returns information about the customer by his ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customer's information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The customer with the given ID does not exist")})
    public CustomerDto getById(@Parameter(description = "Customer's ID") @PathVariable(name = "id") UUID id) {
        return customerService.getById(id);
    }

    @GetMapping(value = "/first-name/{firstName}")
    @Operation(summary = "Get information about customers by first name",
            description = "Returns information about customers by first name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The information about customers has been successfully provided")})
    public List<CustomerDto> getByFirstName(@Parameter(description = "Customer's first name")
                                            @PathVariable(name = "firstName") String firstName) {
        return customerService.getByFirstName(firstName);
    }

    @GetMapping(value = "/middle-name/{middleName}")
    @Operation(summary = "Get information about customers by middle name",
            description = "Returns information about customers by middle name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The information about customers has been successfully provided")})
    public List<CustomerDto> getByMiddleName(@Parameter(description = "Customer's middle name")
                                             @PathVariable(name = "middleName") String middleName) {
        return customerService.getByMiddleName(middleName);
    }

    @GetMapping(value = "/last-name/{lastName}")
    @Operation(summary = "Get information about customers by last name",
            description = "Returns information about customers by his last name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The information about customers has been successfully provided")})
    public List<CustomerDto> getByLastName(@Parameter(description = "Customer's last name")
                                           @PathVariable(name = "lastName") String lastName) {
        return customerService.getByLastName(lastName);
    }

    @GetMapping()
    @Operation(summary = "Get information about all customers", description = "Returns information about all customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customers' information has been successfully provided")})
    public List<CustomerDto> getAll() {
        return customerService.getAll();
    }

    @PostMapping()
    @Operation(summary = "Create a new customer", description = "Creates a new customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customer has been successfully created"),
            @ApiResponse(responseCode = "400", description = "The customer's information is invalid")})
    public void create(@RequestBody CustomerDto customerDto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customerService.create(customer);
    }

    @PutMapping()
    @Operation(summary = "Update an existing customer's information", description = "Updates an existing customer's information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customer's information has been successfully updated"),
            @ApiResponse(responseCode = "400", description = "New information about an existing customer is invalid"),
            @ApiResponse(responseCode = "404", description = "The customer with the given ID does not exist")})
    public void update(@RequestBody CustomerDto customerdto) {
        Customer customer = customerMapper.customerDtoToCustomer(customerdto);
        customerService.update(customer);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an existing customer", description = "Deletes an existing customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The customer has been successfully deleted"),
            @ApiResponse(responseCode = "404", description = "The customer with the given ID does not exist"),
            @ApiResponse(responseCode = "405", description = "It is forbidden to remove an already folded customer's entity")})
    public void delete(@Parameter(description = "Customer's ID") @PathVariable(name = "id") UUID id) {
        customerService.delete(id);
    }
}
