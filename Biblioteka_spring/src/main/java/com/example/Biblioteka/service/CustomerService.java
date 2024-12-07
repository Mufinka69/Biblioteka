package com.example.Biblioteka.service;

import com.example.Biblioteka.Customer;
import com.example.Biblioteka.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
