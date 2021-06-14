package com.signette.controllers;

import com.signette.domains.PostType;
import com.signette.service.PostTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PostTypeController {

    @Autowired
    PostTypeService postTypeService;

    @GetMapping("/read")
    public List<PostType> read() {
        return postTypeService.findAll();
    }

    @GetMapping("/read/{id}")
    public PostType readById(@PathVariable long id) {
        return postTypeService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody PostType postType) {
        postTypeService.add(postType);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id, @RequestBody PostType postType) {
        postType.setPostId(id);
        postTypeService.update(postType);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        postTypeService.delete(postTypeService.findById(id));
    }
}
