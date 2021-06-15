package com.signette.controllers;

import com.signette.domains.User;
import com.signette.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/read")
    public List<User> read(){
        return userService.findAll();
    }

    @GetMapping("/read/{id}")
    public User readById(@PathVariable long id){
        return userService.findById(id);
    }

    @GetMapping("/read/lastname/{lastname}")
    public List<User> readByLastName(@PathVariable String lastname) { return userService.findByUserLastname(lastname); }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.add(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        System.out.println(user);
        userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        User user = userService.findById(id);
        userService.delete(user);
    }
}
