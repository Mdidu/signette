package com.signette.controllers;

import com.signette.domains.*;
import com.signette.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/read")
    public List<Post> read() {
        return postService.findAll();
    }

    @GetMapping("/read/trip/{tripId}/user/{userId}")
    public Post readByTripAndUser(@PathVariable long tripId, @PathVariable long userId) {
        return postService.findByTripIdAndUserId(tripId, userId);
    }

    @GetMapping("/readBytrip/{tripId}")
    public List<PostByUser> readByTrip(@PathVariable long tripId) {
        List<Object[]> objects = postService.findByTripId(tripId);
        List<PostByUser> postByUsers = new ArrayList<>();

        objects.forEach((obj) -> {
            PostByUser post = new PostByUser();
            post.setTripId((BigInteger) obj[0]);
            post.setUserId((BigInteger) obj[1]);
            post.setPostId((BigInteger) obj[2]);
            post.setPostName((String) obj[3]);
            post.setUserLastname((String) obj[4]);
            post.setNameUser((String) obj[5]);
            post.setUserPhone((String) obj[6]);
            postByUsers.add(post);
        });
        return postByUsers;
    }

    @GetMapping("/read/user/{userId}")
    public List<Post> readByUser(@PathVariable long userId) {
        return postService.findByUserId(userId);
    }

    @PostMapping("/add")
    public void add(@RequestBody Post post) {
        postService.add(post);
    }

    @PutMapping("/updatetrip/{id}/user/{userid}")
    public void updateByTripAndUser(@PathVariable long id,@PathVariable long userid, @RequestBody Post post) {
        post.setId(post.setId(new PostPK(id,userid)));
        postService.update(post);
    }

    @DeleteMapping("/deletetrip/{tripId}/user/{userId}")
    public void deleteByTripAndUser(@PathVariable long tripId, @PathVariable long userId) {
        postService.delete(postService.findByTripIdAndUserId(tripId,userId));
    }

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
            trip.setUserLastname((String) obj[2]);
            trip.setNameUser((String) obj[3]);
            listTripByCenters.add(trip);
        }

        return listTripByCenters;
    }

    @GetMapping("/readDate/id/{id}")
    public List<PostUser> readByDateAndUserId(@PathVariable long id) {
        Date date = new Date();
        List<Object[]> listObject = postService.findByPostUser(date, id);
        List<PostUser> listPostUsers = new ArrayList<>();

        for(Object[] obj : listObject) {
            PostUser postUser = new PostUser((BigInteger) obj[0], (BigInteger) obj[1], (String) obj[2], (String) obj[3], (String) obj[4], (Date) obj[5]);
            listPostUsers.add(postUser);
        }
        return listPostUsers;
    }

    @GetMapping("/readByPost/{id}")
    public List<PostUser> readByPostAndUserId(@PathVariable long id) {
        List<Object[]> listObject = postService.findByPost(id);
        List<PostUser> listPostUsers = new ArrayList<>();

        for(Object[] obj : listObject) {
            PostUser postUser = new PostUser((BigInteger) obj[0], (BigInteger) obj[1], (String) obj[2], (String) obj[3], (String) obj[4], (Date) obj[5]);
            listPostUsers.add(postUser);
        }

        return listPostUsers;
    }
}
