package com.sprint.demo.controllers;

import com.sprint.demo.model.Todo;
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
@RequestMapping("/todo")
public class TodoControl {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/todo",produces = {"application/json"} )
    public ResponseEntity<?> listAllUsers(){
        List<Todo> todo =  userService.findAll();
        return  new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping(value = "/todo/",consumes = {"application"}, produces ={"application/json"})
    public ResponseEntity <?> addNewUser(@Valid @RequestBody Todo newuser) throws URISyntaxException {
        newuser = userService.save(newuser);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{todoid}")
                .buildAndExpand(newuser.getTodoById())
                .toUri();
        responseHeaders.setLocation(newUserURI);
        return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);


    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<?> updateUser(@RequestBody Todo updateUser, @PathVariable long id){
        userService.update(updateUser,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable long id)
    {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
