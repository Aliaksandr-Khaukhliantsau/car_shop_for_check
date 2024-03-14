package car.shop.controller;

import car.shop.dto.LayoutDto;
import car.shop.entity.Layout;
import car.shop.mapper.LayoutMapper;
import car.shop.service.LayoutService;
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
@RequestMapping("api/v1/layouts")
@RequiredArgsConstructor
@Tag(name = "Layouts", description = "Methods for working with layouts")
public class LayoutController {
    private final LayoutService layoutService;
    private final LayoutMapper layoutMapper;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get information about the layout by it's ID",
            description = "Returns information about the layout by it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The layout information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The layout with the given ID does not exist")})
    public LayoutDto getById(@Parameter(description = "Layout's ID") @PathVariable(name = "id") UUID id) {
        return layoutService.getById(id);
    }

    @GetMapping(value = "/layout-name/{layoutName}")
    @Operation(summary = "Get information about layouts by layout name",
            description = "Returns information about layouts by layout name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The information about layouts has been successfully provided")})
    public List<LayoutDto> getByLayoutName(@Parameter(description = "Layout name")
                                           @PathVariable(name = "layoutName") String layoutName) {
        return layoutService.getByLayoutName(layoutName);
    }

    @GetMapping()
    @Operation(summary = "Get information about all layouts", description = "Returns information about all layouts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The layouts information has been successfully provided")})
    public List<LayoutDto> getAll() {
        return layoutService.getAll();
    }

    @PostMapping()
    @Operation(summary = "Create a new layout", description = "Creates a new layout")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The layout has been successfully created"),
            @ApiResponse(responseCode = "400", description = "The layout information is invalid")})
    public void create(@RequestBody LayoutDto layoutDto) {
        Layout layout = layoutMapper.layoutDtoToLayout(layoutDto);
        layoutService.create(layout);
    }

    @PutMapping()
    @Operation(summary = "Update an existing layout information", description = "Updates an existing layout information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The layout information has been successfully updated"),
            @ApiResponse(responseCode = "400", description = "New information about an existing layout is invalid"),
            @ApiResponse(responseCode = "404", description = "The layout with the given ID does not exist")})
    public void update(@RequestBody LayoutDto layoutDto) {
        Layout layout = layoutMapper.layoutDtoToLayout(layoutDto);
        layoutService.update(layout);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an existing layout", description = "Deletes an existing layout")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The layout has been successfully deleted"),
            @ApiResponse(responseCode = "404", description = "The layout with the given ID does not exist"),
            @ApiResponse(responseCode = "405", description = "It is forbidden to remove an already folded layout entity")})
    public void delete(@Parameter(description = "Layout ID") @PathVariable(name = "id") UUID id) {
        layoutService.delete(id);
    }
}
