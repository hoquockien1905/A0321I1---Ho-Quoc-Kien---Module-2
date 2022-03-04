package codegym.project.demo.demo.model;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    @ManyToOne(targetEntity = Division.class)
    private Division division;

    public Employee() {
    }

    public Employee(Long id, String name, String email, String phone, Division division) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.division = division;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
