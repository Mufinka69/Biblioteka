package com.example.Biblioteka.service;

import com.example.Biblioteka.Employee;
import com.example.Biblioteka.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public List<Employee> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeesRepository.save(employee);
    }
}
