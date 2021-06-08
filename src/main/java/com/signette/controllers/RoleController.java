package com.signette.controllers;

import com.signette.domains.RoleEntity;
import com.signette.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/read")
    public List<RoleEntity> read(){
        return roleService.findAll();
    }

    @GetMapping("/read/{id}")
    public RoleEntity readById(@PathVariable int id){
        return roleService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody RoleEntity role){
        roleService.add(role);
    }

    @PutMapping("/update")
    public void update(@RequestBody RoleEntity role){
        roleService.update(role);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        RoleEntity role = roleService.findById(id);
        roleService.delete(role);
    }
}
