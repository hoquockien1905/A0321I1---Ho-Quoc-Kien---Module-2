package com.example.demo.model.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name", columnDefinition = "VARCHAR(255)")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoleSet;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Set<UserRole> userRoleSet) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userRoleSet = userRoleSet;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
