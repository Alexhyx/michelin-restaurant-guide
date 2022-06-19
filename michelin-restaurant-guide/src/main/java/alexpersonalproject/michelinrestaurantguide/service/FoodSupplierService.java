package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.FoodSupplier;

import java.util.List;
import java.util.Optional;

public interface FoodSupplierService {

    // *************** CRUD: Create -> HTTP: POST ****************
    FoodSupplier saveFoodSupplier(FoodSupplier foodSupplier);

    // *************** CRUD: Read -> HTTP: GET ****************
    Optional<FoodSupplier> fetchFoodSupplierById(Long foodSupplierId);

    List<FoodSupplier> fetchFoodSupplierList();

    // *************** CRUD: Update -> HTTP: PUT ****************
    FoodSupplier updateFoodSupplier(Long foodSupplierId, FoodSupplier foodSupplier);

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    void deleteFoodSupplier(Long foodSupplierId);

}
