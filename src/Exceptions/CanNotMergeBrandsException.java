package Exceptions;

public class CanNotMergeBrandsException extends RuntimeException {
    public CanNotMergeBrandsException() {
        super( "No se puede hilar" );
    }
}
