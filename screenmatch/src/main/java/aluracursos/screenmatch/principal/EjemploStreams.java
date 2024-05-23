package aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemploStreams {

    public void muestraEjemplo(){
        
        List<String> nombres = Arrays.asList("Isbael", "Roberta", "Carlos", "Jimena");

        nombres.stream().sorted().limit(2)
        .filter(n -> n.startsWith("C"))
        .map(n -> n.toUpperCase())
        .forEach(System.out::println);

        
    }

}
