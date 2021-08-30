package case_study.models.facility;

public abstract class Facility {
    protected String serviceName;
    protected double useArea;
    protected double rentalCosts;
    protected int maximumNumberOfPeople;
    protected String rentalType;

    public Facility() {
    }

    public Facility(String serviceName, double useArea, double rentalCosts, int maximumNumberOfPeople, String rentalType) {
        this.serviceName = serviceName;
        this.useArea = useArea;
        this.rentalCosts = rentalCosts;
        this.maximumNumberOfPeople = maximumNumberOfPeople;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUseArea() {
        return useArea;
    }

    public void setUseArea(double useArea) {
        this.useArea = useArea;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaximumNumberOfPeople() {
        return maximumNumberOfPeople;
    }

    public void setMaximumNumberOfPeople(int maximumNumberOfPeople) {
        this.maximumNumberOfPeople = maximumNumberOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return  "Service Name: " + serviceName +
                ", Use Area: " + useArea +
                ", Rental Costs: " + rentalCosts +
                ", Maximum Number Of People: " + maximumNumberOfPeople +
                ", Rental Type: " + rentalType +
                ", ";
    }
}
