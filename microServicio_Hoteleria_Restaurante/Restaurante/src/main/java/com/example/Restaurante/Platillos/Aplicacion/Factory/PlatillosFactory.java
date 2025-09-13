package com.example.Restaurante.Platillos.Aplicacion.Factory;

import com.example.Restaurante.Calificacion.Aplicacion.Ports.Output.promedioValorarionPlatilloOutputPort;
import com.example.Restaurante.Platillos.Dominio.Platillos;
import org.springframework.stereotype.Component;

@Component
public class PlatillosFactory {
    private final promedioValorarionPlatilloOutputPort promedio;



    public PlatillosFactory(promedioValorarionPlatilloOutputPort promedio){
        this.promedio = promedio;
    }


    public Platillos createPlatilloConPuntuacion(Platillos platillos) {
        double puntuacion = promedio.promedioValoracion(platillos.getId());


        return new Platillos(
                platillos.getId(),
                platillos.getNombre(),
                platillos.getPrecio(),
                platillos.getTipo(),
                platillos.getIdrestaurante(),
                puntuacion);
    }

}
