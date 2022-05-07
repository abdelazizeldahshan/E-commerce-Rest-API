package gov.iti.jets.Models.exceptions.notfound;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        Message message = new Message(exception.getMessage(),404, "Enter Right ID Or Name");
        return Response.ok(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
    }
}
