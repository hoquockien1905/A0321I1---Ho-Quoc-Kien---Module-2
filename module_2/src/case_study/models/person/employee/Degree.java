package case_study.models.person.employee;

public class Degree {
    private String degreeType;

    public Degree() {
    }

    public Degree(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    @Override
    public String toString() {
        return degreeType;
    }
}
