package com.example.Biblioteka.controller;

import com.example.Biblioteka.DTO.UserDTO;
import com.example.Biblioteka.Role;
import com.example.Biblioteka.User;
import com.example.Biblioteka.service.RoleService;
import com.example.Biblioteka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userPanel")
public class UserController {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("./users")
    public String getUser(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


    @GetMapping("/phone/{phoneNumber}")
    public User getUserByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("users")
    public List<User> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());


        Role role = roleService.findByID(userDTO.getRoleID());
        user.setRole(role);

        return userService.addUser(user);
    }

    @DeleteMapping("/users/{userID}")
    public List<User> deleteUser(@PathVariable Long userID) {
        userService.deleteUser(userID);
        return userService.getAllUsers();
    }
}


