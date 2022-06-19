package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.RestaurantOwner;
import alexpersonalproject.michelinrestaurantguide.repository.RestaurantOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestaurantOwnerServiceImpl implements RestaurantOwnerService{

    @Autowired
    private RestaurantOwnerRepository restaurantOwnerRepository;

    // *************** CRUD: Create -> HTTP: POST ****************
    @Override
    public RestaurantOwner saveRestaurantOwner(RestaurantOwner restaurantOwner) {
        return restaurantOwnerRepository.save(restaurantOwner);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    @Override
    public Optional<RestaurantOwner> fetchRestaurantOwnerById(Long restaurantOwnerId) {
        return restaurantOwnerRepository.findById(restaurantOwnerId);
    }

    @Override
    public List<RestaurantOwner> fetchRestaurantOwnerList() {
        return restaurantOwnerRepository.findAll();
    }

    // *************** CRUD: Update -> HTTP: PUT ****************
    @Override
    public RestaurantOwner updateRestaurantOwner(Long restaurantOwnerId, RestaurantOwner restaurantOwner) {

        RestaurantOwner restaurantOwnerDB = restaurantOwnerRepository.findById(restaurantOwnerId).get();

        if(Objects.nonNull(restaurantOwner.getOwnerFirstName()) &&
        !"".equalsIgnoreCase(restaurantOwner.getOwnerFirstName()))
        {
            restaurantOwnerDB.setOwnerFirstName(restaurantOwner.getOwnerFirstName());
        }

        if(Objects.nonNull(restaurantOwner.getOwnerLastName()) &&
        !"".equalsIgnoreCase(restaurantOwner.getOwnerLastName()))
        {
            restaurantOwnerDB.setOwnerLastName(restaurantOwner.getOwnerLastName());
        }

        restaurantOwnerDB.setOwnerNetWorthInMillion(restaurantOwnerDB.getOwnerNetWorthInMillion());

        return restaurantOwnerRepository.save(restaurantOwnerDB);
    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @Override
    public String deleteRestaurantOwner(Long restaurantOwnerId) {
        restaurantOwnerRepository.deleteById(restaurantOwnerId);
        return "This restaurant owner has been deleted!";
    }

}
