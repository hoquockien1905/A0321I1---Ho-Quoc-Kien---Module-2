package case_study.models.person.employee;

public class Position {
    private String positionName;
    private String idPosition;

    public Position() {
    }

    public Position(String positionName, String idPosition) {
        this.positionName = positionName;
        this.idPosition = idPosition;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(String idPosition) {
        this.idPosition = idPosition;
    }
}
