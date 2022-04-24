package gov.iti.jets.exception;

import gov.iti.jets.exception.dtos.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ShoppingCartNotFoundExceptionMapper implements ExceptionMapper<ShoppingCartNotFoundException> {
    @Override
    public Response toResponse( ShoppingCartNotFoundException e ) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "probably wrong ID ");
        return Response.status(Response.Status.NOT_FOUND).entity(errorMessage).build();
    }
}
