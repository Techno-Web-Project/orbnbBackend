package orbnb.backend.booking.service;

import orbnb.backend.booking.Booking;
import orbnb.backend.housing.Housing;


import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> getAllBookings();

    Booking addBooking(Booking booking);


    void deleteBooking(Long bookingId);

    Optional<Booking> getBookingById(Long bookingId);

    void assignBookingToPerson(Long idBooking, Long idPerson);

    void assignBookingToHousing(Long idBooking, Long idHousing);

    boolean isHousingBooked(Date startDate, Date endDate);

}
