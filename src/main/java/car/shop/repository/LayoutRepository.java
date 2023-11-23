package car.shop.repository;

import car.shop.entity.Layout;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

//    @Query("SELECT l FROM Layout l WHERE EXISTS (SELECT 1 FROM Completion c WHERE c.layout = l AND c.id = :completionId)")
//    List<Layout> findByCompletionId(@Param("completionId") UUID completionId);

    @EntityGraph(attributePaths = {"completions"})
    @Query("SELECT l FROM Layout l JOIN l.completions c WHERE c.id = :completionId")
    List<Layout> findByCompletionId(@Param("completionId") UUID completionId);
}
