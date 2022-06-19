package alexpersonalproject.michelinrestaurantguide.repository;

import alexpersonalproject.michelinrestaurantguide.entity.Customer;
import alexpersonalproject.michelinrestaurantguide.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


//    // Update (UPDATE) 修改:
//    @Transactional
//    @Modifying
//    @Query("UPDATE Customer s SET s.friend=:name WHERE s.customerId=:customerId")
//    Customer updateFriendNameByCustomerId(@Param("name") Friend name, @Param("customerId") Long customerId);












    // ******************************* For CustomerRepository Testing *******************************:
    List<Customer> findByCustomerFirstNameContaining(String customerFirstName); // parameter is the attribute's name

    Customer findByCustomerId(long customerId);

    List<Customer> findByFriendName(String name);

    Customer findCustomerByCustomerFirstNameAndCustomerLastName(String customerFirstName, String customerLastName);

    // ******************************* JPQL *******************************:
    // ***** However, these method options from JpaRepository are limited, and then we need to customize our query method! *****
    // 我们需要进行自定义操作(To customize query method)：
    // 1. use jpql (or SQL)
    // Edit the parameter:
    // 1, use index = ?1(number 1, 2, 3)
    // 2, use name = ':' + "parameter name"  , with using @Param("parameter name")!!
    // For INSERT, UPDATE, DELETE(增删改）：
    // has to add annotation: @Transactional and @Modifying

    // Read (SELECT) 查询:
    // JPQL query is based on the entity's class name, not the name on the  database table!
    @Query("SELECT s FROM Customer s WHERE s.customerEmail = ?1")   // Customer = entity class, customerEmail = entity attribute
    List<Customer> getCustomerByCustomerEmail(String customerEmail);

    @Query("SELECT s.customerFirstName FROM Customer s WHERE s.customerEmail = ?1")
    String getCustomerFirstNameByCustomerEmail(String customerEmail);

    @Query("SELECT s FROM Customer s WHERE s.customerFirstName=:customerFirstName")
    List<Customer> getCustomerByCustomerFirstName(@Param("customerFirstName") String customerFirstName);


    // Update (UPDATE) 修改:
    @Transactional  // This annotation is to mimic Service Layer(Business logic)
    @Modifying  // Tell the spring data JPA that this method is used for CRUD operation
    @Query("UPDATE Customer s SET s.customerEmail=:customerEmail WHERE s.customerFirstName=:customerFirstName")
    int updateCustomerEmailByCustomerFirstName(@Param("customerEmail") String customerEmail, @Param("customerFirstName") String customerFirstName);

    // Delete (DELETE) 删除:
    @Transactional
    @Modifying
    @Query("DELETE FROM Customer s WHERE s.customerId = ?1")
    int deleteCustomerByCustomerId(Long customerId);


    // ******************************* Native Query ************* ******************:
    // Native Query (Native query refers to actual sql queries (referring to actual database objects). These queries \
    // are the sql statements which can be directly executed in database using a database client):
    // Read (SELECT) 查询 by using Native Query:
    @Query(
            value = ("SELECT * FROM customer s WHERE s.customer_email_address = ?1"),   // the s.customer_email_address \
            // has to be the modified name of the attribute, not the original one!
            nativeQuery = true
    )
    Customer getCustomerByCustomerEmailNative(String customerEmail);

}
