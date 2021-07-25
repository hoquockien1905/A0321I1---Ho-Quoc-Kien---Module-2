package case_study.models.customer_service;

public class Contract {
    private String idContract;
    private String idBooking;
    private double depositAmount;
    private double totalAmount;
    private String idCustomer;

    public Contract() {
    }

    public Contract(String idContract, String idBooking, double depositAmount, double totalAmount, String idCustomer) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
        this.idCustomer = idCustomer;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
}
