
/** Descripción Programa: Programa CineDAW: taquilla de una sala de cine. @author david.lopezmontes  */

import java.util.InputMismatchException;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        //Muestra los importes con formato de euros (420 se muestra como 4,20 €): calcula los euros con / y los céntimos
        //con %, y usa el operador ternario para añadir un 0 delante de los céntimos cuando haga falta.
        System.out.println("suplemento: " + (SUPLEMENTO / 100) + "," + (SUPLEMENTO % 100 < 10 ? "0" + SUPLEMENTO % 100 : SUPLEMENTO % 100));

        String sala = "";
        int contador = 0;

        //construir string añadiendo - con bucle for
        for (int i = 0; i < TOTAL_BUTACAS; i++) {
            sala = sala.concat("-");
            contador += 1; //para comprobar si son 48
        }
        System.out.println("butacas: " + sala + " contador: " + contador);

        //int posicion = (fila - 'A') * BUTACAS_POR_FILA + (butaca - 1);
        //final boolean OCUPADA = sala.charAt(posicion) == 'X';
        //final boolean LIBRE = sala.charAt(posicion) == '-';
        //sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1);

        // Posición de una butaca dentro del String: A1 -> 0, A2 -> 1 ... F8 -> 47
        //int posicion = (fila - 'A') * BUTACAS_POR_FILA + (butaca - 1);
        //boolean ocupada = sala.charAt(posicion) == 'X'; // consultar
        //sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1); // ocupar


        //mostrar menú
        String menu = """
                ===== CineDAW =====
                1. Ver sala
                2. Comprar entrada
                3. Estadísticas
                0. Salir
                Elige una opción:
                """;

        //bucle do-while para el menú
        //parse int (no se pq)
        do {
            System.out.print(menu);
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Esta es la sala:");

                        break;
                    case 2:
                        System.out.println("Aquí puede comprar su entrada");
                        break;
                    case 3:
                        System.out.println("Estadísticas:");
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida");
                sc.nextLine();
            }
        }while (!salir);

        sc.close();

    }
}