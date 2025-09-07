package com.example.hoteleria.Calificacion.Dominio;

import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class Calificacion {
    private UUID id;
    private String comentario;
    private Double puntuacion;
    private Reservacion reservacion;

    
    public Calificacion(UUID id, String comentario, Double puntuacion, Reservacion reservacion) {
        this.id = id;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.reservacion = reservacion;
    }
}
