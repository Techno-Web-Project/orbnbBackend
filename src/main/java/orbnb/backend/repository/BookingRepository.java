package orbnb.backend.repository;

import orbnb.backend.model.Booking;
import orbnb.backend.model.Housing;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    List<Booking> findAll();

    Booking save(Booking booking);

    void delete(Booking entity);

    @Query("select b from Booking b where b.id_booking=:id")
    Booking findBookingById_booking(@Param("id") Long id);
}
