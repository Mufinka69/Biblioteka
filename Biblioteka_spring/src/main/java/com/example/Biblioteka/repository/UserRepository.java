package com.example.Biblioteka.repository;

import com.example.Biblioteka.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhoneNumber(String phoneNumber);
    User findByEmail(String email);
    User findByLogin(String login);
}
