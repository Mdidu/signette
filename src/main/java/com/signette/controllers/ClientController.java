package com.signette.controllers;

import com.signette.domains.Client;
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
    public List<Client> read(){
        return clientService.findAll();
    }

    @GetMapping("/read/{id}")
    public Client readById(@PathVariable long id){
        return clientService.findById(id);
    }

    @GetMapping("read/name/{name}")
    public List<Client> readByName(@PathVariable String name){
        System.out.println(name);
        return clientService.findClientByClientWording(name);
    }

    @PostMapping("/add")
    public void add(@RequestBody Client client){
        clientService.add(client);
    }

    @PutMapping("/update")
    public void update(@RequestBody Client client){
        System.out.println(client.toString());
        clientService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        Client client = clientService.findById(id);
        clientService.delete(client);
    }
}
