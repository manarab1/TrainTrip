package com.example.TrainTrip.Service.impl;
import com.example.TrainTrip.Entity.Ticket;
import com.example.TrainTrip.Repository.TicketRepository;
import com.example.TrainTrip.Service.interfaces.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Ticket getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Long ticketId, Ticket ticket) {
        if (ticketRepository.existsById(ticketId)) {
            ticket.setTicketId(ticketId);
            return ticketRepository.save(ticket);
        }
        return null;
    }

    @Override
    public void deleteTicket(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
