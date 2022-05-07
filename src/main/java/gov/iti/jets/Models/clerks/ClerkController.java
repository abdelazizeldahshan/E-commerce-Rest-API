package gov.iti.jets.Models.clerks;

import gov.iti.jets.service.implementations.ClerkServiceImpl;
import gov.iti.jets.service.interfaces.ClerkServiceInt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clerks")
public class ClerkController {

    ClerkServiceInt clerkService = new ClerkServiceImpl();

    @GET
    public Response getClerks() {
        return Response.ok(clerkService.getClerks()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getClerkById(@PathParam("id") int id) {
        return Response.ok(clerkService.getClerkById(id)).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClerkByName(@PathParam("name") String name) {
        return Response.ok(clerkService.getClerkByName(name)).build();
    }

    @POST
    @Path("addClerk")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addClerk(ClerkPost clerkPost) {
        return Response.ok(clerkService.addClerk(clerkPost)).build();
    }

    @PUT
    @Path("updateClerk")
    public Response updateClerk(Clerk clerk) {
        return Response.ok(clerkService.updateClerk(clerk)).build();
    }

    @DELETE
    @Path("{id}/delete")
    public Response deleteClerk(@PathParam("id") int id) {
        return Response.ok(clerkService.deleteClerk(id)).build();
    }
}
