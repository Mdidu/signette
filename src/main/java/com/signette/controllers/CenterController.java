package com.signette.controllers;

import com.signette.domains.Center;
import com.signette.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/center")
public class CenterController {

    @Autowired
    CenterService centerService;

    @GetMapping("/read")
    public List<Center> read() {
        return centerService.findAll();
    }

    @GetMapping("/read/{id}")
    public Center readById(@PathVariable long id) {
        return centerService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Center center) {
        centerService.add(center);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id, @RequestBody Center center) {
        center.setCenterId(id);
        centerService.update(center);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        centerService.delete(centerService.findById(id));
    }
}
