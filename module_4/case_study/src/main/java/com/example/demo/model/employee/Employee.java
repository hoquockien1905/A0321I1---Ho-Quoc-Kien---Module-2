package com.example.demo.model.employee;

import com.example.demo.model.contract.Contract;
import com.example.demo.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", columnDefinition = "VARCHAR(45)")
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    private Date employeeBirthday;

    @Column(name = "employee_id_card", columnDefinition = "VARCHAR(45)")
    private String employeeIdCard;

    @Column(name = "employee_salary")
    private Double employeeSalary;

    @Column(name = "employee_phone", columnDefinition = "VARCHAR(45)")
    private String employeePhone;

    @Column(name = "employee_email", columnDefinition = "VARCHAR(45)")
    private String employeeEmail;

    @Column(name = "employee_address", columnDefinition = "VARCHAR(45)")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false, referencedColumnName = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false, referencedColumnName = "division_id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", nullable = false, referencedColumnName = "education_degree_id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false, referencedColumnName = "username")
    private User username;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet;

    public Employee() {
    }

}
