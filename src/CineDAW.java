
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
                        System.out.println();
                        System.out.println("Distribución de la sala:");
                        System.out.println("      P A N T A L L A");
                        System.out.println("  1 2 3 4     5 6 7 8");
                        for(int fila = 'A'; fila <= 'F'; fila++ ){
                                System.out.print(Character.toString(fila) + " ");
                                for(int butaca = 1; butaca <= BUTACAS_POR_FILA; butaca++){
                                    int posicion = (fila - 'A') * BUTACAS_POR_FILA + (butaca - 1);
                                    System.out.print(sala.charAt(posicion) + " ");
                                    if (butaca == 4)
                                        System.out.print("    ");
                                }
                                System.out.println();
                        }
                        System.out.println("(- libre, X ocupada)");
                        System.out.println();
                        break;
                    case 2:
                        //si no encuentra ningún '-' la sala está llena.
                        if (sala.indexOf('-') == -1){
                            System.out.println("La sala está completa");
                        }
                        else {
                            System.out.println("Aquí puede comprar su entrada");
                            String fila = "";
                            boolean valida = false;
                            while(!valida){
                                System.out.println("Introduce una fila (A, B, C, D, E, F)");
                                fila = sc.nextLine();
                                fila = fila.trim();
                                fila = fila.toUpperCase();
                                if (fila.length() == 1 && fila.charAt(0) >= 'A' && fila.charAt(0) <= 'F'){
                                    valida = true;
                                }
                                else{
                                    System.out.println("Error: La fila debe ser A, B, C, D, E o F)");
                                }
                            }
                            boolean numeroValido = false;
                            int butaca = 0;
                            do{
                                try {
                                    System.out.println("Introduce el número de butaca (1-8):");
                                    butaca = sc.nextInt();
                                    sc.nextLine();

                                    if(butaca >= 1 && butaca <= 8){
                                        numeroValido = true;
                                    }
                                    else{
                                        System.out.println("El número de butaca tiene que estar entre 1 y 8");
                                    }
                                }
                                catch(InputMismatchException e){
                                    System.out.println("Opción no válida");
                                    sc.nextLine();
                                }
                            } while(!numeroValido);

                            int posicion = (fila.charAt(0) - 'A') * BUTACAS_POR_FILA + (butaca - 1);
                            final boolean OCUPADA = sala.charAt(posicion) == 'X';
                            final boolean LIBRE = sala.charAt(posicion) == '-';
                            if (OCUPADA){
                                System.out.println("La butaca " + fila + butaca + " está ocupada");
                            }
                            if (LIBRE){
                                sala = sala.substring(0, posicion) + 'X' + sala.substring(posicion + 1);
                                System.out.println("Has reservado la butaca " + fila + butaca);
                            }

                            int edad = 0;
                            boolean edadValida = false;
                            int precioTotal = 0;

                            while (!edadValida) {
                                System.out.println("Introduce tu edad: ");
                                try {
                                    edad = sc.nextInt();
                                    sc.nextLine();
                                    if (edad>=0&& edad<=120){
                                        edadValida = true;
                                    }
                                    else{
                                        System.out.println("La edad debe estar entre 0 y 120 años");
                                    }
                                }catch (InputMismatchException e){
                                    System.out.println("Introduce un número");
                                    sc.nextLine();
                                }
                            }

                            if (edad >= 0 && edad <= 120) {
                                if (edad < 12) {
                                    precioTotal = TARIFA_INTANTIL;
                                    System.out.println("Tarifa infantil");
                                } else if (edad >= 65) {
                                    precioTotal = TARIFA_SENIOR;
                                    System.out.println("Tarifa senior");
                                } else {
                                    precioTotal = TARIFA_GENERAL;
                                    System.out.println("Tarifa general");
                                }
                            }

                            int dia = 0;
                            System.out.println("Introduce el día de la semana(1 = lunes... 7 = domingo)");
                            dia = sc.nextInt();
                            sc.nextLine();
                            switch (dia){
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    System.out.println("Precio general");
                                    break;
                                case 3:
                                    System.out.println("Es el día del espectador tiene un descuento del 30%");
                                    int descuento = (int) Math.round(precioTotal * DESCUENTO/1000.0);
                                    precioTotal = precioTotal - descuento;
                                    break;
                                case 6:
                                case 7:
                                    System.out.println("Precio fin de semana");
                                    precioTotal = precioTotal + SUPLEMENTO;
                                    break;
                                default:
                                    System.out.println("Número de día no válido");
                            }
                            System.out.println("Precio: " + (precioTotal/ 100) + "," + (precioTotal % 100 < 10 ? "0" + precioTotal % 100 : precioTotal % 100) + " €");

                        }
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