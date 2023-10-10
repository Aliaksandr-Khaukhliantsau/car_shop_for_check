package mapper;

import dto.CarOptionDTO;
import entity.CarOption;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarOptionMapper {
    CarOptionMapper INSTANCE = Mappers.getMapper(CarOptionMapper.class);

    CarOptionDTO carOptionToCarOptionDTO(CarOption carOption);

    CarOption carOptionDTOToCarOption(CarOptionDTO carOptionDTO);
}
