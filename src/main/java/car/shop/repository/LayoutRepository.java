//package car.shop.repository;
//
//import car.shop.entity.Layout;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//public interface LayoutRepository extends JpaRepository<Layout, UUID> {
//
//    @Override
//    @EntityGraph(attributePaths = {"completions"})
//    Optional<Layout> findById(UUID id);
//
//    @Override
//    @EntityGraph(attributePaths = {"completions"})
//    List<Layout> findAll();
//
//    @EntityGraph(attributePaths = {"completions"})
//    List<Layout> findByLayoutName(String layoutName);
//
////    @Query("SELECT l FROM Layout l WHERE EXISTS (SELECT 1 FROM Completion c WHERE c.layout = l AND c.id = :completionId)")
////    List<Layout> findByCompletionId(@Param("completionId") UUID completionId);
//
////    @EntityGraph(attributePaths = {"completions"})
////    @Query("SELECT l FROM Layout l JOIN l.completions c WHERE c.id = :completionId")
////    List<Layout> findByCompletionId(@Param("completionId") UUID completionId);
//
////    @EntityGraph(attributePaths = {"completion"})
////    @Query("SELECT l FROM Layout l JOIN l.completions c WHERE c.id = :completionId")
////    Layout findByCompletionId(@Param("completionId") UUID completionId);
//
//    @EntityGraph(attributePaths = {"completion"})
//    Optional<Layout> findByCompletion_Id(UUID completionId);
//}

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
    List<Layout> findByCompletions_Id(UUID completionId);
//    Optional<Layout> findByCompletions_Id(UUID completionId);
}