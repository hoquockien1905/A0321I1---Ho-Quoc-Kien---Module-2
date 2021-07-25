package case_study.models.person.customer;

import case_study.models.person.Person;

public class Customer extends Person {
    private String idCustomer;
    protected CustomerType customerType;
    private String address;

    public Customer() {
    }

    public Customer(String idCustomer, CustomerType customerType, String address) {
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String fullName, String dateOfBirth, boolean gender, String idCode, String phone, String email, String idCustomer, CustomerType customerType, String address) {
        super(fullName, dateOfBirth, gender, idCode, phone, email);
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.address = address;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
