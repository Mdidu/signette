package com.signette.controllers;

import com.signette.domains.AdresseEntity;
import com.signette.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/adresse")
public class AdresseController {

    @Autowired
    AdresseService adresseService;

    @GetMapping("/read")
    public List<AdresseEntity> read(){
        return adresseService.findAll();
    }

    @GetMapping("/read/{id}")
    public AdresseService readById(@PathVariable int id){
        return (AdresseService) adresseService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody AdresseEntity adresse){
        adresseService.add(adresse);
    }

    @PutMapping("/update")
    public void update(@RequestBody AdresseEntity client){
        adresseService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        AdresseEntity adresse = adresseService.findById(id);
        adresseService.delete(adresse);
    }
}
