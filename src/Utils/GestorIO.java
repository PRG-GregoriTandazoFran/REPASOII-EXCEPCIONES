package Utils;

import java.util.Scanner;

public class GestorIO {
    private static Scanner scanner;

    public static int pedirEntero(String mensaje) {
        do {
            System.out.println( mensaje );
            if ( scanner.hasNextInt() ) {
                return scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println( "Error! Tipo de dato no válido" );
        } while ( true );
    }

    public static String pedirCadena(String mensaje) {
        System.out.println( mensaje );
        return scanner.nextLine();
    }
}
