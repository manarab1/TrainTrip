package com.example.TrainTrip.Controller.interfaces;

import com.example.TrainTrip.Entity.Booking;

import java.util.List;

public interface BookingController {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long bookingId);
    List<Booking> getBookingsByCustomerId(Long customerId);
    List<Booking> getBookingsByTrainTripId(Long trainTripId);
    Booking updateBooking(Long bookingId, Booking updatedBooking); // تغيير النوع المعاد
    void deleteBooking(Long bookingId);
}
