package Exceptions;

public class NotExistEnoughtItemException extends RuntimeException{
    public NotExistEnoughtItemException(){
        super("No hay suficiente stock");
    }
}
