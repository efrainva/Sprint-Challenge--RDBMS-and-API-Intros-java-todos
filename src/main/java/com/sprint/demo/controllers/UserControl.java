package com.sprint.demo.controllers;


import com.sprint.demo.model.User;
import com.sprint.demo.model.UserRole;
import com.sprint.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControl {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users",produces = {"application/json"} )
            public ResponseEntity<?> listAllUsers(){
        List<User> myUser =  userService.findAll();
        return  new ResponseEntity<>(myUser, HttpStatus.OK);
    }

    @PostMapping(value = "/user/",consumes = {"application"}, produces ={"application/json"})
    public ResponseEntity <?> addNewUser(@Valid @RequestBody User newuser) throws URISyntaxException {
        newuser = userService.save(newuser);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand(newuser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);
        return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);


    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User updateUser, @PathVariable long id){
        userService.update(updateUser,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
