package car.shop.service;

import car.shop.dto.LayoutDto;
import car.shop.entity.Layout;

import java.util.List;
import java.util.UUID;

public interface LayoutService {

    LayoutDto getById(UUID id);

    List<LayoutDto> getByLayoutName(String layoutName);

    List<LayoutDto> getAll();

    void create(Layout layout);

    void update(Layout layout);

    void delete(UUID id);
}
