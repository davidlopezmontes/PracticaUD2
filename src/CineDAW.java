
/** Descripción Programa: Programa CineDAW: taquilla de una sala de cine. @author david.lopezmontes  */


public class CineDAW {
    static void main(String[] args) {
        final int FILAS = 6;
        final int BUTACAS_POR_FILA = 8;
        final boolean LIBRE;
        String sala;

        for(int i = 0; i<48; i++){
            sala.replace(' ','_');
        }

        int posicion = (fila - 'A') * BUTACAS_POR_FILA + (butaca - 1);
        final boolean OCUPADA = sala.charAt(posicion) == 'X';
        final boolean LIBRE = sala.charAt(posicion) == 'Y';
        sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1);

        // Posición de una butaca dentro del String: A1 -> 0, A2 -> 1 ... F8 -> 47
        int posicion = (fila - 'A') * BUTACAS_POR_FILA + (butaca - 1);
        boolean ocupada = sala.charAt(posicion) == 'X'; // consultar
        sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1); // ocupar

    }
}
