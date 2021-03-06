/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.villovid07.rest.webservices.restfulwebservices.user;

import com.villovid07.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author villovid07
 */
@RestController
public class UserResource {
    
    @Autowired
    private UserDaoService service;
    
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    
    
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id ){
    
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id); 
        }
        return user;
       
    }
    
    
    
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user){
        User savedUser = service.save(user);
        //CREATED 
        // /user/{id}
        URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    } 
    
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id ){
    
        User user = service.deleteById(id);
        if(user == null){
            throw new UserNotFoundException("id-"+id); 
        }
       
    }
    
    
}
