package case_study.models.person.employee;

public class Degree {
    private String degreeType;
    private String idDegreeType;

    public Degree() {
    }

    public Degree(String degreeType, String idDegreeType) {
        this.degreeType = degreeType;
        this.idDegreeType = idDegreeType;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getIdDegreeType() {
        return idDegreeType;
    }

    public void setIdDegreeType(String idDegreeType) {
        this.idDegreeType = idDegreeType;
    }
}
