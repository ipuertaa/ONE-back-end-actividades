package aluracursos.screenmatch.service;

public interface IConvierteDatos {

    //obtener datos genéricos sobre los títulos
    //Tipos de datos genericos --> <T> T
    <T> T obtenerDatos(String json, Class <T> clase);

}
