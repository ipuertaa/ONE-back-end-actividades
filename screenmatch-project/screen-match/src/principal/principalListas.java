package principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import screenmatchClases.Pelicula;
import screenmatchClases.Serie;
import screenmatchClases.Titulo;


public class principalListas {

    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(6);
        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.evalua(10);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeBruno);
        lista.add(lost);

        //iteracion de la lista

        for (Titulo item : lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3){
                System.out.println(pelicula.getClasificacion());
            }
            
            
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Antonio Bandera");
        listaDeArtistas.add("Ernesto Perez");
        System.out.println(listaDeArtistas);

        //Ordenar la lista
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada" + listaDeArtistas);

        //Ordenar las peliculas según el nombre:
        //Para eso debo hacer que la clase Titulo sea comparable
        Collections.sort(lista);
        System.out.println(lista);

        //Ordenar la lista por fecha
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println(lista);

    }
}