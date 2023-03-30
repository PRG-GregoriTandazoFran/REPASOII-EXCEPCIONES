package Escaparate.Model;

import Exceptions.ShowRoomNotOpenException;
import Marca.Marca;

public class EscaparateTemporalFinExistencias extends EscaparateTemporal {
    private final static int APERTURA_MINIMA = 0;
    private final static int APERTURA_MAXIMA = 3;

    public EscaparateTemporalFinExistencias(String nombre, Marca marca, int diasApertura) throws ShowRoomNotOpenException {
        super( nombre, marca, diasApertura );
        if ( !isAperturaValida( diasApertura ) ) {
            throw new ShowRoomNotOpenException();
        }
    }


    private boolean isAperturaValida(int dias) {
        return dias >= APERTURA_MINIMA && dias <= APERTURA_MAXIMA;
    }
}
