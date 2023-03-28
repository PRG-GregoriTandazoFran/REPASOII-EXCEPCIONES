package Producto.Model;

import java.util.concurrent.ThreadLocalRandom;

public class StockProducto {
    private int      unidades;
    private Producto producto;

    public StockProducto(Producto producto) {
        this.producto = producto;
        this.unidades = ThreadLocalRandom.current().nextInt( 1, 11 );
    }
}
