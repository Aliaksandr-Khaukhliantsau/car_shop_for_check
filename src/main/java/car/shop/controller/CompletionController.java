package car.shop.controller;

import car.shop.dto.CompletionDto;
import car.shop.entity.Completion;
import car.shop.mapper.CompletionMapper;
import car.shop.service.CompletionService;
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
@RequestMapping("api/v1/completions")
@RequiredArgsConstructor
@Tag(name = "Completions", description = "Methods for working with completions")
public class CompletionController {
    private final CompletionService completionService;
    private final CompletionMapper completionMapper;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get information about the completion by it's ID",
            description = "Returns information about the completion by it's ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The completion information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The completion with the given ID does not exist")})
    public CompletionDto getById(@Parameter(description = "Completion's ID") @PathVariable(name = "id") UUID id) {
        return completionService.getById(id);
    }

    @GetMapping(value = "/completion-name/{completionName}")
    @Operation(summary = "Get information about the completion by it's completion name",
            description = "Returns information about the completion by it's completion name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The completion information has been successfully provided"),
            @ApiResponse(responseCode = "404", description = "The completion with the given completion name does not exist")})
    public CompletionDto getByCompletionName(@Parameter(description = "Completion name")
                                             @PathVariable(name = "completionName") String completionName) {
        return completionService.getByCompletionName(completionName);
    }

    @GetMapping()
    @Operation(summary = "Get information about all completions", description = "Returns information about all completions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The completions information has been successfully provided")})
    public List<CompletionDto> getAll() {
        return completionService.getAll();
    }

    @PutMapping(value = "/setting-to-completion/{completionId}/{settingId}")
    @Operation(summary = "Add a setting to a completion", description = "Adds a setting to a completion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The setting has been successfully added to the completion"),
            @ApiResponse(responseCode = "404", description = "This completion or setting was not found"),
            @ApiResponse(responseCode = "405", description = "It is forbidden to add a previously added setting")})
    public void addSetting(@Parameter(description = "Completion ID") @PathVariable(name = "completionId") UUID completionId,
                           @Parameter(description = "Setting ID") @PathVariable(name = "settingId") UUID settingId) {
        completionService.addSetting(completionId, settingId);
    }

    @PutMapping(value = "/setting-from-completion/{completionId}/{settingId}")
    @Operation(summary = "Remove a setting from a completion", description = "Removes a setting from a completion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The setting has been successfully removed from the completion"),
            @ApiResponse(responseCode = "404", description = "This completion or setting was not found")})
    public void removeSetting(@Parameter(description = "Completion ID") @PathVariable(name = "completionId") UUID completionId,
                              @Parameter(description = "Setting ID") @PathVariable(name = "settingId") UUID settingId) {
        completionService.removeSetting(completionId, settingId);
    }

    @PostMapping()
    @Operation(summary = "Create a new completion", description = "Creates a new completion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The completion has been successfully created"),
            @ApiResponse(responseCode = "400", description = "The completion information is invalid")})
    public void create(@RequestBody CompletionDto completionDto) {
        Completion completion = completionMapper.completionDtoToCompletion(completionDto);
        completionService.create(completion);
    }

    @PutMapping()
    @Operation(summary = "Update an existing completion information", description = "Updates an existing completion information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The completion information has been successfully updated"),
            @ApiResponse(responseCode = "400", description = "New information about an existing completion is invalid"),
            @ApiResponse(responseCode = "404", description = "The completion with the given ID does not exist")})
    public void update(@RequestBody CompletionDto completionDto) {
        Completion completion = completionMapper.completionDtoToCompletion(completionDto);
        completionService.update(completion);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete an existing completion", description = "Deletes an existing completion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The completion has been successfully deleted"),
            @ApiResponse(responseCode = "404", description = "The completion with the given ID does not exist"),
            @ApiResponse(responseCode = "405", description = "It is forbidden to remove an already folded completion entity")})
    public void delete(@Parameter(description = "Completion ID") @PathVariable(name = "id") UUID id) {
        completionService.delete(id);
    }
}
