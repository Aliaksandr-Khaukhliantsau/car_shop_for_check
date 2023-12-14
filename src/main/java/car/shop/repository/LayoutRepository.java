package car.shop.repository;

import car.shop.entity.Layout;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LayoutRepository extends JpaRepository<Layout, UUID> {

    @Override
    @EntityGraph(attributePaths = {"completions"})
    Optional<Layout> findById(UUID id);

    @Override
    @EntityGraph(attributePaths = {"completions"})
    List<Layout> findAll();

    @EntityGraph(attributePaths = {"completions"})
    List<Layout> findByLayoutName(String layoutName);

    @EntityGraph(attributePaths = {"completions"})
//    List<Layout> findByCompletions_Id(UUID completionId);
    List<Layout> findByCompletionId(UUID completionId);
}