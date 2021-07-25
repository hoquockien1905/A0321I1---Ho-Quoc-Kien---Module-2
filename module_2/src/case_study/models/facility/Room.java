package case_study.models.facility;

public class Room extends Facility {
    private String freeServiceToAccompany;

    public Room() {
    }

    public Room(String freeServiceToAccompany) {
        this.freeServiceToAccompany = freeServiceToAccompany;
    }

    public Room(String serviceName, double useArea, double rentalCosts, int maximumNumberOfPeople, String rentalType, String freeServiceToAccompany) {
        super(serviceName, useArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.freeServiceToAccompany = freeServiceToAccompany;
    }

    public String getFreeServiceToAccompany() {
        return freeServiceToAccompany;
    }

    public void setFreeServiceToAccompany(String freeServiceToAccompany) {
        this.freeServiceToAccompany = freeServiceToAccompany;
    }
}
