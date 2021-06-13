package com.signette.controllers;

import com.signette.domains.Trip;
import com.signette.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
