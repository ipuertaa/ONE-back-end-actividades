package aluracursos.screenmatch.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import aluracursos.screenmatch.model.DatosEpisodio;
import aluracursos.screenmatch.model.DatosSerie;
import aluracursos.screenmatch.model.DatosTemporadas;
import aluracursos.screenmatch.model.Episodio;
import aluracursos.screenmatch.service.ConsumoAPI;
import aluracursos.screenmatch.service.ConvierteDatos;

public class Principal {

    private Scanner teclado = new Scanner(System.in);

    private ConsumoAPI consumoApi = new ConsumoAPI();

    private ConvierteDatos conversor = new ConvierteDatos();

    // crer constantes para la url

    private final String URL_BASE = "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=576e2847";

    public void muestraMenu() {

        // Busca datos generales de la serie
        System.out.println("Escribe el nombre de la serie a buscar: ");
        var nombreSerie = teclado.nextLine();

        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);

        var datos = conversor.obtenerDatos(json, DatosSerie.class);

        System.out.println(datos);

        // Busca datos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i < datos.totalDeTemporadas(); i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);

            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);

            temporadas.add(datosTemporadas);
        }

        // temporadas.forEach(System.out::println);

        // mostrar los titulos de los episodios para las temporadas

        // Iterar la lista de temporadas y almacena cada episodio en una lista
        // for (int i = 0; i < datos.totalDeTemporadas(); i++) {
        // List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();

        // //Iterar la lista de episodios para mostrar el título de cada uno
        // for (int j = 0; j < episodiosTemporada.size(); j++) {
        // System.out.println(episodiosTemporada.get(j).titulo());
        // }

        // }

        // simplificar el codigo anterior: funciones lambda
        // temporadas.forEach(t -> t.episodios().forEach(e ->
        // System.out.println(e.titulo())));

        // convertir todas lsa informaciones a la lista del tipo DatosEpisodio

        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        // Top 5 episodios
        // System.out.println("**TOP 5 EPISODIOS");
        // datosEpisodios.stream()
        // .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
        // .peek(e -> System.out.println("Primer filtro (N/A)" + e))
        // .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
        // .peek(e -> System.out.println("Ordena mayor a menor" + e))
        // .map(e -> e.titulo().toUpperCase())
        // .peek(e -> System.out.println("Tercer filtro - mayusculas"))
        // .limit(5)
        // .forEach(System.out::println);

        // Convertir datos a lista tipo Episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(), d)))
                .collect(Collectors.toList());

        // episodios.forEach(System.out::println);

        // Busqueda de episodios a partir de x año
        // System.out.println("Por favor indica el año");
        // var fecha = teclado.nextInt();
        // teclado.nextLine();

        // LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // episodios.stream()
        // .filter(e -> e.getFechaDeLanzamiento() != null &&
        // e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
        // .forEach(e -> System.out.println(
        // "Temporada " + e.getTemporada() +
        // " Episodio " + e.getTitulo() +
        // " Fecha de Lanzamiento " + e.getFechaDeLanzamiento().format(dtf)));

        // Busca episodios por partes de titulo
        // System.out.println("Ingrese el título del episodio que desea buscar: ");
        // var pedazoTitulo = teclado.nextLine();

        // Optional<Episodio> episodioBuscado = episodios.stream()
        // .filter(e ->
        // e.getTitulo().toUpperCase().contains(pedazoTitulo.toUpperCase()))
        // .findFirst();

        // if(episodioBuscado.isPresent()){
        // System.out.println(" Episodio encontrado ");
        // System.out.println("Información del episodio: " + episodioBuscado.get());
        // }else{
        // System.out.println("Episodio no encontrado");
        // }

        Map<Integer, Double> evaluacionesPorTemporada = episodios.stream()
        .filter(e -> e.getEvaluacion() > 0.0)
        .collect(Collectors.groupingBy(Episodio::getTemporada,
                Collectors.averagingDouble(Episodio::getEvaluacion)));

        System.out.println(evaluacionesPorTemporada);

        //estadisticas
        DoubleSummaryStatistics est = episodios.stream()
        .filter(e -> e.getEvaluacion() > 0.0)
        .collect(Collectors.summarizingDouble(Episodio::getEvaluacion));

        System.out.println("Media evaluaciones: " + est.getAverage());
        System.out.println("Episodio mejor evaluado: " + est.getMax());
        System.out.println("Episodio peor evaluado: " + est.getMin());



    }

}
