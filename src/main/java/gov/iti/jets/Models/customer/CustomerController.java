package gov.iti.jets.Models.customer;

import gov.iti.jets.service.implementations.CustomerServiceImpl;
import gov.iti.jets.service.interfaces.CustomerServiceInt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
public class CustomerController {

    CustomerServiceInt customerService = new CustomerServiceImpl();

    @GET
    public Response getCustomers() {
        return Response.ok(customerService.getAllCustomer()).build();
    }

    @GET
    @Path("{id}")
    public Response getCustomerById(@PathParam("id") int id) {
        return Response.ok(customerService.getCustomerById(id)).build();
    }

    @POST
    @Path("singup")
    @Consumes(MediaType.APPLICATION_XML)
    public Response signupCustomer(CustomerPost customerPost) {
        System.out.println(customerPost.toString());
        return Response.ok(customerService.addCustomer(customerPost)).build();
    }

    @PUT
    @Path("updateCustomer")
    public Response updateCustomer(Customer customer) {
        return Response.ok(customerService.updateCustomer(customer)).build();
    }

    @DELETE
    @Path("{id}/delete")
    public Response deleteCustomer(@PathParam("id") int id) {
        return Response.ok(customerService.deleteCustomer(id)).build();
    }

}
