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

public class FoodSupplier {

    @Id
    @SequenceGenerator(
            name = "food_supplier_sequence",
            sequenceName = "food_supplier_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "food_supplier_sequence"
    )
    private long foodSupplierId;
    private String foodSupplierName;
    private String foodSupplierLocation;
}
