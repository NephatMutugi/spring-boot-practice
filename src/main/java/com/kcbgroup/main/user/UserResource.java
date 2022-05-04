package com.kcbgroup.main.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users/")
    public List<User> returnAllUsers(){
        return service.findAll();
    }

    @GetMapping(value = "/users/{id}", consumes = "application/json")
    public User retrieveUser(@PathVariable int id) {
    	User user = service.findOne(id);
        if (user == null){
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @RequestMapping(value = "/users/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
