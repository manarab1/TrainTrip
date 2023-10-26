package com.example.TrainTrip.Entity;

import jakarta.persistence.Entity;

@Entity
public class FirstClassTicket extends Ticket {
    private boolean complimentaryMeals;
    private boolean personalConcierge;
    private boolean luxuryLoungeAccess;

    public FirstClassTicket(Long ticketId, Booking booking, Customer customer) {
        super(ticketId, booking, customer);
    }



    public boolean isComplimentaryMeals() {
        return complimentaryMeals;
    }

    public void setComplimentaryMeals(boolean complimentaryMeals) {
        this.complimentaryMeals = complimentaryMeals;
    }

    public boolean isPersonalConcierge() {
        return personalConcierge;
    }

    public void setPersonalConcierge(boolean personalConcierge) {
        this.personalConcierge = personalConcierge;
    }

    public boolean isLuxuryLoungeAccess() {
        return luxuryLoungeAccess;
    }

    public void setLuxuryLoungeAccess(boolean luxuryLoungeAccess) {
        this.luxuryLoungeAccess = luxuryLoungeAccess;
    }
}
