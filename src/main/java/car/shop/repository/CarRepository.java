package car.shop.repository;

import car.shop.entity.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    @Override
    @EntityGraph(attributePaths = {"layout"})
    Optional<Car> findById(UUID id);

    @Override
    @EntityGraph(attributePaths = {"layout"})
    List<Car> findAll();

    @EntityGraph(attributePaths = {"layout"})
    Optional<Car> findByVin(String vin);

    @EntityGraph(attributePaths = {"layout"})
    List<Car> findByLayoutId(UUID layoutId);
}
