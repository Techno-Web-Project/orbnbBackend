package orbnb.backend.model;

import lombok.*;
import orbnb.backend.model.enumeration.HousingType;

import javax.persistence.*;


@Entity
@Table(name="housing")
@Data
@NoArgsConstructor
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String street;

    private String city;

    private String country;

    @Column(name="postal_code")
    private String postalCode;

    private Boolean validate;

    @Enumerated(EnumType.STRING)
    @Column(name="housing_type")
    private HousingType housingType;

    @Column(name="number_of_bed")
    private Integer numberOfBed;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

}
