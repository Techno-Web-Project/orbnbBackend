package orbnb.backend.housing;

import lombok.*;
import orbnb.backend.booking.Booking;
import orbnb.backend.constraint.Constraints;
import orbnb.backend.customConstraint.CustomConstraint;
import orbnb.backend.customService.CustomService;
import orbnb.backend.housing.enumeration.HousingType;
import orbnb.backend.housingRate.HousingRate;
import orbnb.backend.picture.Picture;
import orbnb.backend.service.Service;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "housing")
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

    @Column(name = "postal_code")
    private String postalCode;

    private Boolean validate;

    @Enumerated(EnumType.STRING)
    @Column(name = "housing_type")
    private HousingType housingType;

    @Column(name = "number_of_bed")
    private Integer numberOfBed;

    private Long PersonId;

    @OneToMany
    @JoinTable(name = "housing_pictures", joinColumns = {@JoinColumn(name = "housing_id")},
            inverseJoinColumns = {@JoinColumn(name = "picture_id")})
    private Set<Picture> housingPictures;

    @OneToMany
    @JoinTable(name = "housing_custom_services", joinColumns = {@JoinColumn(name = "housing_id")},
            inverseJoinColumns = {@JoinColumn(name = "custom_service_id")})
    private Set<CustomService> customServices;

    @OneToMany
    @JoinTable(name = "housing_custom_constraints", joinColumns = {@JoinColumn(name = "housing_id")},
            inverseJoinColumns = {@JoinColumn(name = "custom_constraint_id")})
    private Set<CustomConstraint> customConstraints;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_Housing_Service", joinColumns = {@JoinColumn(name = "HOUSING_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SERVICE_ID")})
    private Set<Service> linkedServices;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_Housing_Constraint", joinColumns = {@JoinColumn(name = "HOUSING_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CONSTRAINT_ID")})
    private Set<Constraints> linkedConstraints;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_HOUSING_HOUSINGRATE", joinColumns = {@JoinColumn(name = "HOUSING_ID")},
            inverseJoinColumns = {@JoinColumn(name = "HOUSINGRATE_ID")})
    private Set<HousingRate> housingRates;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "housing_booked", joinColumns = {@JoinColumn(name = "housing_id")},
            inverseJoinColumns = {@JoinColumn(name = "id_booking")})
    private Set<Booking> bookings;

}