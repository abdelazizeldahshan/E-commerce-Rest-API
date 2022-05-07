package gov.iti.jets.Models.exceptions.limitquantity;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class QuntityExceptionMapper implements ExceptionMapper<QuntityException> {

    @Override
    public Response toResponse(QuntityException exception) {
        Message message = new Message(exception.getMessage());
        return Response.ok(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
    }
}
