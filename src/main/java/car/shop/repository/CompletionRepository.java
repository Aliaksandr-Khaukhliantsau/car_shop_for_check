package car.shop.repository;

import car.shop.entity.Completion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The CompletionRepository interface provides methods for interacting with completion data.
 *
 * @author Aliaksandr Khaukhliantsau
 * @version 1.0
 */
@Repository
public interface CompletionRepository extends JpaRepository<Completion, UUID> {

    @Override
    @EntityGraph(attributePaths = {"settings"})
    Optional<Completion> findById(UUID id);

    @Override
    @EntityGraph(attributePaths = {"settings"})
    List<Completion> findAll();

    @EntityGraph(attributePaths = {"settings"})
    Optional<Completion> findByCompletionName(String completionName);
}
