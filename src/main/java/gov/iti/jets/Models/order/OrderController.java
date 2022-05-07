package gov.iti.jets.Models.order;

import gov.iti.jets.service.implementations.OrderServiceImpl;
import gov.iti.jets.service.interfaces.OrderServiceInt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("orders")
public class OrderController {

    OrderServiceInt orderService = new OrderServiceImpl();

    @GET
    public Response getOrders() {
        return Response.ok(orderService.getAllOredrs()).build();
    }

    @GET
    @Path("{id}")
    public Response getOrderById(@PathParam("id") int id) {
        return Response.ok(orderService.getOrderById(id)).build();
    }

    @POST
    @Path("addOrder")
    @Consumes(MediaType.APPLICATION_XML)
    public Response addOrder(OrderPostRequest orderPostRequest) {
        return Response.ok(orderService.addOrder(orderPostRequest)).build();
    }

    // @GET
    // @Path("gt")
    // public Response getOrderById() {
    //     Set<ProductForOrder> p = new HashSet<>();
    //     ProductForOrder p1 = new ProductForOrder();
    //     p1.setId(34);
    //     p1.setName("name");
    //     p1.setOrderQuantity(43);
    //     ProductForOrder p2 = new ProductForOrder();
    //     p2.setId(34);
    //     p2.setName("name");
    //     p2.setOrderQuantity(43);
    //     p.add(p1);
    //     p.add(p2);
    //     OrderPostRequest or = new OrderPostRequest();
    //     or.setCreatedAt(new Date());
    //     or.setCustomerId(34);
    //     or.setProducts(p);
    //     return Response.ok(or).build();
    // }
}
