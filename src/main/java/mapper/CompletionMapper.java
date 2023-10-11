package mapper;

import dto.CarOptionDto;
import dto.CompletionDto;
import entity.CarOption;
import entity.Completion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = CarOptionMapper.class)
public interface CompletionMapper {
    CompletionMapper INSTANCE = Mappers.getMapper(CompletionMapper.class);

    @Mapping(source = "carOptions", target = "carOptions")
    CompletionDto completionToCompletionDTO(Completion completion);

    List<CarOptionDto> map(List<CarOption> carOptions);

    Completion completionDTOToCompletion(CompletionDto completionDTO);

    List<CarOption> mapDto(List<CarOptionDto> carOptions);
}
