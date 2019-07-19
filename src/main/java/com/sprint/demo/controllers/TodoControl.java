package com.sprint.demo.controllers;

import com.sprint.demo.model.Todo;
import com.sprint.demo.services.TodoService;
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
    private TodoService todoService;

    @GetMapping(value = "/todo",produces = {"application/json"} )
    public ResponseEntity<?> listAllTodo(){
        List<Todo> todo =  todoService.findAll();
        return  new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping(value = "/todo/",consumes = {"application"}, produces ={"application/json"})
    public ResponseEntity <?> addNewTodo(@Valid @RequestBody Todo newtodo) throws URISyntaxException {
        newtodo = todoService.save(newtodo);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{todoid}")
                .buildAndExpand(newtodo.getTodoid())
                .toUri();
        responseHeaders.setLocation(newUserURI);
        return new ResponseEntity<>(null, responseHeaders,HttpStatus.CREATED);


    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo, @PathVariable long id){
        todoService.update(updateTodo,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<?> deleteTodoById(@PathVariable long id)
    {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
