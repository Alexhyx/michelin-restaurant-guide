package alexpersonalproject.michelinrestaurantguide.repository;

import alexpersonalproject.michelinrestaurantguide.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    // *************** CRUD: Create -> HTTP: POST ****************
    // *************** CRUD: Read -> HTTP: GET ****************
    // *************** CRUD: Update -> HTTP: PUT ****************
    // *************** CRUD: Delete -> HTTP: DELETE ****************
}
