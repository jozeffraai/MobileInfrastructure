package com.mycompany.mobileinfrastructure;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("test")
public class TestService {

    @GET
    @Produces
    public String hello() {
        return "Het werkt";
    }
}
