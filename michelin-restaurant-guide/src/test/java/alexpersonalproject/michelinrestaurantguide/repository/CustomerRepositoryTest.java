package alexpersonalproject.michelinrestaurantguide.repository;

import alexpersonalproject.michelinrestaurantguide.entity.Customer;
import alexpersonalproject.michelinrestaurantguide.entity.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// How its created:
    // created by the interface (StudentRepository) Steps: right click interface "StudentRepository" -> click "Generate" -> click "Test..."


@SpringBootTest // only use this annotation when you want the impact the database
// Typically, use the annotation below:
    //@DataJpaTest
        // It will help you to test your repository layer, once the operation is completed, it will help you to \
        // refresh the data. So the database won't be impacted

class CustomerRepositoryTest {

    /*
    *************** Dependency Injection ****************
    Dependency injection is basically providing the objects that an object needs (its dependencies) instead of having
    its constructs them itself. It's a very useful technique for testing, since it allows dependencies to be mocked or
    stubbed out.
    */
    @Autowired  // annotation for dependency injection
    private CustomerRepository customerRepository;

    // *************** CRUD: Create -> HTTP: POST ****************
    @Test
    public void saveCustomer() {

        Friend friend = Friend.builder()
                .name("Madeleine")
                .nationality("Swann")
                .build();

        Customer customer = Customer.builder()
                // When testing, you don't have to write out the primary key!
                .customerFirstName("James")
                .customerLastName("Bond")
                .customerEmail("JamesBond@gamil.com")
                .friend(friend)
                .build();

        customerRepository.save(customer);
    }

    // *************** CRUD: Read -> HTTP: GET ****************
    // ******************************* JpaRepository Method Name Testing *******************************
    // Read (SELECT) 查询:
    @Test
    public void printCustomerByFirstNameContaining() {
        List<Customer> customers =
            customerRepository.findByCustomerFirstNameContaining("J");
        System.out.println("This is the list of customers that contain given key word in their first name = " + customers);
    }

    @Test
    public void printCustomerById() {
        Customer customer =
                customerRepository.findByCustomerId(3);
        System.out.println("This is the customer based on this id = " + customer);
    }

    @Test
    public void printCustomerByFriendName() {
        List<Customer> customers =
                customerRepository.findByFriendName("Daniel");
        System.out.println("This is the list of customers that has this given friend = " + customers);
    }

    @Test
    public void printCustomerByFirstNameAndLastName() {
        Customer customer =
                customerRepository.findCustomerByCustomerFirstNameAndCustomerLastName(
                        "Yixing",
                        "Huang"
                );
        System.out.println("The customer with specific first name and last name: " + customer);
    }

    // *************** CRUD: Delete -> HTTP: DELETE ****************
    @Test
    public void deleteCustomerById() {
        customerRepository.deleteById(1L);
    }

    // But what if we want to do certain tasks but jpa doesn't have it? We create our own!
        // 自定义操作：To customize query method(jpql or SQL)
    // 1. ******************************* jpql (or SQL) Testing *******************************:

    @Test
    public void printGetCustomerByCustomerEmail() {
        List<Customer> customers =
                customerRepository.getCustomerByCustomerEmail(
                        "yixinghuang200122@gmail.com"
                );
        System.out.println("The list of customer that searched by customer email = " + customers);
    }

    @Test
    public void printGetCustomerFirstNameByCustomerEmail() {
        String firstName =
                customerRepository.getCustomerFirstNameByCustomerEmail(
                        "yixinghuang200122@gmail.com"
                );
        System.out.println("The customer's first name based on the customer email = " + firstName);
    }

    @Test
    public void printGetCustomerByCustomerFirstName() {
        List<Customer> customers =
                customerRepository.getCustomerByCustomerFirstName("James");
        System.out.println("The list of customers given by customer first name = " + customers);
    }

    // Update (UPDATE) 修改:
    @Test
    public void printUpdateCustomerEmailByCustomerFirstName() {
        int customerEmail =
                customerRepository.updateCustomerEmailByCustomerFirstName(
                        "JamesBond@gmail.com",
                        "James"
                );
        System.out.println("Customer email updated successfully!");
    }

    // Delete (DELETE) 删除:
    @Test
    public void printDeleteCustomerByCustomerId() {
        int Customer =
            customerRepository.deleteCustomerByCustomerId(4L);
        System.out.println("Customer " + Customer + " deleted successfully!");
    }

    //    // Create (INSERT) 新增：
    //这个要做的

    // ******************************* Native Query Testing *******************************:
    @Test
    public void printGetCustomerByCustomerEmailNative() {
        Customer customer =
                customerRepository.getCustomerByCustomerEmailNative(
                        "yixinghuang200122@gmail.com"
                );
        System.out.println("Customer searched by native query = " + customer);
    }











    // *************** CRUD: Update -> HTTP: PUT ****************





    // *************** CRUD: Delete -> HTTP: DELETE ****************

}