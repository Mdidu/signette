package com.signette.controllers;

import com.signette.domains.PostTypeEntity;
import com.signette.service.PostTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PostTypeController {

    @Autowired
    PostTypeService postTypeService;

    @GetMapping("/read")
    public List<PostTypeEntity> read() {
        return postTypeService.findAll();
    }

    @GetMapping("/read/{id}")
    public PostTypeEntity readById(@PathVariable int id) {
        return postTypeService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody PostTypeEntity postTypeEntity) {
        postTypeService.add(postTypeEntity);
    }

    @PutMapping("/update")
    public void update(@RequestBody PostTypeEntity postTypeEntity) {
        postTypeService.update(postTypeEntity);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        postTypeService.delete(postTypeService.findById(id));
    }
}
