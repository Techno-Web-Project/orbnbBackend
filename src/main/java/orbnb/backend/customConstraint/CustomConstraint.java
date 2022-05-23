package orbnb.backend.customConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "custom_constraint")
@NoArgsConstructor
@Data
public class CustomConstraint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custom_constraint_id")
    private Long customConstraintId;

    private String description;

    @Column(name = "id_linked_housing")
    private Long linkedHousingId;
}
