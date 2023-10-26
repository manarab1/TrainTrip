package com.example.TrainTrip.Controller.impl;

import com.example.TrainTrip.Controller.interfaces.BookingController;
import com.example.TrainTrip.Entity.Booking;
import com.example.TrainTrip.Service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingControllerImpl implements BookingController {
    private final BookingService bookingService ;

    @Autowired
    public BookingControllerImpl (BookingService bookingService){

        this.bookingService = bookingService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public Booking getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping("/customer/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingService.getBookingsByCustomerId(customerId);
    }

    @GetMapping("/traintrip/{trainTripId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Booking> getBookingsByTrainTripId(@PathVariable Long trainTripId) {
        return bookingService.getBookingsByTrainTripId(trainTripId);
    }


    @PutMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public Booking updateBooking(@PathVariable Long bookingId, @RequestBody Booking updatedBooking) {
        return bookingService.updateBooking(bookingId, updatedBooking);
    }

    @DeleteMapping("/{bookingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
    }
}
