package Escaparate.Model;

import Exceptions.CanNotMergeBrandsException;
import Exceptions.ProductListIsFull;
import Exceptions.ProductNotExist;
import Exceptions.ProductStockZero;
import Marca.Marca;
import Producto.Model.Producto;
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

    public ArrayList<StockProducto> listProductsInStock() {
        ArrayList<StockProducto> listaProductos = new ArrayList<>();
        for ( StockProducto producto :
                this.listadoStockProductos ) {
            if ( producto.findProductInStock() != null ) {
                listaProductos.add( producto.findProductInStock() );
            }
        }
        return listaProductos;
    }

    public boolean knownProductIsInStock(String cod) {
        for ( StockProducto producto :
                this.listadoStockProductos ) {
            Producto productoFinded = producto.findByCod( cod );
            if ( productoFinded != null ) {
                return true;
            }
        }
        return false;
    }

    public int availableQuantityProducto(String cod) throws ProductNotExist, ProductStockZero {
        StockProducto producto = null;
        for ( StockProducto product :
                this.listadoStockProductos ) {
            producto = product.findProduct( cod );
        }
        if ( producto == null ) {
            throw new ProductNotExist();
        }
        if ( producto.obtenerUnidades() == 0 ) {
            throw new ProductStockZero();
        }
        return producto.obtenerUnidades();
    }
}
