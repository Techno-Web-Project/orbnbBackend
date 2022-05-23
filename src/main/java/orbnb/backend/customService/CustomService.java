package orbnb.backend.customService;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "custom_service")
@NoArgsConstructor
@Data
public class CustomService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custom_service_id")
    private Long customServiceId;

    private String description;

    @Column(name = "id_linked_housing")
    private Long idLinkedHousing;
}
