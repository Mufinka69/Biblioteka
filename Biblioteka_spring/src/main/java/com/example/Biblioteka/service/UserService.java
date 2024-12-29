package com.example.Biblioteka.service;
import com.example.Biblioteka.Book;
import com.example.Biblioteka.User;
import com.example.Biblioteka.exception.BookNotFoundException;
import com.example.Biblioteka.exception.UserNotFoundException;
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

    public void deleteUser(Long userID){
        if(!userRepository.existsById(userID)){
            throw new UserNotFoundException("User with ID " + userID + " not found.");
        }
        userRepository.deleteById(userID);
    }

    public User findByID(Long id){
        return userRepository.findById(id).orElseThrow();
    }
}
