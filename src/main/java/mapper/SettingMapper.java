package mapper;

import dto.SettingDto;
import entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * The SettingMapper interface provides methods for mapping between Setting and SettingDto objects.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Mapper
public interface SettingMapper {

    /**
     * The singleton instance of the mapper.
     */
    SettingMapper SETTING_MAPPER = Mappers.getMapper(SettingMapper.class);

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
