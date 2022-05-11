package com.kcbgroup.main.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserJPAController {

    private  UserDaoService service;


    private  UserRepository userRepository;


    public UserJPAController(UserDaoService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }


    @GetMapping("/jpa/users/")
    public List<User> returnAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping(value = "/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id-" + id);
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkToUser = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(this.getClass())
                        .returnAllUsers());
        entityModel.add(linkToUser.withRel("all-users"));
        return entityModel;
    }

    @RequestMapping(value = "/jpa/users/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/delete/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if (user == null){
            throw new UserNotFoundException("id-" + id);
        }

    }

}
