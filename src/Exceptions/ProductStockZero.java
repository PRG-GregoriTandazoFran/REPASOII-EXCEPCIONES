package Exceptions;

public class ProductStockZero extends RuntimeException {
    public ProductStockZero() {
        super( "El stock del almancen es 0" );
    }
}
