package car.shop.repository;

import car.shop.entity.Purchase;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

    @Override
    @EntityGraph(attributePaths = {"customer", "car"})
    Purchase getById(UUID id);

    @Override
    @EntityGraph(attributePaths = {"customer", "car"})
    List<Purchase> findAll();

    @EntityGraph(attributePaths = {"customer", "car"})
    Purchase getByPurchaseNumber(int purchaseNumber);

    @EntityGraph(attributePaths = {"customer", "car"})
    List<Purchase> findByCustomerId(UUID customerId);

    @EntityGraph(attributePaths = {"customer", "car"})
    List<Purchase> findByCarId(UUID carId);
}
