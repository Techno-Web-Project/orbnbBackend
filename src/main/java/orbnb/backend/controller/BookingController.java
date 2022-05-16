package orbnb.backend.controller;

import orbnb.backend.model.Booking;
import orbnb.backend.model.Housing;
import orbnb.backend.service.Booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    // http://localhost:8081/SpringMVC/booking/retrieve-all-bookings

    @GetMapping("/retrieve-all-bookings")
    @ResponseBody
    public List<Booking> getBookings() {
        List<Booking> listBookings = bookingService.retrieveAllBookings();
        return listBookings;
    }

    // http://localhost:8081/SpringMVC/booking/retrieve-booking/{booking-id}

    @GetMapping("retrieve-booking/{booking-id}")
    @ResponseBody
    public Booking getBooking(@PathVariable("booking-id") Long bookingId) {
        return bookingService.retrieveBooking(bookingId);
    }


    // http://localhost:8081/SpringMVC/booking/add-booking

    @PostMapping("/add-booking")
    @ResponseBody
    public Booking addBooking (@RequestBody Booking b) {
        Booking booking = bookingService.addBooking(b);
        return booking;
    }

    // http://localhost:8081/SpringMVC/booking/remove-booking/{booking-id}
    @DeleteMapping("/remove-booking/{booking-id}")
    @ResponseBody
    public void removeBooking(@PathVariable("booking-id") Long bookingId) {
        bookingService.deleteBooking(bookingId);}


}
