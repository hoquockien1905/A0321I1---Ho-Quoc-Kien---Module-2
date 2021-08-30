package case_study.models.customer_service;

import case_study.models.person.customer.Customer;

public class Booking {
    private static int auId = 1;
    private String idBooking = "BK00";
    private String startDay;
    private String endDay;
    private String idCustomerBooking;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public static int getAuId() {
        return auId;
    }

    public static void setAuId(int auId) {
        Booking.auId = auId;
    }

    public Booking(String startDay, String endDay, String idCustomerBooking, String serviceName, String serviceType) {
        this.idBooking = idBooking + Booking.auId++;
        if (Booking.auId > 9 && Booking.auId < 100) {
            this.idBooking = "BK0" + Booking.auId++;
        }
        this.startDay = startDay;
        this.endDay = endDay;
        this.idCustomerBooking = idCustomerBooking;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getIdCustomerBooking() {
        return idCustomerBooking;
    }

    public void setIdCustomerBooking(String idCustomerBooking) {
        this.idCustomerBooking = idCustomerBooking;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void parse(String line) {
        String[] params = line.split(",");
        try {
            idBooking = params[0];
            startDay = params[1];
            endDay = params[2];
            idCustomerBooking = params[3];
            serviceName = params[4];
            serviceType = params[5];
        }catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    public String getLineFile() {
        return idBooking + "," + startDay +
                "," + endDay + "," + idCustomerBooking +
                "," + serviceName + "," + serviceType +
                "\n";
    }

    @Override
    public String toString() {
        return "Booking{ " +
                "ID Booking: " + idBooking +
                ", Start Day: " + startDay +
                ", End Day: " + endDay +
                ", ID Customer Booking: " + idCustomerBooking +
                ", Service Name: " + serviceName +
                ", Service Type: " + serviceType +
                " }";
    }
}
