package aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Para indicar que solo mapee los datos indicados
@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosSerie(@JsonAlias("Title") String titulo,
                        @JsonAlias("totalSeasons") Integer totalDeTemporadas,
                        @JsonAlias("imdbRating") String evaluacion ) {

}
