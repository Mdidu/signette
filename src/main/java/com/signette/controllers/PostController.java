package com.signette.controllers;

import com.signette.domains.Post;
import com.signette.domains.PostPK;
import com.signette.domains.PostType;
import com.signette.service.PostService;
import com.signette.service.PostTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/read/trip/{tripId}")
    public List<Post> readByTrip(@PathVariable long tripId) {
        return postService.findByTripId(tripId);
    }

    @GetMapping("/read/user/{userId}")
    public List<Post> readByUser(@PathVariable long userId) {
        return postService.findByUserId(userId);
    }

    @PostMapping("/add")
    public void add(@RequestBody Post post) {
        postService.add(post);
    }

    @PutMapping("/update/trip/{id}/user/{userid}")
    public void updateByTripAndUser(@PathVariable long id,@PathVariable long userid, @RequestBody Post post) {
        post.setId(post.setId(new PostPK(id,userid)));
        postService.update(post);
    }

    @DeleteMapping("/delete/trip/{tripId}/user/{userid}")
    public void deleteByTripAndUser(@PathVariable long tripId, @PathVariable long userId) {
        postService.delete(postService.findByTripIdAndUserId(tripId,userId));
    }
}
