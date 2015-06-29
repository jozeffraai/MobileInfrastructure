package Connectivity;

import Models.School;
import Models.Student;
import Models.CheckIn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jozef
 */
public class Querymanager {

    private final DbManager dbmanager;

    public Querymanager(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

/////////////////////////////////////////School/////////////////////////////////
    public School getSchool(int id) {
        School school = new School();
        try {
            String sq1 = "SELECT * FROM school " + "WHERE id='" + id + "'";
            ResultSet result = dbmanager.doQuery(sq1);
            if (result.next()) {
                school = new School(result.getInt("id"),
                        result.getString("schoolnaam"),
                        result.getString("straat"),
                        result.getString("huisnummer"),
                        result.getString("postcode"),
                        result.getString("stad"),
                        result.getString("latitude"),
                        result.getString("longtitude")
                );
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }

        return school;
    }
    
    public List<School> getSchoolList() {
        List<School> schools = new ArrayList<School>();
        try {
            String sql = "SELECT * FROM school";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                schools.add(new School(result.getInt("id"),
                        result.getString("schoolnaam"),
                        result.getString("straat"),
                        result.getString("huisnummer"),
                        result.getString("postcode"),
                        result.getString("stad"),
                        result.getString("latitude"),
                        result.getString("longtitude")));
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }
        return schools;
     }
/////////////////////////////////////////Student////////////////////////////////
    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<Student>();
        try {
            String sql = "SELECT * FROM student";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                students.add(new Student(result.getInt("id"),
                        result.getString("naam"),
                        result.getBoolean("toegestaan"),
                        result.getInt("schoolID")));
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }
        return students;
     }
    
    public Student getStudent(int id) {
        Student student = new Student();
        try {
            String sq1 = "SELECT * FROM student " + "WHERE id='" + id + "'";
            ResultSet result = dbmanager.doQuery(sq1);
            if (result.next()) {
                student = new Student(result.getInt("id"),
                        result.getString("naam"),
                        result.getBoolean("toegestaan"),
                        result.getInt("ID"));
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }

        return student;
    }
    
 /////////////////////////////////////////CheckIn/////////////////////////////////
    public CheckIn getCheckIn(int id) {
        CheckIn checkIn = new CheckIn();
        try {
            String sq1 = "SELECT * FROM checkin " + "WHERE id='" + id + "'";
            ResultSet result = dbmanager.doQuery(sq1);
            if (result.next()) {
                checkIn = new CheckIn(result.getInt("id"),
                        result.getString("checkInTime"), 
                        result.getString("checkOutTime"), 
                        result.getInt("studentID")
                );
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }

        return checkIn;
    }
    
    public List<CheckIn> getCheckInList() {
        List<CheckIn> checkIns = new ArrayList<CheckIn>();
        try {
            String sql = "SELECT * FROM checkin";
            ResultSet result = dbmanager.doQuery(sql);
            while (result.next()) {
                checkIns.add(new CheckIn(result.getInt("id"),
                     result.getString("checkInTime"), 
                        result.getString("checkOutTime"), 
                        result.getInt("studentID")
                ));
            }
        } catch (SQLException e) {
            System.out.println(DbManager.SQL_EXCEPTION + e.getMessage());
        }
        return checkIns;
     }
    
}
