package com.example.Biblioteka.controller;

import com.example.Biblioteka.Customer;
import com.example.Biblioteka.DTO.CustomerDTO;
import com.example.Biblioteka.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("./customers")
    public String getCustomers(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("customers")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setUserID(customerDTO.getUserID());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());

        return customerService.addCustomer(customer);
    }



}
