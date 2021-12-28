package com.example.demo.model.customer;

import com.example.demo.model.contract.Contract;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name", columnDefinition = "VARCHAR(45)")
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    private Date customerBirthday;

    @Column(name = "customer_gender")
    private Boolean customerGender;

    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(45)")
    private String customerIdCard;

    @Column(name = "customer_phone", columnDefinition = "VARCHAR(45)")
    private String customerPhone;

    @Column(name = "customer_email", columnDefinition = "VARCHAR(45)")
    private String customerEmail;

    @Column(name = "customer_address", columnDefinition = "VARCHAR(45)")
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, Date customerBirthday, Boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, CustomerType customerType, Set<Contract> contractSet) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
        this.contractSet = contractSet;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
