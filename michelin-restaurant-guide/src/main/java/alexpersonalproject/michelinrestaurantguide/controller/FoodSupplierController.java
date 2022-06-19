package alexpersonalproject.michelinrestaurantguide.controller;

import alexpersonalproject.michelinrestaurantguide.entity.FoodSupplier;
import alexpersonalproject.michelinrestaurantguide.service.FoodSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodSupplierController {

    @Autowired
    private FoodSupplierService foodSupplierService;

    // *************** CRUD: Create -> HTTP: POST ****************
    @PostMapping("api/michelinrestaurant/foodsupplier") //example input in postman: localhost:8080/api/michelinrestaurant/foodsupplier
    public FoodSupplier saveFoodSupplier(@RequestBody FoodSupplier foodSupplier) {
        return foodSupplierService.saveFoodSupplier(foodSupplier);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    @GetMapping("api/michelinrestaurant/foodsupplier/{id}")
    public Optional<FoodSupplier> fetchFoodSupplierById(@PathVariable("id") Long foodSupplierId) {
        return foodSupplierService.fetchFoodSupplierById(foodSupplierId);
    }

    @GetMapping("api/michelinrestaurant/foodsupplier")
    public List<FoodSupplier> fetchFoodSupplierList() {
        return foodSupplierService.fetchFoodSupplierList();
    }

    // *************** CRUD: Update -> HTTP: PUT ****************
    @PutMapping("api/michelinrestaurant/foodsupplier/{id}")
    public FoodSupplier updateFoodSupplier(@PathVariable("id") Long foodSupplierId, @RequestBody FoodSupplier foodSupplier) {
        return foodSupplierService.updateFoodSupplier(foodSupplierId, foodSupplier);
    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @DeleteMapping("api/michelinrestaurant/foodsupplier/{id}")
    public String deleteFoodSupplier(@PathVariable("id") Long foodSupplierId) { // If you want to receive text notify you, you need to change the Class (FoodSupplier) to String!
        foodSupplierService.deleteFoodSupplier(foodSupplierId);
        return "This food supplier has been deleted, time to find a new one!";
    }




}
