package orbnb.backend.service.Booking;

import orbnb.backend.model.Booking;


import java.util.List;

public interface BookingService {

    List<Booking> retrieveAllBookings();

    Booking addBooking(Booking b);


    void deleteBooking(Long id) ;

    Booking retrieveBooking(Long id) ;
}
