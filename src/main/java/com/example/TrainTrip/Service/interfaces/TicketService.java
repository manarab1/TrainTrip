package com.example.TrainTrip.Service.interfaces;

import com.example.TrainTrip.Entity.Ticket;

import java.util.List;

public interface TicketService {
    Ticket getTicketById(Long ticketId);
    List<Ticket> getAllTickets();
    Ticket createTicket(Ticket ticket);
    Ticket updateTicket(Long ticketId, Ticket ticket);
    void deleteTicket(Long ticketId);
}
