package gov.iti.jets.exception;

public class ShoppingCartNotFoundException extends RuntimeException{
    public ShoppingCartNotFoundException( String message ) {
        super( message );
    }
}
