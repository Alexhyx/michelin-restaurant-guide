package alexpersonalproject.michelinrestaurantguide.repository;

import alexpersonalproject.michelinrestaurantguide.entity.Restaurant;
import alexpersonalproject.michelinrestaurantguide.entity.RestaurantOwner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantOwnerRepositoryTest {

    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;


    @Test
    public void fetchAllRestaurantOwnerWithRestaurant() {
        List<RestaurantOwner> restaurantOwnerList =
                restaurantOwnerRepository.findAll();
        System.out.println("All restaurant owner with their restaurant = " + restaurantOwnerList);
    }

    @Test
    public void deleteAllRestaurantOwner() {
        restaurantOwnerRepository.deleteAll();
    }

}