package com.signette.controllers;

import com.signette.domains.DocumentTypeEntity;
import com.signette.domains.TripEntity;
import com.signette.service.DocumentTypeService;
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
    public List<TripEntity> read() {
        return tripService.findAll();
    }

    @GetMapping("/read/{id}")
    public TripEntity readById(@PathVariable int id) {
        return tripService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody TripEntity tripEntity) {
        tripService.add(tripEntity);
    }

    @PutMapping("/update")
    public void update(@RequestBody TripEntity tripEntity) {
        tripService.update(tripEntity);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        tripService.delete(tripService.findById(id));
    }
}
