package Exceptions;

public class ProductStockZero extends RuntimeException {
    public ProductStockZero() {
        super( "El stock del almance es 0" );
    }
}
