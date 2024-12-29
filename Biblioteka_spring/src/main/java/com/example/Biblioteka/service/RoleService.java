package com.example.Biblioteka.service;

import com.example.Biblioteka.Book;
import com.example.Biblioteka.Role;
import com.example.Biblioteka.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role addRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteRole(Long RoleID){
        roleRepository.deleteById(RoleID);
    }

    public Role findByID(Long id){
        return roleRepository.findById(id).orElseThrow();
    }

}
