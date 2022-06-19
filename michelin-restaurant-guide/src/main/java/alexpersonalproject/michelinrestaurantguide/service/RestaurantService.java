package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    // *************** CRUD: Create -> HTTP: POST ****************
    Restaurant saveRestaurant(Restaurant restaurant);

    // *************** CRUD: Read -> HTTP: GET ****************
    Optional<Restaurant> fetchRestaurantById(Long restaurantId);

    List<Restaurant> fetchAllRestaurant();

    // *************** CRUD: Update -> HTTP: PUT ****************
    Restaurant updateRestaurant(Long restaurantId, Restaurant restaurant);

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    String deleteRestaurant(Long restaurantId);

}
