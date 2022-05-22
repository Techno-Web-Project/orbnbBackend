package orbnb.backend.person;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import orbnb.backend.personRate.PersonRate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private String login;

    private String password;

    private String picture;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany
    @JoinTable(name = "T_PERSON_PERSONRATE", joinColumns = {@JoinColumn(name = "PERSON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERSONRATE_ID")})
    private Set<PersonRate> personRates;

    public Person(String firstName, String lastName, String phoneNumber, String email, String login, String password, String picture, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.picture = picture;
        this.birthDate = birthDate;
    }

}