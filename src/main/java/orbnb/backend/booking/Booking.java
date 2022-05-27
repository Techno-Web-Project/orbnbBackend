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

}