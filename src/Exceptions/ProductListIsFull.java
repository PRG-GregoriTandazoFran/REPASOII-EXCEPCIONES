package Exceptions;

public class ProductListIsFull extends RuntimeException{
    public ProductListIsFull(){
        super("La lista está llena");
    }
}
