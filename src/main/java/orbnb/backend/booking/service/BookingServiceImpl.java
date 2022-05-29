package orbnb.backend.booking.service;

import orbnb.backend.booking.Booking;
import orbnb.backend.booking.BookingRepository;
import orbnb.backend.housing.Housing;
import orbnb.backend.housing.HousingRepository;
import orbnb.backend.person.Person;
import orbnb.backend.person.PersonRepository;
import orbnb.backend.personRate.PersonRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
   private BookingRepository bookingRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private HousingRepository housingRepository;

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

    @Override
    public void assignBookingToPerson(Long idBooking, Long idPerson) {
        Booking booking = this.bookingRepository.findBookingByBookingId(idBooking);
        Person person =  this.personRepository.findPersonById(idPerson);
        person.getBooking().add(booking);
        booking.setBookingId(idBooking);
        personRepository.save(person);
    }

    @Override
    public void assignBookingToHousing(Long idBooking, Long idHousing) {
        Booking booking = this.bookingRepository.findBookingByBookingId(idBooking);
        Housing housing = this.housingRepository.findHousingsById(idHousing);
        housing.getBookings().add(booking);
        booking.setBookingId(idBooking);
        housingRepository.save(housing);
    }

    @Override
    public Booking updateBooking(Booking booking){
        return bookingRepository.save(booking);
    }
}
