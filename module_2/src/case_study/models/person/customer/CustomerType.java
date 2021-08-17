package case_study.models.person.customer;

public class CustomerType {
    private String customerTypeName;

    public CustomerType() {
    }

    public CustomerType(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    @Override
    public String toString() {
        return customerTypeName;
    }
}
