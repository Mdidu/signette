package com.signette.controllers;

import com.signette.domains.Address;
import com.signette.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/adresse")
public class AdresseController {

    @Autowired
    AddressService addressService;

    @GetMapping("/read")
    public List<Address> read(){
        return addressService.findAll();
    }

    @GetMapping("/read/{id}")
    public AddressService readById(@PathVariable long id){
        return (AddressService) addressService.findById(id);
    }

    @PostMapping("/add")
    public Address add(@RequestBody Address adresse){
        Address address = addressService.addAdresse(adresse);
        return address;
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id,@RequestBody Address address){
        address.setAddressId(id);
        addressService.update(address);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        Address adresse = addressService.findById(id);
        addressService.delete(adresse);
    }
}
