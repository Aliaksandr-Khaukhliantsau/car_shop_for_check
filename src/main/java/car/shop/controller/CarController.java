package car.shop.controller;

import car.shop.dto.CarDto;
import car.shop.entity.Car;
import car.shop.mapper.CarMapper;
import car.shop.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor
@Tag(name = "Cars", description = "Methods for working with cars")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get information about the car by it's ID",
            description = "Returns information about the car by it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The car information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The car with the given ID does not exist")
    }
    )
    public CarDto getById(@Parameter(description = "Car's ID") @PathVariable(name = "id") UUID id) {
        return carService.getById(id);
    }

    @GetMapping(value = "/vin/{vin}")
    @Operation(summary = "Get information about the car by it's VIN",
            description = "Returns information about the car by it's VIN")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The car information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The car with the given VIN does not exist")})
    public CarDto getByVin(@Parameter(description = "Car's VIN") @PathVariable(name = "vin") String vin) {
        return carService.getByVin(vin);
    }

    @PreAuthorize("hasAuthority('ROLE_USER') || hasAuthority('ROLE_ADMIN')")
    @GetMapping()
    @Operation(summary = "Get information about all cars", description = "Returns information about all cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The cars information has been successfully provided")})
    public List<CarDto> getAll() {
        return carService.getAll();
    }

    @PostMapping()
    @Operation(summary = "Create a new car", description = "Creates a new car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The car has been successfully created"),
            @ApiResponse(responseCode = "400", description = "The car information is invalid")})
    public void create(@RequestBody CarDto carDto) {
        Car car = carMapper.carDtoToCar(carDto);
        carService.create(car);
    }

    @PutMapping()
    @Operation(summary = "Update an existing car information", description = "Updates an existing car information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The car information has been successfully updated"),
            @ApiResponse(responseCode = "400", description = "New information about an existing car is invalid"),
            @ApiResponse(responseCode = "404", description = "The car with the given ID does not exist")})
    public void update(@RequestBody CarDto carDto) {
        Car car = carMapper.carDtoToCar(carDto);
        carService.update(car);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an existing car", description = "Deletes an existing car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The car has been successfully deleted"),
            @ApiResponse(responseCode = "404", description = "The car with the given ID does not exist"),
            @ApiResponse(responseCode = "405", description = "It is forbidden to remove an already folded car entity")})
    public void delete(@Parameter(description = "Car's ID") @PathVariable(name = "id") UUID id) {
        carService.delete(id);
    }
}
