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

    public void parse(String line) {
        String[] params = line.split(",");
        serviceName = params[0];
        useArea = Double.parseDouble(params[1]);
        rentalCosts = Double.parseDouble(params[2]);
        maximumNumberOfPeople = Integer.parseInt(params[3]);
        rentalType = params[4];
        freeServiceToAccompany = params[5];
    }

    public String getLineFile() {
        return serviceName + "," + useArea +
                "," + rentalCosts + "," + maximumNumberOfPeople +
                "," + rentalType + "," + freeServiceToAccompany +
                "\n";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Room{ " +
                "Free Service To Accompany: " + freeServiceToAccompany +
                " }";
    }
}
