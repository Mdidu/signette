package com.signette.controllers;

import com.signette.domains.Role;
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
    public List<Role> read(){
        return roleService.findAll();
    }

    @GetMapping("/read/{id}")
    public Role readById(@PathVariable long id){
        return roleService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Role role){
        roleService.add(role);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id, @RequestBody Role role){
        role.setRoleId(id);
        roleService.update(role);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        Role role = roleService.findById(id);
        roleService.delete(role);
    }
}
