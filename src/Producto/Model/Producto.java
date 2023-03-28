package Producto.Model;

import Marca.Marca;

import java.util.Objects;

public class Producto {
    private String id;
    private double precio;
    private Marca  marca;

    public Producto(String id, double precio, Marca marca) {
        this.id     = id;
        this.precio = precio;
        this.marca  = marca;
    }

    public String getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Producto producto = (Producto) o;
        return Objects.equals( id, producto.id );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id );
    }
}
