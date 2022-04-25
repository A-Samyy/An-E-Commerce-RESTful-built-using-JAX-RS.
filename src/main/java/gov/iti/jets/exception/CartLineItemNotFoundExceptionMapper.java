package gov.iti.jets.exception;

import gov.iti.jets.exception.dtos.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CartLineItemNotFoundExceptionMapper implements ExceptionMapper<CartLineItemNotFoundException> {
    @Override
    public Response toResponse( CartLineItemNotFoundException e ) {
        ErrorMessage errorMessage = new ErrorMessage( e.getMessage(), 404, "No Items Found " );
        return Response.status( Response.Status.NOT_FOUND ).entity( errorMessage ).build();
    }
}
