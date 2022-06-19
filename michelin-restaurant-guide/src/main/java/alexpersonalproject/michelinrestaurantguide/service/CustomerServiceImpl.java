package alexpersonalproject.michelinrestaurantguide.service;

import alexpersonalproject.michelinrestaurantguide.entity.Customer;
import alexpersonalproject.michelinrestaurantguide.entity.Friend;
import alexpersonalproject.michelinrestaurantguide.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    // use dependency injection to fetch CustomerRepository interface to this class(CustomerServiceImplementation)!
    @Autowired // the way we are injecting PersonDao(Interface) to the constructor is: @Autowired
    private CustomerRepository customerRepository;
        /*
    *************** Dependency Injection ****************
    Dependency injection is basically providing the objects that an object needs (its dependencies) instead of having
    its constructs them itself. It's a very useful technique for testing, since it allows dependencies to be mocked or
    stubbed out.
    */


    // *************** CRUD: Create -> HTTP: POST ****************
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    @Override
    public Optional<Customer> fetchCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }


    // *************** CRUD: Update -> HTTP: PUT ****************
//    @Override
//    public Customer updateCustomer(Long customerId, Customer customer) {
//        return customerRepository.updateCustomerById(customerId, customer);
//    }
    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {

        // First, you need to get the particular customer by customerId:
        Customer customerDB = customerRepository.findById(customerId).get();

        // Check the condition (not null and not blank) for the new input in PostMan, then replace the older customer with the newer customer):
            /* Difference among null, empty, blank:
                - null = doesn't even have the attribute name
                    example:
                    (空白）
                - empty = does have attribute name but no property name
                    example:
                    "customer" : ""
                - blank = does have attribute name and inside the property name, it has space bar
                    example:
                    "customer" : "      "
             */
        if(Objects.nonNull(customer.getCustomerFirstName()) &&  // not null
        !"".equalsIgnoreCase(customer.getCustomerFirstName())   // not empty, but if it is blank, the code will still proceed.
        ) {
            customerDB.setCustomerFirstName(customer.getCustomerFirstName());
        }

        if(Objects.nonNull(customer.getCustomerLastName()) &&
        !"".equalsIgnoreCase(customer.getCustomerLastName())
        ) {
            customerDB.setCustomerLastName(customer.getCustomerLastName());
        }

        if(Objects.nonNull(customer.getCustomerEmail()) &&
        !"".equalsIgnoreCase(customer.getCustomerEmail())
        ) {
            customerDB.setCustomerEmail(customer.getCustomerEmail());
        }
        // 这里搞embedded update:


        return customerRepository.save(customerDB);
    }

//    @Override
//    public Customer updateFriend(Long customerId, Friend name) {
//        return customerRepository.updateFriendNameByCustomerId(name, customerId);
//    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @Override
    public void deleteCustomerById(Long CustomerId) {
        customerRepository.deleteById(CustomerId);
    }



}
