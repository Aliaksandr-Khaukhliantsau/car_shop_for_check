package mapper;

import dto.CarOptionDTO;
import dto.CompletionDTO;
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
    CompletionDTO completionToCompletionDTO(Completion completion);

    List<CarOptionDTO> map(List<CarOption> carOptions);

    Completion completionDTOToCompletion(CompletionDTO completionDTO);

    List<CarOption> mapDto(List<CarOptionDTO> carOptions);
}
