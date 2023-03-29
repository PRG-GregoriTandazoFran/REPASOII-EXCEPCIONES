package Escaparate.Model;

import Exceptions.ShowRoomNotOpenException;
import Marca.Marca;

public class EscaparateFinExistencias extends Escaparate {
    private boolean esAbierto;

    public EscaparateFinExistencias(String nombre, Marca marca) {
        super( nombre, marca );
        this.esAbierto = super.listProductsInStock() != null;
    }

    @Override
    public void sellProduct() {
        try {
            if ( this.esAbierto == false ){
                throw new ShowRoomNotOpenException();
            }
            super.sellProduct();
        }catch ( ShowRoomNotOpenException e1 ){
            System.out.println(e1.getMessage());
        }
    }

    public void cerrar() {
        this.esAbierto = false;
    }
}
