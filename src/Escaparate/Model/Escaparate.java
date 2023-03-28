package Escaparate.Model;

import Exceptions.CanNotMergeBrandsException;
import Exceptions.ProductListIsFull;
import Marca.Marca;
import Producto.Model.StockProducto;

import java.util.ArrayList;

public class Escaparate {
    private String                   nombre;
    private Marca                    marca;
    private ArrayList<StockProducto> listadoStockProductos;

    public Escaparate(String nombre, Marca marca) {
        this.nombre           = nombre;
        this.marca            = marca;
        listadoStockProductos = new ArrayList<>();
    }

    public void anyadirProducto(StockProducto producto) throws CanNotMergeBrandsException, ProductListIsFull {
        if ( producto.obtenerMarca() != this.marca ) {
            throw new CanNotMergeBrandsException();
        }
        if ( this.listadoStockProductos.size() >= 20 ) {
            throw new ProductListIsFull();
        }
        this.listadoStockProductos.add( producto );
    }
}
