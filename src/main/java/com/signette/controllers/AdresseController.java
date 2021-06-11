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
    public AdresseEntity readById(@PathVariable int id){
        return adresseService.findById(id);
    }

    @PostMapping("/add")
    public AdresseEntity add(@RequestBody AdresseEntity adresse){
        System.out.println("1");
        AdresseEntity address = adresseService.addAdresse(adresse);
        System.out.println("2");
        System.out.println(address);
        return address;
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
