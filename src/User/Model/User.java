package User.Model;

import Escaparate.Model.Escaparate;
import Escaparate.Model.EscaparateFinExistencias;
import Producto.Model.Producto;

public class User {
    private String dni;
    private String nombre;

    public User(String dni, String nombre) {
        this.dni    = dni;
        this.nombre = nombre;
    }

    public void buy(Escaparate escaparate){
        escaparate.sellProduct();
    }
}
