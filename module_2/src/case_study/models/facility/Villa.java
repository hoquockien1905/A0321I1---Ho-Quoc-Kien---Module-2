package case_study.models.facility;

public class Villa extends Facility {
    private String roomStandard;
    private double areaOfPool;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String roomStandard, double areaOfPool, int numberOfFloors) {
        this.roomStandard = roomStandard;
        this.areaOfPool = areaOfPool;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String serviceName, double useArea, double rentalCosts, int maximumNumberOfPeople, String rentalType, String roomStandard, double areaOfPool, int numberOfFloors) {
        super(serviceName, useArea, rentalCosts, maximumNumberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.areaOfPool = areaOfPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(double areaOfPool) {
        this.areaOfPool = areaOfPool;
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
        areaOfPool = Double.parseDouble(params[6]);
        numberOfFloors = Integer.parseInt(params[7]);
    }

    public String getLineFile() {
        return serviceName + "," + useArea +
                "," + rentalCosts + "," + maximumNumberOfPeople +
                "," + rentalType + "," + roomStandard +
                "," + areaOfPool + "," + numberOfFloors +
                "\n";
    }

    @Override
    public String toString() {
        return  super.toString() +
                "Villa{ " +
                "Room Standard: " + roomStandard +
                ", Area Of Pool: " + areaOfPool +
                ", Number Of Floors: " + numberOfFloors +
                " }";
    }
}
