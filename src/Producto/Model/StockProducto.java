package Producto.Model;

import Exceptions.NotExistEnoughtItemException;
import Exceptions.ProductStockZero;
import Marca.Marca;

import java.util.concurrent.ThreadLocalRandom;

public class StockProducto {
    private int      unidades;
    private Producto producto;

    public StockProducto(Producto producto) {
        this.producto = producto;
        this.unidades = ThreadLocalRandom.current().nextInt( 1, 11 );
    }

    public double obtenerPrecio() {
        return this.producto.getPrecio();
    }

    public Marca obtenerMarca() {
        return this.producto.getMarca();
    }

    public void decrementarUnidades(int unidades) throws ProductStockZero, NotExistEnoughtItemException {
        if ( this.unidades == 0 ) {
            throw new ProductStockZero();
        }

        if ( this.unidades - unidades < 0 ) {
            throw new NotExistEnoughtItemException();
        }
        this.unidades -= unidades;
    }
}
