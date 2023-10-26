package com.example.TrainTrip.Entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;

    @OneToOne(mappedBy = "customer")
    private Ticket ticket;

    @ManyToMany
    @JoinTable(
            name = "customer_traintrip",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "traintrip_id")
    )
   private List<TrainTrip> trainTrips;

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setCustomerId(Long customerId) {
        this.id = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<TrainTrip> getTrainTrips() {
        return trainTrips;
    }

    public void setTrainTrips(List<TrainTrip> trainTrips) {
        this.trainTrips = trainTrips;
    }
}