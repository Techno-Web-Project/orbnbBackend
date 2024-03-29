package orbnb.backend.person;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import orbnb.backend.booking.Booking;
import orbnb.backend.housing.Housing;
import orbnb.backend.message.Message;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_PERSON_PERSONRATE", joinColumns = {@JoinColumn(name = "PERSON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERSONRATE_ID")})
    private Set<PersonRate> personRates;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "T_PERSON_HOUSING", joinColumns = {@JoinColumn(name = "PERSON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "HOUSING_ID")})
    private Set<Housing> housingsOwned;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_send_messages", joinColumns = {@JoinColumn(name = "id_person")},
            inverseJoinColumns = {@JoinColumn(name = "id_message")})
    private Set<Message> messagesSend;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_received_messages", joinColumns = {@JoinColumn(name = "id_person")},
            inverseJoinColumns = {@JoinColumn(name = "id_message")})
    private Set<Message> messageReceived;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_have_booking", joinColumns = {@JoinColumn(name = "id_person")},
            inverseJoinColumns = {@JoinColumn(name = "id_booking")})
    private Set<Booking> booking;

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