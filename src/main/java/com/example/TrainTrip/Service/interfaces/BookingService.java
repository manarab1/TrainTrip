package com.example.TrainTrip.Service.interfaces;

import com.example.TrainTrip.Entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long bookingId);
    List<Booking> getBookingsByCustomerId(Long customerId);
    List<Booking> getBookingsByTrainTripId(Long trainTripId);
    Booking updateBooking(Long bookingId, Booking updatedBooking);
    void deleteBooking(Long bookingId);
}
