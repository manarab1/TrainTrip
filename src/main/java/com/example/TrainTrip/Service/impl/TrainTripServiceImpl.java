package com.example.TrainTrip.Service.impl;

import com.example.TrainTrip.Entity.TrainTrip;
import com.example.TrainTrip.Repository.TrainTripRepository;
import com.example.TrainTrip.Service.interfaces.TrainTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainTripServiceImpl implements TrainTripService {
    private final TrainTripRepository trainTripRepository;

    @Autowired
    public TrainTripServiceImpl(TrainTripRepository trainTripRepository) {
        this.trainTripRepository = trainTripRepository;
    }

    @Override
    public List<TrainTrip> getAllTrainTrips() {
        return trainTripRepository.findAll();
    }

    @Override
    public TrainTrip getTrainTripById(Long tripId) {
        return trainTripRepository.findById(tripId).orElse(null);
    }

    @Override
    public TrainTrip createTrainTrip(TrainTrip trainTrip) {
        return trainTripRepository.save(trainTrip);
    }

    @Override
    public TrainTrip updateTrainTrip(Long tripId, TrainTrip trainTrip) {
        return null;
    }

    @Override
    public void updateTrainTrip(int id, TrainTrip trainTrip) {

    }

    @Override
    public void deleteTrainTrip(Long tripId) {
        trainTripRepository.deleteById(tripId);
    }
}
