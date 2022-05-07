package gov.iti.jets.Models.admin;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import gov.iti.jets.Models.exceptions.notfound.NotFoundException;
import gov.iti.jets.service.implementations.AdminServiceImpl;
import gov.iti.jets.service.interfaces.AdminServiceInt;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("admins")
public class AdminController {

    AdminServiceInt adminService = new AdminServiceImpl();

    @GET
    public Response getAdmins() {
        return Response.ok(adminService.getAdmins()).build();
    }

    @GET
    @Path("{id}")
    public Response getAdminById(@PathParam("id") int id) {
        if (adminService.getAdminById(id) == null)
            throw new NotFoundException("no admin with this id");
        return Response.ok(adminService.getAdminById(id)).build();
    }

    @POST
    @Path("addAdmin")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addAdmin(AdminPost admin) {
        return Response.ok(adminService.addAdmin(admin)).build();
    }

    @PUT
    @Path("updateAdmin")
    public Response updateAdmin(Admin admin) {
        return Response.ok(adminService.updateAdmin(admin)).build();
    }

    @DELETE
    @Path("{id}/deleteAdmin")
    public Response deleteAdmin(@PathParam("id") int id) {
        return Response.ok(adminService.deleteAdmin(id)).build();
    }
}
