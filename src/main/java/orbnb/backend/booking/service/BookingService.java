package orbnb.backend.booking.service;

import orbnb.backend.booking.Booking;


import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> getAllBookings();

    Booking addBooking(Booking booking);


    void deleteBooking(Long bookingId) ;

    Optional<Booking> getBookingById(Long bookingId) ;

    Booking saveBooking(Booking booking);
}
