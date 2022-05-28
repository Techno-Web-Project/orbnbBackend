package orbnb.backend.constraint;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "constraints")
@NoArgsConstructor
@Data
public class Constraints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constraints_id")
    private Long constraintsId;

    private String description;

    private String logo;

    public Constraints(String description, String logo) {
        this.description = description;
        this.logo = logo;
    }
}
