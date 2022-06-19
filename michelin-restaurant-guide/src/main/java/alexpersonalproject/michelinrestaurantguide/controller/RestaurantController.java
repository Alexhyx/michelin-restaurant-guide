package alexpersonalproject.michelinrestaurantguide.controller;

import alexpersonalproject.michelinrestaurantguide.entity.Restaurant;
import alexpersonalproject.michelinrestaurantguide.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // *************** CRUD: Create -> HTTP: POST ****************
    @PostMapping("api/michelinrestaurant/restaurant")   //example input in postman: localhost:8080/api/michelinrestaurant/restaurant
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.saveRestaurant(restaurant);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    @GetMapping("api/michelinrestaurant/restaurant/{id}")
    public Optional<Restaurant> fetchRestaurantById(@PathVariable("id") Long restaurantId) {
        return restaurantService.fetchRestaurantById(restaurantId);
    }

    @GetMapping("api/michelinrestaurant/restaurant")
    public List<Restaurant> fetchAllRestaurant() {
        return restaurantService.fetchAllRestaurant();
    }

    // *************** CRUD: Update -> HTTP: PUT ****************
    @PutMapping("api/michelinrestaurant/restaurant/{id}")
    public Restaurant updateRestaurant(@PathVariable("id") Long restaurantId, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(restaurantId,restaurant);
    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @DeleteMapping("api/michelinrestaurant/restaurant/{id}")
    public String deleteRestaurant(@PathVariable("id") Long RestaurantId) {
        return restaurantService.deleteRestaurant(RestaurantId);
    }

}
