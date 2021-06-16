package com.signette.controllers;

import com.signette.domains.TripByCenter;
import com.signette.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    // Recover center name + nbTrip of employee by center
    @GetMapping("/readTripByCenter/{id}")
    public List<TripByCenter> findByTrip(@PathVariable long id) {
        List<Object[]> listObject = postService.findByTripByCenter(id);
        List<TripByCenter> listTripByCenters = new ArrayList<>();
        // Convert object List n TripByCenter List
        for(Object[] obj : listObject) {
            TripByCenter trip = new TripByCenter();
            trip.setNbTrip((BigInteger) obj[0]);
            trip.setCenterName((String) obj[1]);
            trip.setUserLasname((String) obj[2]);
            trip.setNameUser((String) obj[3]);
            listTripByCenters.add(trip);
        }

        return listTripByCenters;
    }
}
