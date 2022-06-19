package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.Customer;
import alexpersonalproject.michelinrestaurantguide.entity.Friend;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    // *************** CRUD: Create -> HTTP: POST ****************
    public Customer saveCustomer(Customer customer);


    // *************** CRUD: Read -> HTTP: GET ****************
    public Optional<Customer> fetchCustomerById(Long customerId);

    public List<Customer> fetchCustomerList();


    // *************** CRUD: Update -> HTTP: PUT ****************
//    public Customer updateCustomer(Long customerId, Customer customer);
    Customer updateCustomer(Long customerId, Customer customer);

//    Customer updateFriend(Long customerId, Friend friend);

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    public void deleteCustomerById(Long CustomerId);

}
