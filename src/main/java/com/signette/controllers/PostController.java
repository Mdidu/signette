package com.signette.controllers;

import com.signette.domains.*;
import com.signette.service.DocumentService;
import com.signette.service.PDFService;
import com.signette.service.PostService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
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
    @Autowired
    DocumentService documentService;
    @Autowired
    PDFService pdfService;

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
    public void add(@RequestBody Post post) throws JRException, FileNotFoundException {
        postService.add(post);
        String path = pdfService.exportReport(post.getId().getUserId(), post.getId().getTripId());
        documentService.add(postService.generateDocument(post, path));
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

    // Recover Trips of employee
    @GetMapping("/findTripByUser/{id}")
    public List<TripEvent> findByUserTrip(@PathVariable long id) {
        List<Object[]> listTrip = postService.findTripByUser(id);
        List<TripEvent> listTripEvent = new ArrayList<>();
        // Convert object List n TripByCenter List
        for(Object[] obj : listTrip) {
            TripEvent trip = new TripEvent();
            trip.setId(""+obj[0]);
            trip.setEnd((Date) obj[1]);
            trip.setStart((Date) obj[2]);
            trip.setTitle((String) obj[3] +" - "+ obj[4]);
            listTripEvent.add(trip);
        }
        System.out.println(listTripEvent);
        return listTripEvent;
    }

}
