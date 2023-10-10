package mapper;

import dto.CarModelDTO;
import entity.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CompletionMapper.class)
public interface CarModelMapper {
    CarModelMapper INSTANCE = Mappers.getMapper(CarModelMapper.class);

    @Mapping(source = "completion", target = "completion")
    CarModelDTO carModelToCarModelDTO(CarModel carModel);

//    CompletionDTO map(Completion completion);

    CarModel carModelDTOToCarModel(CarModelDTO carModelDTO);

//    Completion mapDto(CompletionDTO completion);
}
