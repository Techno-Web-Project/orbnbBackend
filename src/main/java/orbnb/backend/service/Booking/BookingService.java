package orbnb.backend.service.Booking;

import orbnb.backend.model.Booking;
import orbnb.backend.model.Housing;


import java.util.List;

public interface BookingService {

    public List<Booking> retrieveAllBookings();

    public Booking addBooking(Booking b);


    public void deleteBooking(Long id) ;

    public Booking retrieveBooking(Long id) ;
}
