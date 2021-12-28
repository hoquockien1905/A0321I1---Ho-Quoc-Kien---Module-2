package com.example.demo.model.services;

import com.example.demo.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "service_name", columnDefinition = "VARCHAR(45)")
    private String serviceName;

    @Column(name = "service_area")
    private Integer serviceArea;

    @Column(name = "service_cost")
    private Double serviceCost;

    @Column(name = "service_max_people")
    private Integer serviceMaxPeople;

    @Column(name = "standard_room", columnDefinition = "VARCHAR(45)")
    private String standardRoom;

    @Column(name = "description_other_convenience", columnDefinition = "VARCHAR(45)")
    private String descriptionOtherConvenience;

    @Column(name = "pool_area")
    private Double poolArea;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false, referencedColumnName = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", nullable = false, referencedColumnName = "service_type_id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contractSet;

    public Service() {
    }

    public Service(Integer serviceId, String serviceName, Integer serviceArea, Double serviceCost, Integer serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, Double poolArea, Integer numberOfFloors, RentType rentType, ServiceType serviceType, Set<Contract> contractSet) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.contractSet = contractSet;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(Integer serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
