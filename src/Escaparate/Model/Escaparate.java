package Escaparate.Model;

import Exceptions.CanNotMergeBrandsException;
import Exceptions.ProductListIsFull;
import Exceptions.ProductNotExist;
import Exceptions.ProductStockZero;
import Marca.Marca;
import Producto.Model.Producto;
import Producto.Model.StockProducto;
import Utils.GestorIO;

import java.util.ArrayList;

public class Escaparate {
    private String              nombre;
    private Marca               marca;
    private ArrayList<Producto> listadoStockProductos;

    public Escaparate(String nombre, Marca marca) {
        this.nombre           = nombre;
        this.marca            = marca;
        listadoStockProductos = new ArrayList<>();
    }

    public void anyadirProducto(Producto producto) throws CanNotMergeBrandsException, ProductListIsFull {
        if ( producto.getStockProducto().obtenerMarca() != this.marca ) {
            throw new CanNotMergeBrandsException();
        }
        if ( this.listadoStockProductos.size() >= 20 ) {
            throw new ProductListIsFull();
        }
        this.listadoStockProductos.add( producto );
    }

    public ArrayList<StockProducto> listProductsInStock() {
        ArrayList<StockProducto> listaProductos = new ArrayList<>();
        for ( Producto producto :
                this.listadoStockProductos ) {
            if ( producto.getStockProducto().findProductInStock() != null ) {
                listaProductos.add( producto.getStockProducto().findProductInStock() );
            }
        }
        return listaProductos;
    }

    public boolean knownProductIsInStock(String cod) {
        for ( Producto producto :
                this.listadoStockProductos ) {
            Producto productoFinded = producto.getStockProducto().findByCod( cod );
            if ( productoFinded != null ) {
                return true;
            }
        }
        return false;
    }

    public int availableQuantityProducto(String cod) throws ProductNotExist, ProductStockZero {
        StockProducto producto = null;
        for ( Producto product :
                this.listadoStockProductos ) {
            producto = product.getStockProducto().findProduct( cod );
        }
        if ( producto == null ) {
            throw new ProductNotExist();
        }
        if ( producto.obtenerUnidades() == 0 ) {
            throw new ProductStockZero();
        }
        return producto.obtenerUnidades();
    }

    public void sellProduct() {
        String   codProducto    = GestorIO.pedirCadena( "Escoja el producto a comprar: " );
        Producto productoToSell = this.findProductAvailableList( codProducto );
        esStockAgotado( productoToSell );
        int      unidades       = GestorIO.pedirEntero( "Esoja las unidades del producto " + productoToSell.getId() + ": " );


    }

    private static void esStockAgotado(Producto productoToSell) throws ProductStockZero {
        if ( !productoToSell.getStockProducto().hayStock() ) {
            throw new ProductStockZero();
        }
    }

    private Producto findProductAvailableList(String codProducto) throws ProductNotExist {
        for ( Producto product :
                this.listadoStockProductos ) {
            Producto producto = product.getStockProducto().findByCod( codProducto );
            if ( producto.getStockProducto().obtenerUnidades() >= 1 ) {
                return producto;
            }
        }
        throw new ProductNotExist();
    }
}
