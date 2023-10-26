package com.example.TrainTrip.Repository;
import com.example.TrainTrip.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long customerId);

    List<Booking> findByTrainTripId(Long trainTripId);
}
