package com.signette.controllers;

import com.signette.domains.CenterEntity;
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
    public List<CenterEntity> read() {
        return centerService.findAll();
    }

    @GetMapping("/read/{id}")
    public CenterEntity readById(@PathVariable int id) {
        return centerService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CenterEntity centerEntity) {
        centerService.add(centerEntity);
    }

    @PutMapping("/update")
    public void update(@RequestBody CenterEntity centerEntity) {
        centerService.update(centerEntity);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        centerService.delete(centerService.findById(id));
    }
}
