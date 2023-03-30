import Escaparate.Model.Escaparate;
import Escaparate.Model.EscaparateFinExistencias;
import Escaparate.Model.EscaparateTemporal;
import Marca.Marca;
import Producto.Model.Producto;
import User.Model.User;

public class Main {
    public static void main(String[] args) {
        //EscaparateFinExistencias esc1  = new EscaparateFinExistencias( "Lacoste", Marca.LaCostera );
        EscaparateTemporal esc1  = new EscaparateTemporal( "Lacoste", Marca.LaCostera, 4 );
        Producto           gorra = new Producto( "d123", 20., Marca.LaCostera );
        User               fran  = new User( "214", "fran" );
        System.out.println( gorra.getStockProducto().obtenerUnidades() );
        esc1.anyadirProducto( gorra );
        fran.buy( esc1 );
        System.out.println( gorra.getStockProducto().obtenerUnidades() );
        esc1.sumarDias( 4 );
        fran.buy( esc1 );
        System.out.println( gorra.getStockProducto().obtenerUnidades() );
    }
}