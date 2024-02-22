package car.shop.repository;

import car.shop.entity.Completion;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompletionRepository extends JpaRepository<Completion, UUID> {

    @Override
    @EntityGraph(attributePaths = {"settings"})
    Completion getById(UUID id);

    @Override
    @EntityGraph(attributePaths = {"settings"})
    List<Completion> findAll();

    @EntityGraph(attributePaths = {"settings"})
    Completion getByCompletionName(String completionName);
}
