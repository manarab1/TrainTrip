package com.example.TrainTrip.Entity;

import jakarta.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Ticket(Long ticketId, Booking booking, Customer customer) {
        this.ticketId = ticketId;
        this.booking = booking;
        this.customer = customer;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
