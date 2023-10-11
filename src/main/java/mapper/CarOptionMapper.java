package mapper;

import dto.CarOptionDto;
import entity.CarOption;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarOptionMapper {
    CarOptionMapper INSTANCE = Mappers.getMapper(CarOptionMapper.class);

    CarOptionDto carOptionToCarOptionDto(CarOption carOption);

    CarOption carOptionDtoToCarOption(CarOptionDto carOptionDTO);
}
