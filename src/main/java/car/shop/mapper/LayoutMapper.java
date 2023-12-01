package car.shop.mapper;

import car.shop.dto.LayoutDto;
import car.shop.entity.Layout;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CompletionMapper.class)
public interface LayoutMapper {

    @Mapping(source = "completions", target = "completions")
    @Mapping(source = "completionId", target = "completionId")
    LayoutDto layoutToLayoutDto(Layout layout);

    @Mapping(source = "completions", target = "completions")
    @Mapping(source = "completionId", target = "completionId")
    Layout layoutDtoToLayout(LayoutDto layoutDto);
}
