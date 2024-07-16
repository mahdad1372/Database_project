package com.Springpro.Springpro_database22.Controller;

import com.Springpro.Springpro_database22.Entity.User;
import com.Springpro.Springpro_database22.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private MongoTemplate mongoTemplate;
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{name}")
    public List<User> getUserByName(@PathVariable("name") String name){
        System.out.println(name);
        return userService.getUserwithname(name);
    }
//    @GetMapping("/userwithname")
//    public void getUserByNamesss(@RequestParam(value = "name") String name){
//        System.out.println(name);
//
//   return userService.getUserwithname(name);
//    }
    @GetMapping("/user/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    @DeleteMapping("/user")
    public void deleteUserById(@RequestParam(value = "id") Long id){
        userService.deleteUserById(id);
    }

    @PostMapping("/user")
    public void saveUserByName(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name){
        userService.saveUser(id, name);
    }



}