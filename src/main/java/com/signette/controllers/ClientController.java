package com.signette.controllers;

import com.signette.domains.Center;
import com.signette.domains.Client;
import com.signette.domains.Trip;
import com.signette.service.ClientService;
import com.signette.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    TripService tripService;

    @GetMapping("/read")
    public ResponseEntity<Map<String, Object>> read(@RequestParam(required = false) String searchName,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "3") int size) {
        try {
            List<Client> clients;
            Pageable paging = PageRequest.of(page, size);

            Page<Client> pageClient;
            if (searchName == null)
                pageClient = clientService.findAll(paging);
            else
                pageClient = clientService.findByClientByClientWording(searchName, paging);

            clients = pageClient.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("clients", clients);
            response.put("currentPage", pageClient.getNumber());
            response.put("totalItems", pageClient.getTotalElements());
            response.put("totalPages", pageClient.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/read/{id}")
    public Client readById(@PathVariable long id){
        return clientService.findById(id);
    }

    /*@GetMapping("read/name/{name}")
    public List<Client> readByName(@PathVariable String name){
        System.out.println(name);
        return clientService.findClientByClientWording(name);
    }*/

    @GetMapping("read/trip/{id}")
    public List<Trip> searchTripByClient(@PathVariable long id){
        //System.out.println(tripService.findTripByClient(id));
        return tripService.findTripByClient(id);
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
