package com.example.Biblioteka.controller;


import com.example.Biblioteka.Book;
import com.example.Biblioteka.DTO.BookDTO;
import com.example.Biblioteka.DTO.EmployeeDTO;
import com.example.Biblioteka.Employee;
import com.example.Biblioteka.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("EmployeesPanel")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("./employees")
    public String getEmployees(Model model){
        List<Employee> books = employeeService.getAllEmployees();
        model.addAttribute("employees", books);
        return "employees";
    }

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/addEmployees")
    public Employee addEmployees(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setUserID(employeeDTO.getUserID());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setJobID(employeeDTO.getJobID());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setEndDate(employeeDTO.getEndDate());
        return employeeService.addEmployee(employee);
    }
}
