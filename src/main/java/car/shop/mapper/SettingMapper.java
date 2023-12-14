package car.shop.mapper;

import car.shop.dto.SettingDto;
import car.shop.entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SettingMapper {

    @Mapping(target = "completions", ignore = true)
    SettingDto settingToSettingDto(Setting setting);

    Setting settingDtoToSetting(SettingDto settingDto);
}
