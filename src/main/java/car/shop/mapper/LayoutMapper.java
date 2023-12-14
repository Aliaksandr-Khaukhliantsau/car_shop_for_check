package car.shop.mapper;

import car.shop.dto.LayoutDto;
import car.shop.entity.Layout;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CompletionMapper.class)
public interface LayoutMapper {

    LayoutDto layoutToLayoutDto(Layout layout);

    Layout layoutDtoToLayout(LayoutDto layoutDto);
}
