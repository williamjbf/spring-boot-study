package com.github.williamjbf.springbootproject.controller;

import com.github.williamjbf.springbootproject.model.Users;
import com.github.williamjbf.springbootproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
