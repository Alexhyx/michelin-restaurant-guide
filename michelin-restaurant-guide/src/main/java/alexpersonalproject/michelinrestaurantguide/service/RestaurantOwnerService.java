package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.RestaurantOwner;

import java.util.List;
import java.util.Optional;

public interface RestaurantOwnerService {
    // *************** CRUD: Create -> HTTP: POST ****************
    RestaurantOwner saveRestaurantOwner(RestaurantOwner restaurantOwner);

    // *************** CRUD: Read -> HTTP: GET ****************
    Optional<RestaurantOwner> fetchRestaurantOwnerById(Long restaurantOwnerId);

    List<RestaurantOwner> fetchRestaurantOwnerList();

    // *************** CRUD: Update -> HTTP: PUT ****************
    RestaurantOwner updateRestaurantOwner(Long restaurantOwnerId, RestaurantOwner restaurantOwner);

    // *************** CRUD: Delete -> HTTP: DELETE ****************
   String deleteRestaurantOwner(Long restaurantOwnerId);

}
