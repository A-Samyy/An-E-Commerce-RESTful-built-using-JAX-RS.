package gov.iti.jets.exception;

public class CartLineItemNotFoundException extends RuntimeException{
    public CartLineItemNotFoundException( String message ) {
        super( message );
    }
}
