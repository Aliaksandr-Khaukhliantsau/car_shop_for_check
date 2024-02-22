package car.shop.repository;

import car.shop.entity.Car;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {

    @Override
    @EntityGraph(attributePaths = {"layout"})
    Car getById(UUID id);

    @Override
    @EntityGraph(attributePaths = {"layout"})
    List<Car> findAll();

    @EntityGraph(attributePaths = {"layout"})
    Car getByVin(String vin);

    @EntityGraph(attributePaths = {"layout"})
    List<Car> findByLayoutId(UUID layoutId);
}
