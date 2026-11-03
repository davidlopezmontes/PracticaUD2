
/** Descripción Programa: Programa CineDAW: taquilla de una sala de cine. @author david.lopezmontes  */


public class CineDAW {
    static void main(String[] args) {
        final int FILAS = 6;
        final int BUTACAS_POR_FILA = 8;
        final int TOTAL_BUTACAS = 48;
        final int TARIFA_INTANTIL = 500;
        final int TARIFA_SENIOR = 600;
        final int TARIFA_GENERAL = 850;
        final int SUPLEMENTO = 150;
        final int DESCUENTO = 300;

        //Muestra los importes con formato de euros (420 se muestra como 4,20 €): calcula los euros con / y los céntimos
        //con %, y usa el operador ternario para añadir un 0 delante de los céntimos cuando haga falta.
        System.out.println("suplemento: " + (SUPLEMENTO/100) + "," + (SUPLEMENTO%100 < 10 ? "0" + SUPLEMENTO%100 : SUPLEMENTO%100));

        String sala = "";
        int contador = 0;

        //construir string añadiendo - con bucle for
        for(int i = 0; i<TOTAL_BUTACAS; i++){
            sala = sala.concat("-");
            contador += 1; //para comprobar si son 48
        }
        System.out.println("butacas: " + sala + " contador: " + contador);

        //mostrar menú
        System.out.println("===== CineDAW =====");
        System.out.println("1. Ver sala");
        System.out.println("2. Comprar entrada");
        System.out.println("3. Estadísticas");
        System.out.println("0. Salir");
        System.out.println("Elige una opción:");


        //int posicion = (fila - 'A') * BUTACAS_POR_FILA + (butaca - 1);
        //final boolean OCUPADA = sala.charAt(posicion) == 'X';
        //final boolean LIBRE = sala.charAt(posicion) == '-';
        //sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1);

        // Posición de una butaca dentro del String: A1 -> 0, A2 -> 1 ... F8 -> 47
        //int posicion = (fila - 'A') * BUTACAS_POR_FILA + (butaca - 1);
        //boolean ocupada = sala.charAt(posicion) == 'X'; // consultar
        //sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1); // ocupar

    }
}
