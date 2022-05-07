package gov.iti.jets.Models.products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gov.iti.jets.Models.category.Category;
import gov.iti.jets.service.implementations.ProductServiceImpl;
import gov.iti.jets.service.interfaces.ProductServiceInt;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("products")
public class ProductsController {

    ProductServiceInt productService = new ProductServiceImpl();

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Product> getAllProducts() {
        List<Product> products = productService.getProducts();
        return products;
    }

    @GET
    @Path("{id}")
    public Response getProductById(@PathParam("id") int id) {
        return Response.ok(productService.getProductByID(id)).build();
    }

    @DELETE
    @Path("{id}/deleteProduct")
    public Response deleteProduct(@PathParam("id") int id) {
        return Response.ok(productService.deleteProduct(id)).build();
    }

    @POST
    @Path("addProduct")
    public void createProduct(ProductPostRequest productPostRequest) {
        System.out.println(productPostRequest);
        productService.addProduct(productPostRequest);
    }

    @PUT
    @Path("editProduct")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({ MediaType.APPLICATION_XML })
    public void editProduct(ProductPutRequest productPutRequest) {
        productService.updateProduct(productPutRequest);
    }

    @GET
    @Path("categories")
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        for (Product product : productService.getProducts()) {
            for (Category category : product.getCategories()) {
                categories.add(category);
            }
        }
        return categories;
    }

    @GET
    @Path("/categories/{id}")
    public Category getCategory(@PathParam("id") int id) {
        for (Product product : productService.getProducts()) {
            for (Category category : product.getCategories()) {
                if (category.getId() == id) {
                    return category;
                }
            }
        }
        return null;
    }

    @GET
    @Path("pagenation")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public Response getSomeProducts(@DefaultValue("0") @QueryParam("start") int from,
            @DefaultValue("1") @QueryParam("page") int page, @Context UriInfo uriInfo) {
        List<Product> products = new ArrayList<>();
        for (Product product : productService.getProducts().subList(from, page)) {
            Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
            product.setLinks(Arrays.asList(self));
            Link addation = Link.fromPath("http://localhost:9595/Ecommerce-Rest-API/api/products").rel("product")
                    .build();
            product.setLinks(Arrays.asList(self, addation));
            products.add(product);
        }
        return Response.ok(products).build();
    }
}