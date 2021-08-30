package case_study.models.facility;

public class House extends Facility {
    private String roomStandard;
    private int numberOfFloors;

    public House() {
    }

    public House(String roomStandard, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public House(String serviceName, double useArea, double rentalCosts, int maximumNumberOfPeople, String rentalType, String roomStandard, int numberOfFloors) {
        super(serviceName, useArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void parse(String line) {
        String[] params = line.split(",");
        serviceName = params[0];
        useArea = Double.parseDouble(params[1]);
        rentalCosts = Double.parseDouble(params[2]);
        maximumNumberOfPeople = Integer.parseInt(params[3]);
        rentalType = params[4];
        roomStandard = params[5];
        numberOfFloors = Integer.parseInt(params[6]);
    }

    public String getLineFile() {
        return serviceName + "," + useArea +
                "," + rentalCosts + "," + maximumNumberOfPeople +
                "," + rentalType + "," + roomStandard +
                "," + numberOfFloors + "\n";
    }

    @Override
    public String toString() {
        return super.toString() +
                "House{ " +
                "Room Standard: " + roomStandard +
                ", Number Of Floors: " + numberOfFloors +
                " }";
    }
}
