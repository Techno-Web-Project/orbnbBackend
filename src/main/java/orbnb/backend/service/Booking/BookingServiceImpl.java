package orbnb.backend.service.Booking;

import orbnb.backend.model.Booking;
import orbnb.backend.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> retrieveAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking addBooking(Booking b){
        bookingRepository.save(b);
        return b;
    }


    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }

    public Booking retrieveBooking(Long id){
        return bookingRepository.findBookingById_booking(id);
    }
}
