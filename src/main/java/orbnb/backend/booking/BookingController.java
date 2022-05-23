package orbnb.backend.booking;

import orbnb.backend.booking.service.BookingService;
import orbnb.backend.housing.Housing;
import orbnb.backend.housing.service.HousingService;
import orbnb.backend.person.Person;
import orbnb.backend.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/bookingApi")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PersonService personService;

    @Autowired
    private HousingService housingService;

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<Booking>> getBookings() {
        return new ResponseEntity<>(this.bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/getBookingById/{bookingId}")
    public ResponseEntity<Optional<Booking>> getBooking(@PathVariable("bookingId") Long bookingId) {
        return new ResponseEntity<>(this.bookingService.getBookingById(bookingId), HttpStatus.OK);
    }

    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        return new ResponseEntity<>(this.bookingService.addBooking(booking), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBooking/{bookingId}")
    public void removeBooking(@PathVariable("bookingId") Long bookingId) {
        this.bookingService.deleteBooking(bookingId);
    }

    @PutMapping("/{id_booking}/assignedBookingToPerson/{id_person}")
    Booking assignedBookingToPerson(
            @PathVariable Long id_person,
            @PathVariable Long id_booking
    ) {
        Booking booking = bookingService.getBookingById(id_booking).get();
        Person person = personService.getPersonById(id_person).get();
        booking.setPerson(person);
        return bookingService.saveBooking(booking);
    }

    @PutMapping("/{id_booking}/assignedBookingToHousing/{id_housing}")
    Booking assignedBookingToHousing(
            @PathVariable Long id_housing,
            @PathVariable Long id_booking
    ) {
        Booking booking = bookingService.getBookingById(id_booking).get();
        Housing housing = housingService.getHousingById(id_housing).get();
        booking.setHousing(housing);
        return bookingService.saveBooking(booking);
    }

}
