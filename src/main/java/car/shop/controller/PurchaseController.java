package car.shop.controller;

import car.shop.dto.PurchaseDto;
import car.shop.entity.Purchase;
import car.shop.mapper.PurchaseMapper;
import car.shop.service.PurchaseService;
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
@RequestMapping("api/v1/purchases")
@RequiredArgsConstructor
@Tag(name = "Purchases", description = "Methods for working with purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final PurchaseMapper purchaseMapper;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get information about the purchase by it's ID",
            description = "Returns information about the purchase by it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The purchase information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The purchase with the given ID does not exist")})
    public PurchaseDto getById(@Parameter(description = "Purchase ID") @PathVariable(name = "id") UUID id) {
        return purchaseService.getById(id);

    }

    @GetMapping(value = "/purchase-number/{purchaseNumber}")
    @Operation(summary = "Get information about the car by it's purchase number",
            description = "Returns information about the car by it's purchase number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The purchase information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The purchase with the given purchase number does not exist")})
    public PurchaseDto getByPurchaseNumber(@Parameter(description = "Purchase number")
                                           @PathVariable(name = "purchaseNumber") int purchaseNumber) {
        return purchaseService.getByPurchaseNumber(purchaseNumber);
    }

    @GetMapping(value = "/customer-id/{customerId}")
    @Operation(summary = "Get information about purchases by customer's ID",
            description = "Returns information about purchases by customer's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The information about purchases has been successfully provided")})
    public List<PurchaseDto> getByCustomerId(@Parameter(description = "Customer's number")
                                             @PathVariable(name = "customerId") UUID customerId) {
        return purchaseService.getByCustomerId(customerId);
    }

    @GetMapping(value = "/car-id/{carId}")
    @Operation(summary = "Get information about purchases by car ID",
            description = "Returns information about purchases by car ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The information about purchases has been successfully provided")})
    public List<PurchaseDto> getByCarId(@Parameter(description = "Car ID") @PathVariable(name = "carId") UUID carId) {
        return purchaseService.getByCarId(carId);
    }

    @GetMapping()
    @Operation(summary = "Get information about all purchases", description = "Returns information about all purchases")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The purchases information has been successfully provided")})
    public List<PurchaseDto> getAll() {
        return purchaseService.getAll();
    }

    @PostMapping()
    @Operation(summary = "Create a new purchase", description = "Creates a new purchase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The purchase has been successfully created"),
            @ApiResponse(responseCode = "400", description = "The purchase information is invalid")})
    public void create(@RequestBody PurchaseDto purchaseDto) {
        Purchase purchase = purchaseMapper.purchaseDtoToPurchase(purchaseDto);
        purchaseService.create(purchase);
    }

    @PutMapping()
    @Operation(summary = "Update an existing purchase information", description = "Updates an existing purchase information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The purchase information has been successfully updated"),
            @ApiResponse(responseCode = "400", description = "New information about an existing purchase is invalid"),
            @ApiResponse(responseCode = "404", description = "The purchase with the given ID does not exist")})
    public void update(@RequestBody PurchaseDto purchasedDto) {
        Purchase purchase = purchaseMapper.purchaseDtoToPurchase(purchasedDto);
        purchaseService.update(purchase);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an existing purchase", description = "Deletes an existing purchase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The purchase has been successfully deleted"),
            @ApiResponse(responseCode = "404", description = "The purchase with the given ID does not exist"),
            @ApiResponse(responseCode = "405", description = "It is forbidden to remove an already folded purchase entity")})
    public void delete(@Parameter(description = "Purchase ID") @PathVariable(name = "id") UUID id) {
        purchaseService.delete(id);
    }
}
