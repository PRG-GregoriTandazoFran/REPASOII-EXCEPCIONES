package Escaparate.Model;

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
}
