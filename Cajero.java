//      PROYECTO DE CUENTA BANCARIA

import java.util.Scanner;

public class Cajero {

    public static void main(String[] args) {
        //Definición de variables:
        float saldoDisponible = 0;
        float valorOperacion = 0;
        boolean salir = false;
        int opcionUsuario;



        /*      CÓDIGO PRINCIPAL        */

        //Información del cliente
        System.out.println("""

                ****************************
                Cliente: Pedro Perez
                Tipo de cuenta: ahorros
                Saldo: %.2f
                ****************************
                """.formatted(saldoDisponible));
                

        Scanner ingresarOpcion = new Scanner(System.in);
        while(!salir){
            
            System.out.println("""

                    ** Escriba el número de opción deseado **

                    1. Consultar saldo
                    2. Retirar dinero
                    3. Depositar dinero
                    9. Salir

                    """);
            opcionUsuario = ingresarOpcion.nextInt();

            switch (opcionUsuario) {
                case 1:
                    System.out.println("\nSaldo disponible: %.2f".formatted(saldoDisponible));
                    break;
                
                case 2:
                    System.out.println("\nIngrese el valor a retirar");
                    valorOperacion = ingresarOpcion.nextFloat();
                    if (valorOperacion <= saldoDisponible){
                        saldoDisponible -= valorOperacion;
                        System.out.println("\nSaldo actualizado: %.2f".formatted(saldoDisponible));
                    } else{
                        System.out.println("\nSaldo insuficiente");
                    }
                    break;
                
                case 3:
                    System.out.println("\nIngrese el valor a depositar");
                    valorOperacion = ingresarOpcion.nextFloat();
                    saldoDisponible += valorOperacion;
                    System.out.println("\nSaldo actualizado: %.2f".formatted(saldoDisponible));
                    break;
            
                case 9:
                    salir = true;
                    System.out.println("\nSaliendo. Gracias por usar nuestros servicios");
                    break;

                default:
                    System.out.println("\nOpción no válida");
                    break;
            }
        }
    }
}