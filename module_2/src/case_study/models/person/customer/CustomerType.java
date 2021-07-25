package case_study.models.person.customer;

public class CustomerType {
    private String customerTypeName;
    private String idCustomerTypeName;

    public CustomerType() {
    }

    public CustomerType(String customerTypeName, String idCustomerTypeName) {
        this.customerTypeName = customerTypeName;
        this.idCustomerTypeName = idCustomerTypeName;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public String getIdCustomerTypeName() {
        return idCustomerTypeName;
    }

    public void setIdCustomerTypeName(String idCustomerTypeName) {
        this.idCustomerTypeName = idCustomerTypeName;
    }
}
