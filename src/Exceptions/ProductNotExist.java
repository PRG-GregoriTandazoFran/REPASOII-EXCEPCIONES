package Exceptions;

public class ProductNotExist extends RuntimeException{
    public ProductNotExist(){
        super("Producto no existe");
    }
}
