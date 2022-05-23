package orbnb.backend.housing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import orbnb.backend.booking.Booking;
import orbnb.backend.housing.enumeration.HousingType;
import orbnb.backend.person.Person;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


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

    @JsonIgnore
    @OneToMany(mappedBy = "housing")
    private Set<Booking> bookings = new HashSet<>();
//
//    @ManyToMany
//    Set<Service> housingLinkedServices;

}