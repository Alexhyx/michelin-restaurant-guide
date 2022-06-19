package alexpersonalproject.michelinrestaurantguide.repository;

import alexpersonalproject.michelinrestaurantguide.entity.FoodSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodSupplierRepository extends JpaRepository<FoodSupplier,Long> {
    // *************** CRUD: Create -> HTTP: POST ****************
    // *************** CRUD: Read -> HTTP: GET ****************
    // *************** CRUD: Update -> HTTP: PUT ****************
    // *************** CRUD: Delete -> HTTP: DELETE ****************
}
