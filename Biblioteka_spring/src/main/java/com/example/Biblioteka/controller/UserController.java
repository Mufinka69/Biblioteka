package com.example.Biblioteka.controller;

import com.example.Biblioteka.DTO.UserDTO;
import com.example.Biblioteka.User;
import com.example.Biblioteka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("UserPanel")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("./users")
    public String getBooks(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("users")
    public List<User> getBooks(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhone_number());
        return userService.addUser(user);
    }

}


