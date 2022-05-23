package orbnb.backend.booking;

import lombok.Data;
import lombok.NoArgsConstructor;
import orbnb.backend.housing.Housing;
import orbnb.backend.booking.enumeration.BookingStatus;
import orbnb.backend.person.Person;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "booking")
@NoArgsConstructor
@Data
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private Long bookingId;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date")
    private Date bookingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date_start")
    private Date bookingStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date_end")
    private Date bookingEndDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatus bookingStatus;

    @ManyToOne()
    @JoinColumn(name="id_person", referencedColumnName = "id")
    private Person person;

    @ManyToOne()
    @JoinColumn(name="id_housing", referencedColumnName = "id")
    private Housing housing;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }
}