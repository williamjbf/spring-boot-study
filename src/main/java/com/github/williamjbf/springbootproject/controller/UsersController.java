package com.github.williamjbf.springbootproject.controller;

import com.github.williamjbf.springbootproject.model.Users;
import com.github.williamjbf.springbootproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository repository;

    @GetMapping(value = "listAll")
    @ResponseBody
    public ResponseEntity<List<Users>> listAllUsers(){
        List<Users> users = repository.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<Users> saveUser(@RequestBody Users users){

         Users user = repository.save(users);

         return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

}
