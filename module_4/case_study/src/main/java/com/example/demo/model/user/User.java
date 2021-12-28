package com.example.demo.model.user;

import com.example.demo.model.employee.Employee;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "`user`")
public class User {
    @Id
    @Column(name = "username", columnDefinition = "VARCHAR(255)")
    private String username;

    @Column(name = "`password`", columnDefinition = "VARCHAR(255)")
    private String password;

    @OneToMany(mappedBy = "username")
    private Set<Employee> employeeSet;

    @OneToMany(mappedBy = "username")
    private Set<UserRole> userRoleSet;

    public User() {
    }

    public User(String username, String password, Set<Employee> employeeSet, Set<UserRole> userRoleSet) {
        this.username = username;
        this.password = password;
        this.employeeSet = employeeSet;
        this.userRoleSet = userRoleSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<UserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<UserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
}
