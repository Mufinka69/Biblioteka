package com.example.Biblioteka.service;
import com.example.Biblioteka.Book;
import com.example.Biblioteka.User;
import com.example.Biblioteka.exception.BookNotFoundException;
import com.example.Biblioteka.exception.UserNotFoundException;
import com.example.Biblioteka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    public User findByID(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public User findByPhoneNumber(String phoneNumber){
        return userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new UserNotFoundException("User with phone number " + phoneNumber + " not found."));
    }


}




