package com.example.TrainTrip.Repository;
import com.example.TrainTrip.Entity.TrainTrip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainTripRepository extends JpaRepository<TrainTrip, Long> {
}
