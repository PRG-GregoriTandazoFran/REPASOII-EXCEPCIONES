package Escaparate.Model;

import Exceptions.ShowRoomNotOpenException;
import Marca.Marca;

import java.time.LocalDate;

public class EscaparateTemporal extends Escaparate{
        private int       diasApertura;
        private LocalDate dateToClose;
        private LocalDate dateActual;

        public EscaparateTemporal(String nombre, Marca marca, int diasApertura) {
            super( nombre, marca );
            this.diasApertura = diasApertura;
            this.dateToClose  = LocalDate.now().plusDays( diasApertura );
            this.dateActual   = LocalDate.now();
        }

        @Override
        public void sellProduct() {
            try {
                if ( this.dateActual.isAfter( this.dateToClose ) ) {
                    throw new ShowRoomNotOpenException();
                }
                super.sellProduct();
            } catch ( ShowRoomNotOpenException e1 ) {
                System.out.println( e1.getMessage() );
            }
        }

        public void sumarDias(int dias) {
            this.dateActual = this.dateActual.plusDays( dias );
        }
}
