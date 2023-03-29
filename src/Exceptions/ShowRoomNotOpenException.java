package Exceptions;

public class ShowRoomNotOpenException extends Exception{
    public ShowRoomNotOpenException(){
        super("El escaparate está cerrado");
    }
}
