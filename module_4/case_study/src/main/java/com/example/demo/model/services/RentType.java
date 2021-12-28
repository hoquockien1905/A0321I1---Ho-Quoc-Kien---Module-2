package com.example.demo.model.services;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Integer rentTypeId;

    @Column(name = "rent_type_name", columnDefinition = "VARCHAR(45)")
    private String rentTypeName;

    @Column(name = "rent_type_cost")
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> serviceSet;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, Double rentTypeCost, Set<Service> serviceSet) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.serviceSet = serviceSet;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }
}
