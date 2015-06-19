package Models;

public class Student {

    private int id;
    private String studentNaam;
    private boolean toegestaan;
    private int schoolId;

    public Student() {
    }

    public Student(int id, String studentNaam, boolean toegestaan, int schoolId) {
        this.id = id;
        this.studentNaam = studentNaam;
        this.toegestaan = toegestaan;
        this.schoolId = schoolId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNaam() {
        return studentNaam;
    }

    public void setStudentNaam(String studentNaam) {
        this.studentNaam = studentNaam;
    }

    public boolean isToegestaan() {
        return toegestaan;
    }

    public void setToegestaan(boolean toegestaan) {
        this.toegestaan = toegestaan;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", studentNaam=" + studentNaam + ", toegestaan=" + toegestaan + ", schoolId=" + schoolId + '}';
    }
}
