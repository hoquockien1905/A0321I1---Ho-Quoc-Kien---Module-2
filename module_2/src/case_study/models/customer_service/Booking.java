package case_study.models.customer_service;

public class Booking implements Comparable<Booking>{
    private static int auId = 1;
    private String idBooking = "BK00";
    private String startDay;
    private String endDay;
    private String idCustomerBooking;
    private String serviceName;
    private String serviceType;

    public Booking() {
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

    @Override
    public int compareTo(Booking o) {
        if (this.getStartDay().equals(o.getStartDay())) {
            return o.getEndDay().compareTo(this.getEndDay());
        }
        return this.getStartDay().compareTo(o.getStartDay());
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
