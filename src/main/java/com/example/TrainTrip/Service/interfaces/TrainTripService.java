package com.example.TrainTrip.Service.interfaces;

import com.example.TrainTrip.Entity.TrainTrip;

import java.util.List;

public interface TrainTripService {
    List<TrainTrip> getAllTrainTrips();
    TrainTrip getTrainTripById(Long tripId);
    TrainTrip createTrainTrip(TrainTrip trainTrip);
    TrainTrip updateTrainTrip(Long tripId, TrainTrip trainTrip);

    void updateTrainTrip(int tripId, TrainTrip updatedTrainTrip);

    void deleteTrainTrip(Long tripId);
}
