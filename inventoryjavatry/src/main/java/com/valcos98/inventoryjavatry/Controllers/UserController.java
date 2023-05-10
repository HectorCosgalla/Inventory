package com.valcos98.inventoryjavatry.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.valcos98.inventoryjavatry.Entities.UserTable;
import com.valcos98.inventoryjavatry.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository; 
    }

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<UserTable> getUsers(){
        return (List<UserTable>) userRepository.findAll();
    }

    @PostMapping("/users")
    public void postUser(@RequestBody UserTable user){
        userRepository.save(user);
    }

}
