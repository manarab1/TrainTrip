package com.example.TrainTrip.Entity;

import jakarta.persistence.Entity;

@Entity
public class EconomyTicket extends Ticket {
    private String baggageStorageInfo;
    private String freeMeal;

    public EconomyTicket(Long ticketId, Booking booking, Customer customer) {
        super(ticketId, booking, customer);
    }

    public String getBaggageStorageInfo() {
        return baggageStorageInfo;
    }

    public void setBaggageStorageInfo(String baggageStorageInfo) {
        this.baggageStorageInfo = baggageStorageInfo;
    }

    public String getFreeMeal() {
        return freeMeal;
    }

    public void setFreeMeal(String freeMeal) {
        this.freeMeal = freeMeal;
    }
}
