package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoleList;

    public Role() {
    }

    public Role(Integer roleId, String name, List<UserRole> userRoleList) {
        this.roleId = roleId;
        this.name = name;
        this.userRoleList = userRoleList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRole> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }
}
