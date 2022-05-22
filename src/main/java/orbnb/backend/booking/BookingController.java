package orbnb.backend.booking;

import orbnb.backend.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookingApi")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/getAllBookings")
    public ResponseEntity<List<Booking>> getBookings() {
        return new ResponseEntity<>(this.bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("getBookingById/{bookingId}")
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

}
