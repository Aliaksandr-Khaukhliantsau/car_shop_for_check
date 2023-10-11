package mapper;

import dto.CarModelDto;
import entity.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CompletionMapper.class)
public interface CarModelMapper {
    CarModelMapper INSTANCE = Mappers.getMapper(CarModelMapper.class);

    @Mapping(source = "completion", target = "completion")
    CarModelDto carModelToCarModelDto(CarModel carModel);

//    CompletionDTO map(Completion completion);

    CarModel carModelDtoToCarModel(CarModelDto carModelDTO);

//    Completion mapDto(CompletionDTO completion);
}
