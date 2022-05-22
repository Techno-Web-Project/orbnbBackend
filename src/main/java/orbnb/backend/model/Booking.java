package orbnb.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import orbnb.backend.housing.Housing;
import orbnb.backend.model.enumeration.BookingStatus;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking")
    private Long id_booking;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date")
    private Date booking_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date_start")
    private Date booking_date_start;

    @Temporal(TemporalType.DATE)
    @Column(name = "booking_date_end")
    private Date booking_date_end;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status")
    private BookingStatus booking_status;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_housing")
    private Housing housing;

}