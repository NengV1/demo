package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping(value = "/all")
    public List<User> getProduct(){
        return repo.findAll();
    }

    @GetMapping(value ="/{name}")
    public User findByName(@PathVariable final String name){
        return repo.findByName(name);
    }


    @PostMapping(value = "/load")
    public User load(@RequestBody final User product){
        repo.save(product);
        return repo.findByName(product.getName());

    }

}

