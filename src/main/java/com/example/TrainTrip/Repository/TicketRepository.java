package com.example.TrainTrip.Repository;
import com.example.TrainTrip.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
