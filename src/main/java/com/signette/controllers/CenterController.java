package com.signette.controllers;

import com.signette.domains.Center;
import com.signette.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/center")
public class CenterController {

    @Autowired
    CenterService centerService;

    @GetMapping("/read")
    public ResponseEntity<Map<String, Object>> read(@RequestParam(required = false) String searchName,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "3") int size) {
        try {
            List<Center> centers;
            Pageable paging = PageRequest.of(page, size);

            Page<Center> pageCenter;
            if (searchName == null)
                pageCenter = centerService.findAll(paging);
            else
                pageCenter = centerService.findByCenterName(searchName, paging);

            centers = pageCenter.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("centers", centers);
            response.put("currentPage", pageCenter.getNumber());
            response.put("totalItems", pageCenter.getTotalElements());
            response.put("totalPages", pageCenter.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read/{id}")
    public Center readById(@PathVariable long id) {
        return centerService.findById(id);
    }

    //@GetMapping("/read/search/{centerName}")
    // public List<Center> readByName(@PathVariable String centerName) {
    //     return centerService.findByCenterName(centerName);
    // }

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
