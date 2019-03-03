package com.temple.authserver.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User> listUser(){
        return userService.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user){
        return userService.save(user);
    }

}
