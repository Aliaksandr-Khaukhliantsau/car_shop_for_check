package car.shop.repository;

import car.shop.entity.Setting;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SettingRepository extends JpaRepository<Setting, UUID> {

    @Override
    @EntityGraph(attributePaths = {"completions"})
    Setting getById(UUID id);

    @Override
    @EntityGraph(attributePaths = {"completions"})
    List<Setting> findAll();

    @EntityGraph(attributePaths = {"completions"})
    Setting getBySettingName(String settingName);
}
