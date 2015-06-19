package com.mycompany.mobileinfrastructure;

import Connectivity.DbManager;
import Connectivity.Querymanager;
import Models.School;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Jozef
 */
@Path("schools")
public class SchoolService {

    private DbManager dbManager;
    private Querymanager querymanager;

    @GET
    @Path("{id : \\d+}") //support digit only
    @Produces
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
