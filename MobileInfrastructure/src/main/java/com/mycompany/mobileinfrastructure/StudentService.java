package com.mycompany.mobileinfrastructure;

import Connectivity.DbManager;
import Connectivity.Querymanager;
import Models.Student;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Jozef Fraai
 */
@Path("student")
public class StudentService {
    
    private DbManager dbManager;
    private Querymanager querymanager;
    
    @GET
    @Produces
    @Path("/all")
    public String Students(){
        List<Student> students = new ArrayList<Student>();
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);
        
        students = querymanager.getStudentList();
        String res = "Naam\tStraat\tPostcode\n";
        for (Student s:students) {
			String naam = s.getStudentNaam();
                        int school =  s.getSchoolId();
                        boolean toegestaan = s.isToegestaan();
                        
                        res += ""+naam+"\t"+school+" "+toegestaan+"\n";
		}
        
        dbManager.closeConnection();
        return res;
    }
    
    @GET
    @Path("{id : \\d+}") //support digit only
    public String getStudent(@PathParam("id") int id) {
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);

        Student student;
        student = querymanager.getStudent(id);
        dbManager.closeConnection();
        String res = student.toString();

        return res;
    }

}
