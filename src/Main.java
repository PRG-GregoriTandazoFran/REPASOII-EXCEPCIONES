import Escaparate.Model.Escaparate;
import Escaparate.Model.EscaparateFinExistencias;
import Marca.Marca;
import Producto.Model.Producto;

public class Main {
    public static void main(String[] args) {
        EscaparateFinExistencias esc1  = new EscaparateFinExistencias( "Lacoste", Marca.LaCostera );
        Producto                 gorra = new Producto( "d123", 20., Marca.LaCostera );

        System.out.println( gorra.getStockProducto().obtenerUnidades() );
        esc1.anyadirProducto( gorra );
        esc1.cerrar();

        esc1.sellProduct();
        System.out.println( gorra.getStockProducto().obtenerUnidades() );

    }
}