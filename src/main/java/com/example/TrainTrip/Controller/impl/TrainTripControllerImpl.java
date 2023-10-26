package com.example.TrainTrip.Controller.impl;

import com.example.TrainTrip.Controller.interfaces.TrainTripController;
import com.example.TrainTrip.Entity.TrainTrip;
import com.example.TrainTrip.Service.interfaces.TrainTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traintrips")
public class TrainTripControllerImpl implements TrainTripController {
    @Autowired
    private TrainTripService trainTripService;

    @GetMapping
    public List<TrainTrip> getAllTrainTrips() {
        return trainTripService.getAllTrainTrips();
    }

    @GetMapping("/{tripId}")
    public TrainTrip getTrainTripById(@PathVariable Long tripId) {
        return trainTripService.getTrainTripById(tripId);
    }

    @PostMapping
    public TrainTrip createTrainTrip(@RequestBody TrainTrip trainTrip) {
        return trainTripService.createTrainTrip(trainTrip);
    }

    @PutMapping("/{tripId}")
    public TrainTrip updateTrainTrip(@PathVariable Long tripId, @RequestBody TrainTrip trainTrip) {
        return trainTripService.updateTrainTrip(tripId, trainTrip);
    }

    @DeleteMapping("/{tripId}")
    public void deleteTrainTrip(@PathVariable Long tripId) {
        trainTripService.deleteTrainTrip(tripId);
    }
}
