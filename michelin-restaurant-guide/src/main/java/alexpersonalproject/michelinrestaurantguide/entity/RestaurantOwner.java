package alexpersonalproject.michelinrestaurantguide.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RestaurantOwner {

    @Id
    @SequenceGenerator(
            name = "restaurantowner_sequence",
            sequenceName = "restaurantowner_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurantowner_sequence"
    )
    private long restaurantOwnerId;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerNetWorthInMillion;


    // *********** one-to-one relationship ***********
    // Now the entity is Unidirectional (单向关系） relationship. Restaurant (link with)-> RestaurantOwner, but RestaurantOwner does not link to Course yet!
    // To change to Bi directional（双向关系） relationship:
    @OneToOne(
            // Here you can't define @JoinColumn, since we already defined in the Restaurant, instead we use mappedBy:
            mappedBy = "restaurantOwner"    // from Restaurant Class: private RestaurantOwner restaurantOwner; the second "restaurantOwner"
    )
    private Restaurant restaurant;  // this attribute does not show on the database, it just serves as a connection to the CourseMaterial!






}
