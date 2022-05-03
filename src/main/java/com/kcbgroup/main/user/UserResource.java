package com.kcbgroup.main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    @GetMapping(path = "/users/")
    public List<User> returnAllUsers(){
        return service.findAll();
    }
    
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
    	return service.findOne(id);
    }

    @PostMapping("/users/")
    public void createUser(@RequestBody User user){
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        ResponseEntity.created(location);
    }

}
