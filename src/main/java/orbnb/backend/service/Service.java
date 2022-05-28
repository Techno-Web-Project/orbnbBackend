package orbnb.backend.service;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "service")
@NoArgsConstructor
@Data
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    private String description;

    private String logo;

    public Service(String description, String logo) {
        this.description = description;
        this.logo = logo;
    }
}
