import java.util.Random;
import java.util.Scanner;

public class Aleatorio {

    public static void main(String[] args) {

        //Programa para crear un juego de adivinanza

        System.out.println("*** Juego de adivinación ***");

        /* Generación del número aleatorio
         * Clase: Random    Método: nextInt(int bound)
         * Devuelve un número entre [0, bound)
         */
        
        int NUMERO_ALEATORIO = new Random().nextInt(101);
        System.out.println(NUMERO_ALEATORIO);
        boolean acierto = false;
        int intentos = 0;
        int numeroUsuario;
        
        while ((!acierto) && (intentos < 5)) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Ingrese un número del 1 al 100");
            numeroUsuario = teclado.nextInt();
            intentos++;

            if (numeroUsuario == NUMERO_ALEATORIO){
                System.out.println("¡Ganaste!");
                acierto = true;
            }
        }
        System.out.println("Número de intentos: " + intentos);
        System.out.println("Final del juego");

    }
}