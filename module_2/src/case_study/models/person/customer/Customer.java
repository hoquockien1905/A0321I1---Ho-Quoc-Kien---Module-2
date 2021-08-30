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
        if (Customer.autoId >= 10 && Customer.autoId < 100) {
            this.idCustomer = "CTM0" + Customer.autoId++;
        } else {
            this.idCustomer = idCustomer + Customer.autoId++;
        }
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(String idCode, String fullName, String dateOfBirth, String gender, String phone, String email, CustomerType customerType, String address) {
        super(idCode, fullName, dateOfBirth, gender, phone, email);
        if (Customer.autoId >= 10 && Customer.autoId < 100) {
            this.idCustomer = "CTM0" + Customer.autoId++;
        } else {
            this.idCustomer = idCustomer + Customer.autoId++;
        }
        this.customerType = customerType;
        this.address = address;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Customer.autoId = autoId;
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

    public void parse(String line) {
        String[] params = line.split(",");
        try {
            idCustomer = params[0];
            fullName = params[1];
            dateOfBirth = params[2];
            gender = params[3];
            idCode = params[4];
            phone = params[5];
            email = params[6];
            customerType = new CustomerType(params[7]);
            address = params[8];
        } catch (ArrayIndexOutOfBoundsException e){
        }
    }

    public String getFileLine() {
        return idCustomer + "," + fullName +
                "," + dateOfBirth + "," + gender +
                "," + idCode + "," + phone +
                "," + email + "," + customerType +
                "," + address + "\n";
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
