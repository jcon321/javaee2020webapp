package com.example.webapplication.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author
 */
@Path("health")
public class HealthResource {

    @GET
    public Response ping() {
        return Response
                .ok("ping")
                .build();
    }
}
