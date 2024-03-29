package car.shop.repository;

import car.shop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer getById(UUID id);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByMiddleName(String middleName);

    List<Customer> findByLastName(String lastName);
}
