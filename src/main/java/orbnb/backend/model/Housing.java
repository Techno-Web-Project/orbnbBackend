package orbnb.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import orbnb.backend.model.enumeration.HousingType;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="housing")
public class Housing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public Housing(String description, String street, String city, String country, String postalCode, Boolean validate, HousingType housingType, Integer numberOfBed, Person person) {
        this.description = description;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.validate = validate;
        this.housingType = housingType;
        this.numberOfBed = numberOfBed;
        this.person = person;
    }
}
