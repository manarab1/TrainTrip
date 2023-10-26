package com.example.TrainTrip.Service.impl;
import com.example.TrainTrip.Entity.Booking;
import com.example.TrainTrip.Repository.BookingRepository;
import com.example.TrainTrip.Service.interfaces.BookingService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingRepository.findById(bookingId).orElse(null);
    }

    @Override
    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByUserId(customerId);
    }

    @Override
    public List<Booking> getBookingsByTrainTripId(Long trainTripId) {
        return bookingRepository.findByTrainTripId(trainTripId);
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(bookingId).orElse(null);
        if (existingBooking != null) {
            bookingRepository.save(updatedBooking);
        }
        return existingBooking;
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
