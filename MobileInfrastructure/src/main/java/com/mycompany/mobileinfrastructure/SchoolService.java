package com.mycompany.mobileinfrastructure;

import Connectivity.DbManager;
import Connectivity.Querymanager;
import Models.School;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Jozef
 */
@Path("school")
public class SchoolService {

    private DbManager dbManager;
    private Querymanager querymanager;

    @GET
    @Produces
    @Path("/all")
    public String Schools(){
        List<School> schools = new ArrayList<School>();
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);
        
        schools = querymanager.getSchoolList();
        String res = "Schoolnaam\tStraat\tPostcode\n";
        for (School s:schools) {
			String naam = s.getSchoolNaam();
                        String straat = s.getStraat();
                        String nummer = s.getHuisnummer();
                        String postcode = s.getPostcode();
                        String stad = s.getStad();
                        
                        res += ""+naam+"\t"+straat+" "+nummer+"\t"+postcode+" "+stad+"\n";
		}
        
        dbManager.closeConnection();
        return res;
    }
    
    
    @GET
    @Path("{id : \\d+}") //support digit only
    public String getSchool(@PathParam("id") int id) {
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);

        School school;
        school = querymanager.getSchool(id);
        dbManager.closeConnection();
        String schoolstring = school.toString();

        return schoolstring;
    }

}
