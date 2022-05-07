package gov.iti.jets.Models.category;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import gov.iti.jets.Models.exceptions.notfound.NotFoundException;
import gov.iti.jets.service.implementations.CategoryServiceImpl;
import gov.iti.jets.service.interfaces.CategoryServiceInt;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("categories")
public class CategoryController {

    CategoryServiceInt categoryService = new CategoryServiceImpl();

    @GET
    public Response getCategories() {
        return Response.ok(categoryService.getCategories()).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response getCategoryById(@PathParam("id") int id) {
        if(categoryService.getCategpryById(id) == null)
            throw new NotFoundException("Not Category With this Id");
        return Response.ok(categoryService.getCategpryById(id)).build();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoryByName(@PathParam("name") String name) {
        return Response.ok(categoryService.getCategoryByName(name)).build();
    }

    @GET
    @Path("products")
    public Response getCategoryProducts() {
        return Response.ok().build();
    }

    @POST
    @Path("addCategory")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addCategory(Category category) {
        return Response.ok(categoryService.addCategory(category)).build();
    }

    @PUT
    @Path("updateCatgory")
    public Response updateCategory(Category category) {
        return Response.ok(categoryService.updateCategory(category)).build();
    }

    @DELETE
    @Path("{id}/deleteCategory")
    public Response deleteCategory(@PathParam("id") int id) {
        return Response.ok(categoryService.deleteCategory(id)).build();
    }
}
