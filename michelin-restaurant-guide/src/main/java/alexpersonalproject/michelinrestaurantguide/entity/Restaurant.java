package alexpersonalproject.michelinrestaurantguide.entity;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// ** Only use this when you fetch = FetchType.LAZY
//@ToString(exclude = "restaurantOwner")

public class Restaurant {

    @Id
    @SequenceGenerator(
            name = "restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurant_sequence"
    )
    private long restaurantId;
    private String restaurantName;
    private String cuisine; // define the style of the restaurant


    // *********** one-to-one relationship ***********    Logic: Restaurant has exactly one restaurant owner, and for RestaurantOwner it owns only one restaurant.

    // Definition: a relationship where a record in one entity (table) is associated with exactly one record in another entity (table).
    /* Example of one-to-one :
        A country <-> capital city, every country has exactly one capital, and its capital belong to exact one country
        A person <-> their fingerprints, every person has their unique set of fingerprints, and the set of fingerprints only match with this person
        a wife <-> a husband,   in marriage, one wife can only have one husband, one husband can only have one wife
        user account <-> registered email, For many websites, one email address is associated with exactly one user account and each user account is identified by its email address.

    - Examples of not one-to-one:
        country <-> city, each city belong to exactly one country but one country can have many cities.
        parent <-> child, each child can have only one parent but one parent can have many kids.
     */

    // Then we need to define mapping:
    // Unidirectional Logic(单向关系): 这两个entity,地位是平行的，in this case: Restaurant will have a foreign key from RestaurantOwner(table of restaurant will have one more column called restaurant owner id)

    @OneToOne(
            // Cascade Types (设置关联操作) :
            // properties of Cascade (determine how to affect the related entity):
            /*
            1, ALL,     for All Persistence operation (持久化操作)
            2, PERSIST, only for insert operation
            3, MERGE,   only for update operation
            4, REMOVE,  only for delete operation
            */
            // cascade can achieve this: When we perform some action on the target entity (Restaurant), the same action will be applied to the associated entity (RestaurantOwner).
            cascade = CascadeType.ALL,

            // Fetch Types (Defines strategies for fetching data from the database):
            // 1, "FetchType.EAGER", when you try to fetch restaurant data, it will also fetch its restaurant owner (reference entity) data.
            // 2, "FetchType.LAZY", when you try to fetch restaurant data, it will not fetch its restaurant owner unless you specifically asked.
            fetch = FetchType.EAGER,
//            fetch = FetchType.LAZY,


            // with optional = false, whenever you are trying to save a restaurant, restaurant owner is required, it's not optional!
            // optional default is true;
            // if optional = false, in the RestaurantRepositoryTest.java will report error since the restaurant does not connect to restaurantOwner:
            /*  error example down below:
            @Test
            public void saveRestaurantWithRestaurantOwner() {
                RestaurantOwner restaurantOwner = RestaurantOwner.builder()
                        .ownerFirstName("Yixing")
                        .ownerLastName("Huang")
                        .ownerNetWorthInMillion(5)
                        .build();

                Restaurant restaurant = Restaurant.builder()
                        .restaurantName("Huang's hell kitchen")
                        .cuisine("Chinese")
                        .restaurantOwner(restaurantOwner)   **** if this line of code has been missed ****
                        .build();

            restaurantRepository.save(restaurant);
                     */
            optional = false
    )
    @NotFound(
            action = NotFoundAction.IGNORE
    )

    // @JoinColumn = Used to set the primary key(restaurantOwnerId) from RestaurantOwner entity and renamed by the name property in the @JoinColumn annotation(name = "****") to form a foreign key to the table(schemas) of Restaurant!
    // ***** For OneToOne relationship, who has the foreign key in the table uses the annotation @JoinColumn, the other entity use mappedBy!!! ******
    @JoinColumn(
            name = "restaurant_owner_id",
            referencedColumnName = "restaurantOwnerId"  // The primary key that you want to rename it and use it to generate a foreign key to put into another entity(table)
    )
    // the attribute below serve as a connection with RestaurantOwner entity(关联维护 RestaurantOwner entity):
    private RestaurantOwner restaurantOwner;
}
