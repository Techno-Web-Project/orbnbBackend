package orbnb.backend.booking.service;

import orbnb.backend.booking.Booking;
import orbnb.backend.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
   private BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return this.bookingRepository.findAll();
    }

    public Booking addBooking(Booking booking){
        return this.bookingRepository.save(booking);
    }


    public void deleteBooking(Long bookingId){
        this.bookingRepository.deleteById(bookingId);
    }

    public Optional<Booking> getBookingById(Long bookingId){
        return this.bookingRepository.findById(bookingId);
    }
}
