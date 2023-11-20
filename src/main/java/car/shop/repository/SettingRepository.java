package car.shop.repository;

import car.shop.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * The SettingRepository interface provides methods for interacting with car setting data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Repository
public interface SettingRepository extends JpaRepository<Setting, UUID> {
    Optional<Setting> findById(UUID id);

    Optional<Setting> findBySettingName(String settingName);
//    List<Setting> findByCompletionId(UUID completionId);
}
