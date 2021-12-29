package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer userRoleId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
    private User user;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id", nullable = false, referencedColumnName = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRole(Integer userRoleId, User user, Role role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
