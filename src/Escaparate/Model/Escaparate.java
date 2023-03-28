package Escaparate.Model;

import Marca.Marca;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Escaparate {
    private String nombre;
    private Marca  marca;
    //Falta añadir la clase StockProducto
    private ArrayList<StockProducto> listadoStockProductos;

    public Escaparate(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca  = marca;
    }
}
