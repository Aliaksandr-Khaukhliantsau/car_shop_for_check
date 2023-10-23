package mapper;

import dto.LayoutDto;
import entity.Layout;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * The LayoutMapper interface provides methods for mapping between Layout and LayoutDto objects.
 * This mapper also uses the CompletionMapper for mapping between Completion and CompletionDto objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(uses = CompletionMapper.class)
public interface LayoutMapper {

    /**
     * The singleton instance of the mapper.
     */
    LayoutMapper LAYOUT_MAPPER = Mappers.getMapper(LayoutMapper.class);

    /**
     * Maps a Layout entity to a LayoutDto. Also maps the Completion entity to a CompletionDto.
     *
     * @param layout the Layout entity to be mapped.
     * @return the mapped LayoutDto.
     */
    @Mapping(source = "completion", target = "completion")
    LayoutDto layoutToLayoutDto(Layout layout);

    /**
     * Maps a LayoutDto to a Layout entity.
     *
     * @param layoutDto the LayoutDto to be mapped.
     * @return the mapped Layout entity.
     */
    Layout layoutDtoToLayout(LayoutDto layoutDto);
}
