package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotEmpty(message = "Không được để trống")
    @Size(min = 5, max = 45, message = "Size phải từ 5 đến 45 ký tự")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @Min(18)
    @NotNull(message = "Không để trống")
    private int age;

    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]*$)")
    private String phoneNumber;

    @NotEmpty
    @Email
    private String email;

    public User() {
    }

    public User(int id, @NotEmpty(message = "Không được để trống") @Size(min = 5, max = 45, message = "Size phải từ 5 đến 45 ký tự") String firstName, @NotEmpty @Size(min = 5, max = 45) String lastName, @Min(18) int age, @NotEmpty @Pattern(regexp = "(^$|[0-9]*$)") String phoneNumber, @NotEmpty @Email String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
