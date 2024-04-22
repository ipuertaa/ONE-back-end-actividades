package principal;
import java.util.ArrayList;

import screenmatchCalculos.CalculadoraDeTiempo;
import screenmatchCalculos.FiltroRecomendacion;
import screenmatchClases.Episodio;
import screenmatchClases.Pelicula;
import screenmatchClases.Serie;


public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        
        //Se puede eliminar la siguiente línea al hacer uso del constructor
        //miPelicula.setNombre("Encanto");
        miPelicula.setDuracionEnMinutos(180);
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMediaEvaluaciones());


        Serie lost = new Serie("Lost", 2000);
        lost.muestraFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracion de la série: " + lost.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.setDuracionEnMinutos(200);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluido(miPelicula);
        calculadora.incluido(otraPelicula);
        calculadora.incluido(lost);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);
        filtro.filtra(episodio);


        /*Pelicula() indica el tipo de objeto que se está instanciando
         *Pelicula  hace referencia al tipo de dato que es peliculaDeBruno
        */

        //Pelicula peliculaDeBruno = new Pelicula();

        //Es posible reescribir la línea anterior (var infiere automáticamente el tipo de dato)
        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.setDuracionEnMinutos(180);


        //Creacion de un array: ArrayList<tipo de objeto que estaŕa en la lista>
        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(peliculaDeBruno);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera película es: " + listaDePeliculas.get(0).getNombre());

        //Imprimir todo el arrayList
        System.out.println(listaDePeliculas);

        //Prueba de la sobreescritura del toString
        System.out.println("toString de la pelicula:  " + listaDePeliculas.get(0).toString());

        
        






    }
}