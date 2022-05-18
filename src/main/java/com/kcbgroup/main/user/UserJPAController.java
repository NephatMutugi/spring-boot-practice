package com.kcbgroup.main.user;

import com.kcbgroup.main.posts.Post;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAController {

    // private final UserDaoService service;
    private final UserRepository userRepository;

    public UserJPAController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users/")
    public List<User> returnAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping(value = "/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new UserNotFoundException("id-" + id);

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder linkToUser = WebMvcLinkBuilder
                .linkTo(methodOn(this.getClass())
                        .returnAllUsers());
        entityModel.add(linkToUser.withRel("all-users"));
        return entityModel;
    }

    @PostMapping(value = "/jpa/users/", consumes = "application/json")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        System.out.println("Created Successfully ");
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/delete/{id}")
    public String deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return "Deleted Successfully";
    }


    // Get a specific user's posts
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> returnUserPosts(@PathVariable int id){
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()){
            throw new UserNotFoundException("id-" + id);
        }

        return userOptional.get().getPosts();
    }

}
