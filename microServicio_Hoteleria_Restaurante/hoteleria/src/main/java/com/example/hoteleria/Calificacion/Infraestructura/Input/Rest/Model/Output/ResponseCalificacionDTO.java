package com.example.hoteleria.Calificacion.Infraestructura.Input.Rest.Model.Output;

import com.example.hoteleria.Calificacion.Dominio.Puntuacion;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import lombok.Value;

import java.util.UUID;

@Value
public class ResponseCalificacionDTO {
    private UUID id;
    private String comentario;
    private Double puntuacion;
    private Reservacion reservacion;
}
