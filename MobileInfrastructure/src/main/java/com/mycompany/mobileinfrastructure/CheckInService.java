/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mobileinfrastructure;


import Connectivity.DbManager;
import Connectivity.Querymanager;
import Models.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author bob
 */
@Path("checkin")
public class CheckInService {
    
private DbManager dbManager;
    private Querymanager querymanager;
    
    @GET
    @Path("/all")
    public String CheckIns(){
        List<CheckIn> checkins = new ArrayList<CheckIn>();
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);
        
        checkins = querymanager.getCheckInList();
        String res = "";
        for (CheckIn c:checkins) {
                        int id = c.getId();
			String checkInTime = c.getCheckInTime();
                        String checkOutTime =  c.getCheckOutTime();
                        int studentID = c.getStudentID();
                        
                        res += ""+id+"\t"+checkInTime+" "+checkOutTime+" "+ studentID + "\n";
		}
        
        dbManager.closeConnection();
        return res;
    }
    
    @POST
    @Path("/newcheckin")
    public void createCheckin() {
        System.out.println("ik word aangeroepen");
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);
        
        querymanager.createCheckIn(2);
        dbManager.closeConnection();
    }
    
    @GET
    @Path("{id : \\d+}") //support digit only
    public String getCheckIn(@PathParam("id") int id) {
        dbManager = new DbManager();
        dbManager.openConnection();
        querymanager = new Querymanager(dbManager);

        CheckIn checkIn;
        checkIn = querymanager.getCheckIn(id);
        dbManager.closeConnection();
        String res = checkIn.toString();

        return res;
    }

}

