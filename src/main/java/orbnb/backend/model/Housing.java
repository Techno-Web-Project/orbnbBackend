package orbnb.backend.model;

import lombok.*;
import orbnb.backend.model.enumeration.HousingType;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="housing")
@Data
@NoArgsConstructor
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name = "validate")
    private Boolean validate;

    @Enumerated(EnumType.STRING)
    @Column(name="housing_type")
    private HousingType housingType;

    @Column(name="number_of_bed")
    private Integer numberOfBed;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @ManyToMany
    Set<Housing> housingLinkedServices;

}