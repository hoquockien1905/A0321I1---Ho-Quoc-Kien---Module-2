//package com.example.demo.model;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "role")
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id")
//    private Integer roleId;
//
//    @Column(name = "role_name", columnDefinition = "VARCHAR(45)")
//    private String roleName;
//
//    @OneToMany(mappedBy = "role")
//    private List<UserRole> userRoleSet;
//}
