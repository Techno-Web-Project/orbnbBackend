package orbnb.backend.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findBookingByBookingId(Long id);

    @Query("SELECT b.bookingId FROM Booking b WHERE b.housingBookedId = ?1 AND b.bookingStartDate BETWEEN ?2 AND ?3 OR b.bookingEndDate BETWEEN ?2 AND ?3")
    List<Long> bookingFromDateToDateByHousingId(@Param("housingBookedIdParam") Long housingBookedIdParam, @Param("startingDateParam") Date startingDate, @Param("endingDateParam") Date endingDate);
}
