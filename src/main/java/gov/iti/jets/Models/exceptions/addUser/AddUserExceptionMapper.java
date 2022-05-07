package gov.iti.jets.Models.exceptions.addUser;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AddUserExceptionMapper implements ExceptionMapper<AddUserException> {

    @Override
    public Response toResponse(AddUserException exception) {
        Message message = new Message(exception.getMessage(),404, "Enter New Email");
        return Response.ok(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
    }
}
