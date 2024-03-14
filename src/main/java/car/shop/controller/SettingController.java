package car.shop.controller;

import car.shop.dto.SettingDto;
import car.shop.entity.Setting;
import car.shop.mapper.SettingMapper;
import car.shop.service.SettingService;
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
@RequestMapping("api/v1/settings")
@RequiredArgsConstructor
@Tag(name = "Settings", description = "Methods for working with settings")
public class SettingController {
    private final SettingService settingService;
    private final SettingMapper settingMapper;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get information about the setting by it's ID",
            description = "Returns information about the setting by it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The setting information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The setting with the given ID does not exist")})
    public SettingDto getById(@Parameter(description = "Setting ID") @PathVariable(name = "id") UUID id) {
        return settingService.getById(id);
    }

    @GetMapping(value = "/setting-name/{settingName}")
    @Operation(summary = "Get information about the setting by setting name",
            description = "Returns information about the setting by setting name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The setting's information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The setting with the given setting name does not exist")})
    public SettingDto getBySettingName(@Parameter(description = "Setting name")
                                       @PathVariable(name = "settingName") String settingName) {
        return settingService.getBySettingName(settingName);
    }

    @GetMapping()
    @Operation(summary = "Get information about all settings", description = "Returns information about all settings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The settings information has been successfully provided")})
    public List<SettingDto> getAll() {
        return settingService.getAll();
    }

    @PostMapping()
    @Operation(summary = "Create a new setting", description = "Creates a new setting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The setting has been successfully created"),
            @ApiResponse(responseCode = "400", description = "The setting information is invalid")})
    public void create(@RequestBody SettingDto settingDto) {
        Setting setting = settingMapper.settingDtoToSetting(settingDto);
        settingService.create(setting);
    }

    @PutMapping()
    @Operation(summary = "Update an existing setting information", description = "Updates an existing setting information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The setting information has been successfully updated"),
            @ApiResponse(responseCode = "400", description = "New information about an existing setting is invalid"),
            @ApiResponse(responseCode = "404", description = "The setting with the given ID does not exist")})
    public void update(@RequestBody SettingDto settingDto) {
        Setting setting = settingMapper.settingDtoToSetting(settingDto);
        settingService.update(setting);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an existing setting", description = "Deletes an existing setting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The setting has been successfully deleted"),
            @ApiResponse(responseCode = "404", description = "The setting with the given ID does not exist"),
            @ApiResponse(responseCode = "405", description = "It is forbidden to remove an already folded setting entity")})
    public void delete(@Parameter(description = "Setting ID") @PathVariable(name = "id") UUID id) {
        settingService.delete(id);
    }
}
