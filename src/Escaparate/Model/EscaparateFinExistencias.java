package Escaparate.Model;

import Marca.Marca;

public class EscaparateFinExistencias extends Escaparate {
    private boolean esAbierto;

    public EscaparateFinExistencias(String nombre, Marca marca) {
        super( nombre, marca );
        this.esAbierto = super.listProductsInStock() != null;
    }

    public void cerrar() {
        this.esAbierto = false;
    }
}
