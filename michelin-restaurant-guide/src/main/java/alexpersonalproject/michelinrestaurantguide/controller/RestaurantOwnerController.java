package alexpersonalproject.michelinrestaurantguide.controller;

import alexpersonalproject.michelinrestaurantguide.entity.RestaurantOwner;
import alexpersonalproject.michelinrestaurantguide.service.RestaurantOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantOwnerController {

    @Autowired
    private RestaurantOwnerService restaurantOwnerService;

    // *************** CRUD: Create -> HTTP: POST ****************
    @PostMapping("api/michelinrestaurant/restaurantowner")
    public RestaurantOwner saveRestaurantOwner(@RequestBody RestaurantOwner restaurantOwner) {
        return restaurantOwnerService.saveRestaurantOwner(restaurantOwner);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    @GetMapping("api/michelinrestaurant/restaurantowner/{id}")
    public Optional<RestaurantOwner> fetchRestaurantOwnerById(@PathVariable("id") Long restaurantOwnerId) {
        return restaurantOwnerService.fetchRestaurantOwnerById(restaurantOwnerId);
    }

    @GetMapping("api/michelinrestaurant/restaurantowner")
    public List<RestaurantOwner> fetchRestaurantOwnerList() {
        return restaurantOwnerService.fetchRestaurantOwnerList();
    }

    // *************** CRUD: Update -> HTTP: PUT ****************
    @PutMapping("api/michelinrestaurant/restaurantowner/{id}")
    public RestaurantOwner updateRestaurantOwner(@PathVariable("id") Long restaurantOwnerId, @RequestBody RestaurantOwner restaurantOwner) {
        return restaurantOwnerService.updateRestaurantOwner(restaurantOwnerId, restaurantOwner);
    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @DeleteMapping("api/michelinrestaurant/restaurantowner/{id}")
    public String deleteRestaurantOwner(@PathVariable("id") Long restaurantOwnerId) {
        return restaurantOwnerService.deleteRestaurantOwner(restaurantOwnerId);
    }



}
