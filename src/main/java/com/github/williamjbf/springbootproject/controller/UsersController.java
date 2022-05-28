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

    @GetMapping(value = "findById")
    @ResponseBody
    public ResponseEntity<Users> findUserById(@RequestParam(name = "idUser") Long idUser){
        Users user = repository.findById(idUser).get();

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping(value = "findByName")
    @ResponseBody
    public ResponseEntity<List<Users>> findUserByName(@RequestParam(name = "name") String name){
        List<Users> users = repository.findByName(name.trim().toUpperCase());

        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping(value = "save")
    @ResponseBody
    public ResponseEntity<Users> saveUser(@RequestBody Users users){

         Users user = repository.save(users);

         return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @PutMapping(value = "update")
    @ResponseBody
    public ResponseEntity<?> updateUser(@RequestBody Users users){

        Users user = repository.saveAndFlush(users);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String > deleteUser(@RequestParam(name = "idUser") Long idUser){

        repository.deleteById(idUser);

        return new ResponseEntity<String>("user successfully deleted ",HttpStatus.OK);
    }


}
