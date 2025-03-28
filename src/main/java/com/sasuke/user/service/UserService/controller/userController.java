package com.sasuke.user.service.UserService.controller;

import com.sasuke.user.service.UserService.service.UserService;
import com.sasuke.user.service.UserService.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user){
       return userService.saveUser(user);
    }

    @GetMapping("/getuse/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable ObjectId userId){
       return userService.findUserById(userId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUsers(){
        return userService.getAllUser();
    }


}
