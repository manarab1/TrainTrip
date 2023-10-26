package com.example.TrainTrip.Entity;

import jakarta.persistence.*;
@Entity
public class TrainTrip {
    @Id
    private Long id;

    private String destination;
    private String departureTime;
    private int availableSeats;

    public TrainTrip(String destination, String departureTime, int availableSeats) {
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
    }


    public Long getTrainTripId() {
        return id;
    }

    public void setTrainTripId(Long trainTripId) {
        this.id = trainTripId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    }

