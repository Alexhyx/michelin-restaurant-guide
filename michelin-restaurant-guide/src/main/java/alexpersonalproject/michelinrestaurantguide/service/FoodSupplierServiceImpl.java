package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.FoodSupplier;
import alexpersonalproject.michelinrestaurantguide.repository.FoodSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FoodSupplierServiceImpl implements FoodSupplierService{

    @Autowired
    private FoodSupplierRepository foodSupplierRepository;

    // *************** CRUD: Create -> HTTP: POST ****************
    @Override
    public FoodSupplier saveFoodSupplier(FoodSupplier foodSupplier) {
        return foodSupplierRepository.save(foodSupplier);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    @Override
    public Optional<FoodSupplier> fetchFoodSupplierById(Long foodSupplierId) {
        return foodSupplierRepository.findById(foodSupplierId);
    }

    @Override
    public List<FoodSupplier> fetchFoodSupplierList() {
        return foodSupplierRepository.findAll();
    }

    // *************** CRUD: Update -> HTTP: PUT ****************
    @Override
    public FoodSupplier updateFoodSupplier(Long foodSupplierId, FoodSupplier foodSupplier) {
        FoodSupplier foodSupplierDB = foodSupplierRepository.findById(foodSupplierId).get();

        if(Objects.nonNull(foodSupplier.getFoodSupplierName()) &&
        !"".equalsIgnoreCase(foodSupplier.getFoodSupplierName()))
        {
            foodSupplierDB.setFoodSupplierName(foodSupplier.getFoodSupplierName());
        }

        if(Objects.nonNull(foodSupplier.getFoodSupplierLocation()) &&
        !"".equalsIgnoreCase(foodSupplier.getFoodSupplierLocation()))
        {
            foodSupplierDB.setFoodSupplierLocation(foodSupplier.getFoodSupplierLocation());
        }
        return foodSupplierRepository.save(foodSupplierDB);
    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @Override
    public void deleteFoodSupplier(Long foodSupplierId) {
        foodSupplierRepository.deleteById(foodSupplierId);
    }
}
