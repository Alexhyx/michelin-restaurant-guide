package alexpersonalproject.michelinrestaurantguide.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "friend_name")
        ),
        @AttributeOverride(
                name = "nationality",
                column = @Column(name = "friend_nationality")
        )
})

public class Friend {
    private String name;
    private String nationality;
}
