package aluracursos.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConvierteDatos implements IConvierteDatos{
    //mapear los valores que vienen de la API
    private ObjectMapper objectMapper = new ObjectMapper();

    //metodo para convertir todo tipo de datos --> datos genericos
    //implementando la clase IConvierteDatos
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        //convertir json a la clase generica

        try{
            return objectMapper.readValue(json, clase);
            //el metodo readValue puede devolver una excepcion que hay que tratar
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
