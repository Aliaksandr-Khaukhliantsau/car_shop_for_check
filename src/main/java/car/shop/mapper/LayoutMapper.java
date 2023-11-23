package car.shop.mapper;

import car.shop.dto.LayoutDto;
import car.shop.entity.Layout;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = CompletionMapper.class)
public interface LayoutMapper {

    @Mapping(source = "completions", target = "completions")
    LayoutDto layoutToLayoutDto(Layout layout);

    Layout layoutDtoToLayout(LayoutDto layoutDto);
}
