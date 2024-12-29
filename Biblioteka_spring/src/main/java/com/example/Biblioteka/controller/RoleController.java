package com.example.Biblioteka.controller;

import com.example.Biblioteka.DTO.RoleDTO;
import com.example.Biblioteka.Role;
import com.example.Biblioteka.User;
import com.example.Biblioteka.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rolePanel")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("./roles")
    public String getRoles(Model model){
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "roles";
    }

    @GetMapping("roles")
    public List<Role> getRoles(){
        return roleService.getAllRoles();
    }

    @PostMapping("/addRole")
    public Role addRole(@RequestBody RoleDTO roleDTO){
        Role role = new Role();
        role.setRoleID(roleDTO.getRoleID());
        role.setRoleName(roleDTO.getRoleName());
        return roleService.addRole(role);
    }

    @DeleteMapping("/role/{loanID}")
    public List<Role> deleteRole(@PathVariable Long roleID) {
        roleService.deleteRole(roleID);
        return roleService.getAllRoles();
    }

}
