package car.shop.mapper;

import car.shop.dto.CompletionDto;
import car.shop.dto.SettingDto;
import car.shop.entity.Completion;
import car.shop.entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = SettingMapper.class)
public interface CompletionMapper {

    @Mapping(target = "layout", ignore = true)
    CompletionDto completionToCompletionDto(Completion completion);

    List<SettingDto> map(List<Setting> settings);

    Completion completionDtoToCompletion(CompletionDto completionDto);

    List<Setting> mapDto(List<SettingDto> settings);
}
