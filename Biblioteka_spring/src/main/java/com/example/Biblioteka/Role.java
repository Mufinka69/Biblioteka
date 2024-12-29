package com.example.Biblioteka;

import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleID;

    @Column
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<User> users;


    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
