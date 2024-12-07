package com.example.Biblioteka.repository;

import com.example.Biblioteka.Employee;
import com.example.Biblioteka.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
