package Connectivity;

import Models.School;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jozef
 */
public class Querymanager {

    private final DbManager dbmanager;

    public Querymanager(DbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

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
}
