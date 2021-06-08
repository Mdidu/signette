package com.signette.controllers;

import com.signette.domains.ClientEntity;
import com.signette.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/read")
    public List<ClientEntity> read(){
        return clientService.findAll();
    }

    @GetMapping("/read/{id}")
    public ClientEntity readById(@PathVariable int id){
        return clientService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody ClientEntity client){
        clientService.add(client);
    }

    @PutMapping("/update")
    public void update(@RequestBody ClientEntity client){
        clientService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        ClientEntity client = clientService.findById(id);
        clientService.delete(client);
    }
}
