package orbnb.backend.booking;

import orbnb.backend.housing.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findBookingByBookingId(Long id);

    List<Housing> findBookingByBookingDateBetween(
            Date booking_date_start,
            Date booking_date_end
    );
}
