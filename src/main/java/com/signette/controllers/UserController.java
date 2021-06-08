package com.signette.controllers;

import com.signette.domains.UserEntity;
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
    public List<UserEntity> read(){
        return userService.findAll();
    }

    @GetMapping("/read/{id}")
    public UserEntity readById(@PathVariable int id){
        return userService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody UserEntity user){
        userService.add(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody UserEntity user){
        userService.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        UserEntity user = userService.findById(id);
        userService.delete(user);
    }


}
