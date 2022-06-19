package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.Restaurant;
import alexpersonalproject.michelinrestaurantguide.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // *************** CRUD: Create -> HTTP: POST ****************
    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    @Override
    public Optional<Restaurant> fetchRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }

    @Override
    public List<Restaurant> fetchAllRestaurant() {
        return restaurantRepository.findAll();
    }

    // *************** CRUD: Update -> HTTP: PUT ****************
    @Override
    public Restaurant updateRestaurant(Long restaurantId, Restaurant restaurant) {

        Restaurant restaurantDB = restaurantRepository.findById(restaurantId).get();

        if(Objects.nonNull(restaurant.getRestaurantName()) &&
        !"".equalsIgnoreCase(restaurant.getRestaurantName()))
        {
            restaurantDB.setRestaurantName(restaurant.getRestaurantName());
        }

        if(Objects.nonNull(restaurant.getCuisine()) &&
        !"".equalsIgnoreCase(restaurant.getCuisine()))
        {
            restaurantDB.setCuisine(restaurant.getCuisine());
        }

        return restaurantRepository.save(restaurantDB);
    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @Override
    public String deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
        return "This restaurant has been deleted!";
    }
}
