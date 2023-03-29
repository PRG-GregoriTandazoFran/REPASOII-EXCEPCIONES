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

    public StockProducto(Producto producto, int unidades) {
        this.producto = producto;
        this.unidades = unidades;
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

    public int obtenerUnidades() {
        return this.unidades;
    }

    public StockProducto findProductInStock() {
        if ( this.unidades >= 1 ) {
            return new StockProducto( new Producto( this.producto.getId(), this.producto.getPrecio(), this.producto.getMarca() ),this.unidades );
        }
        return null;
    }

    public Producto findByCod(String cod) {
        if ( this.producto.getId().equals( cod ) ) {
            return this.producto;
        }
        return null;
    }

    public StockProducto findProduct(String cod) {
        if ( this.producto.getId().equals( cod ) ) {
            return new StockProducto( new Producto( this.producto.getId(), this.producto.getPrecio(), this.producto.getMarca() ),this.unidades );
        }
        return null;
    }

    public boolean hayStock(){
        return this.unidades >=1;
    }
}
