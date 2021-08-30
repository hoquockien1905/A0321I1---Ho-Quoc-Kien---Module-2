package case_study.models.customer_service;

import case_study.models.person.customer.Customer;

public class Contract {
    private static int autoId = 1;
    private String idContract = "CT00";
    private String idBooking;
    private double depositAmount;
    private double totalAmount;
    private String idCustomer;

    public Contract() {
    }

    public Contract(String idBooking, double depositAmount, double totalAmount, String idCustomer) {
        this.idContract = idContract + Contract.autoId++;
        if (Contract.autoId > 9 && Contract.autoId < 100) {
            this.idContract = "CTM0" + Contract.autoId++;
        }
        this.idBooking = idBooking;
        this.depositAmount = depositAmount;
        this.totalAmount = totalAmount;
        this.idCustomer = idCustomer;
    }

    public String getIdContract() {
        return idContract;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Contract.autoId = autoId;
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

    public void parse(String line) {
        String[] params = line.split(",");
        idContract = params[0];
        idBooking = params[1];
        depositAmount = Double.parseDouble(params[2]);
        totalAmount = Double.parseDouble(params[3]);
        idCustomer = params[4];
    }

    public String getLineFile() {
        return idContract + "," + idBooking +
                "," + depositAmount + "," + totalAmount +
                "," + idCustomer + "\n";
    }

    @Override
    public String toString() {
        return "Contract{" +
                " ID Contract: " + idContract +
                ", ID Booking: " + idBooking +
                ", Deposit Amount: " + depositAmount +
                ", Total Amount: " + totalAmount +
                ", ID Customer: " + idCustomer +
                " }";
    }
}
