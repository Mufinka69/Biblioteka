package com.example.Biblioteka.service;
import com.example.Biblioteka.Book;
import com.example.Biblioteka.User;
import com.example.Biblioteka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User findByID(Long id){
        return userRepository.findById(id).orElseThrow();
    }
}
