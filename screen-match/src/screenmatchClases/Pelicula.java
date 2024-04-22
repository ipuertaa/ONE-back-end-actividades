package screenmatchClases;
import screenmatchCalculos.Clasificable;

//Definicion de la clase pelicula
public class Pelicula extends Titulo implements Clasificable {
    private String director;

    //definicion del constructor
    /* Debido a que Pelicula hereda de Titulo, y Titulo está
     * usando un constructor que no es el default, el constructor
     * de Pelicula debe llamar al constructor padre (Titulo)
     */
    public Pelicula(String nombre , int fechaDeLanzamiento){
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) calculaMediaEvaluaciones() / 2;
    }

    //Sobreescribir el método toString
    @Override
    public String toString() {
        return "Pelicula: " + this.getNombre() + " (" + getFechaDeLanzamiento() + ")";
    }
}
