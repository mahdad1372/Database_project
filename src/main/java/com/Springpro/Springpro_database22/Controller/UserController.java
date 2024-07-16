package com.Springpro.Springpro_database22.Controller;

import com.Springpro.Springpro_database22.Entity.User;
import com.Springpro.Springpro_database22.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Optional<User> getUserByName(@RequestParam(value = "id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/user")
    public void saveUserByName(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name){
        userService.saveUser(id, name);
    }
}