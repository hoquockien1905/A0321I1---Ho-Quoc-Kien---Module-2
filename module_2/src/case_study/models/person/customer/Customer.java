package case_study.models.person.customer;

import case_study.models.person.Person;

public class Customer extends Person {
    private static int autoId = 1;
    private String idCustomer = "CTM00";
    protected CustomerType customerType;
    private String address;

    public Customer() {
    }

    public Customer(CustomerType customerType, String address) {
        this.idCustomer = idCustomer + Customer.autoId++;
        if (Customer.autoId > 9 && Customer.autoId < 100) {
            this.idCustomer = "CTM0" + Customer.autoId++;
        }
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String idCode, String fullName, String dateOfBirth, String gender, String phone, String email, CustomerType customerType, String address) {
        super(idCode, fullName, dateOfBirth, gender, phone, email);
        this.idCustomer = idCustomer + Customer.autoId++;
        if (Customer.autoId > 9 && Customer.autoId < 100) {
            this.idCustomer = "CTM0" + Customer.autoId++;
        }
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

    @Override
    public String toString() {
        return "Customer{" +
                "ID Customer: " + idCustomer +
                ", " +
                super.toString() +
                ", Customer type: " + customerType +
                ", Address: " + address +
                "}";
    }
}
