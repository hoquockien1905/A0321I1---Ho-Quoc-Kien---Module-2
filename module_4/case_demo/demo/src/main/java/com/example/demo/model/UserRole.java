//package com.example.demo.model;
//
//import org.springframework.context.annotation.Primary;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user_role")
//public class UserRole {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "user_role_id")
//    private Integer userRoleId;
//
//    @ManyToOne(targetEntity = User.class)
//    private User username;
//
//    @ManyToOne(targetEntity = Role.class)
//    private Role role;
//}
