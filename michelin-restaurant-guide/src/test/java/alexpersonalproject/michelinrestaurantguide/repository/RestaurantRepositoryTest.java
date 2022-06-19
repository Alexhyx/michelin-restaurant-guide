package alexpersonalproject.michelinrestaurantguide.repository;

import alexpersonalproject.michelinrestaurantguide.entity.Restaurant;
import alexpersonalproject.michelinrestaurantguide.entity.RestaurantOwner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantRepositoryTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // ****** Testing for one-to-one relationship ******
    @Test
    public void saveRestaurantWithRestaurantOwner() {
        RestaurantOwner restaurantOwner = RestaurantOwner.builder()
                .ownerFirstName("Alex")
                .ownerLastName("Huang")
                .ownerNetWorthInMillion("5")
                .build();

        Restaurant restaurant = Restaurant.builder()
                .restaurantName("Restaurant Daniel")
                .cuisine("French")
                .restaurantOwner(restaurantOwner)
                .build();

        restaurantRepository.save(restaurant);
    }


    // Read method for Restaurant:
    // If you only want restaurant data: use "fetch = FetchType.LAZY" in Restaurant(entity), and add annotation "@ToString(exclude = "course")", to prevent error.
    // If you want Restaurant data with its related RestaurantOwner data: use "fetch = FetchType.EAGER" in Restaurant(entity), there is no need to add @ToString to exclude data in Restaurant entity.
    @Test
    public void fetchRestaurantWithRestaurantOwner() {
        List<Restaurant> restaurantList =
                restaurantRepository.findAll();
        System.out.println("The list of restaurants with their owners = " + restaurantList);
    }

    @Test
    public void fetchRestaurantWithRestaurantOwnerById() {
        Optional<Restaurant> restaurant =
                restaurantRepository.findById(8L);
        System.out.println("The restaurant with restaurant owner given by the id = " + restaurant);
    }

    @Test
    public void deleteRestaurant() {
                restaurantRepository.deleteAll();
    }
}