package alexpersonalproject.michelinrestaurantguide.controller;

import alexpersonalproject.michelinrestaurantguide.entity.Customer;
import alexpersonalproject.michelinrestaurantguide.entity.Friend;
import alexpersonalproject.michelinrestaurantguide.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // For this class, we can have methods to expose some endpoints that clients can consume.
//you can also use @RequestMapping("api/v1/person") // Define the api request endpoint.  ex: localhost:8080/api/michelinrestaurant/customer
    // so that you don't have to define it in every request!
public class CustomerController {

    // tells the springboot to actually inject the service(PersonService) into this constructor:
    @Autowired
    // A reference to the actual service and ready to practice dependency injection in class constructor:
    private CustomerService customerService;

    // *************** CRUD: Create -> HTTP: POST ****************
    @PostMapping("api/michelinrestaurant/customer") // For example, put into postman: localhost:8080/api/michelinrestaurant/customer
    // jason data example (data been stored in mysql database), remember the "property"(左边那个) is the original attribute in the entity, not the name shown in the database!
    /*{
        "customerFirstName":"Yixing",
        "customerLastName":"Huang",
        "customerEmail":"yixinghuang222@gmail.com",
        "friend": {
            "name": "Camille",
            "nationality": "Switzerland"
        }
    }
     */
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }


    // *************** CRUD: Read -> HTTP: GET ****************
    @GetMapping("api/michelinrestaurant/customer/{id}")
    public Optional<Customer> fetchCustomerById(@PathVariable("id") Long customerId) {  // annotation @PathVariable("id") is to get the ID from the path
        return customerService.fetchCustomerById(customerId);
    }

    @GetMapping("api/michelinrestaurant/customer")
    public List<Customer> fetchCustomerList(){
        return customerService.fetchCustomerList();
    }


    // *************** CRUD: Update -> HTTP: PUT ****************
    @PutMapping("api/michelinrestaurant/customer/{id}")
    public Customer updateCustomer(@PathVariable("id") Long customerId, @RequestBody Customer customer) {
        // Call the service layer:
        return customerService.updateCustomer(customerId, customer);
    }

//    // Update embedded information(Friend):
//    @PutMapping("api/michelinrestaurant/customer/{id}")
//    public Customer updateFriend(@PathVariable("id") Long customerId, @RequestBody Friend friend) {
//        return customerService.updateFriend(customerId, friend);
//    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @DeleteMapping("api/michelinrestaurant/customer/{id}")
    public String deleteCustomerById(@PathVariable("id") Long customerId) {
        customerService.deleteCustomerById(customerId); // this method is already void so there is no need to add the "return"
        return "This particular customer has been deleted successfully WooHoo! ";
    }

}
