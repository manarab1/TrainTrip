package com.example.TrainTrip.Controller.interfaces;

import com.example.TrainTrip.Entity.Ticket;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketController {
    ResponseEntity<Ticket> getTicketById(Long ticketId);
    ResponseEntity<List<Ticket>> getAllTickets();
    ResponseEntity<Ticket> createTicket(Ticket ticket);
   // ResponseEntity<Ticket> updateTicket(Long ticketId, Ticket ticket);
  // ResponseEntity<Void> deleteTicket(Long ticketId);

}
