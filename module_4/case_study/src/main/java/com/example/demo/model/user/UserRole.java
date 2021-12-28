package com.example.demo.model.user;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false, referencedColumnName = "username")
    private User username;

    public UserRole() {
    }

    public UserRole(Integer userRoleId, Role role, User username) {
        this.userRoleId = userRoleId;
        this.role = role;
        this.username = username;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
