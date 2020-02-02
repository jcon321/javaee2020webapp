/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webapplication.resources;

import com.example.bean.MaintainEmployee;
import com.example.entity.Employee;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jbuntu
 */
@Path("employee")
@Stateless
public class EmployeeResource {

    private static final Logger log = Logger.getLogger(EmployeeResource.class.getName());

    @EJB
    private MaintainEmployee maintainEmployee;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee employee) {
        Response resp;
        try {
            resp = Response.ok(maintainEmployee.addEmployee(employee)).build();
        } catch (Exception e) {
            resp = Response.serverError().build();
        }
        return resp;
    }

}
