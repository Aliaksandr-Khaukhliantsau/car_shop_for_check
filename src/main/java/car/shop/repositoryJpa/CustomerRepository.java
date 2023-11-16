package car.shop.repositoryJpa;

import car.shop.entityJpa.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    List<Customer> findByFirstName(String firstName);
    List<Customer> findByMiddleName(String middleName);
    List<Customer> findByLastName(String lastName);
    Optional<Customer> findById(UUID id);
}
