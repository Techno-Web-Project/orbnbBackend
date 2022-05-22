package orbnb.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import orbnb.backend.housing.Housing;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private String logo;

    @ManyToMany
    @JoinTable(
            name = "housing_service",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "housing_id"))
    Set<Housing> linkedHousing;

    public Service(String description, String logo) {
        this.description = description;
        this.logo = logo;
    }

    public Service(String description, String logo, Set<Housing> linkedHousing) {
        this.description = description;
        this.logo = logo;
        this.linkedHousing = linkedHousing;
    }
}
