package com.signette.controllers;

import com.signette.domains.PostByUser;
import com.signette.domains.Trip;
import com.signette.domains.TripByCenter;
import com.signette.domains.TripEvent;
import com.signette.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/trip")
public class TripController {

    @Autowired
    TripService tripService;

    @GetMapping("/read")
    public List<Trip> read() {
        return tripService.findAll();
    }

    @GetMapping("/calendar")
    public List<TripEvent> calendar() {
        List<Trip> listTrip = tripService.findAll();
        List<TripEvent> listTripEvent = new ArrayList<>();
        listTrip.forEach((trip) -> {
            TripEvent tripEvent = new TripEvent();
            tripEvent.setId(""+trip.getTripId());
            tripEvent.setTitle(trip.getCenter().getCenterName()+" - "+trip.getClient().getClientWording());
            tripEvent.setStart(trip.getTripStartDate());
            tripEvent.setEnd(trip.getTripEndDate());
            listTripEvent.add(tripEvent);
        });
        return listTripEvent;

    }

    @GetMapping("/read/{id}")
    public Trip readById(@PathVariable long id) {
        return tripService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Trip trip) {
        tripService.add(trip);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id, @RequestBody Trip trip) {
        trip.setTripId(id);
        tripService.update(trip);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        tripService.delete(tripService.findById(id));
    }
}
