package car.shop.mapper;

import car.shop.dto.SettingDto;
import car.shop.entity.Setting;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SettingMapper {

    SettingDto settingToSettingDto(Setting setting);

    Setting settingDtoToSetting(SettingDto settingDto);
}
