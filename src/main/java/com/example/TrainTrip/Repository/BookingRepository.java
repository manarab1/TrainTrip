package com.example.TrainTrip.Repository;
import com.example.TrainTrip.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
