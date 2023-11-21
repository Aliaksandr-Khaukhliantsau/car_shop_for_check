package car.shop.mapper;

import car.shop.dto.SettingDto;
import car.shop.entity.Setting;
import org.mapstruct.Mapper;

/**
 * The SettingMapper interface provides methods for mapping between Setting and SettingDto objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface SettingMapper {

    /**
     * Maps a Setting entity to a SettingDto.
     *
     * @param setting the Setting entity to be mapped.
     * @return the mapped SettingDto.
     */
    SettingDto settingToSettingDto(Setting setting);

    /**
     * Maps a SettingDto to a Setting entity.
     *
     * @param settingDto the SettingDto to be mapped.
     * @return the mapped Setting entity.
     */
    Setting settingDtoToSetting(SettingDto settingDto);
}
