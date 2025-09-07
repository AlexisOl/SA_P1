package com.example.hoteleria.Calificacion.Aplicacion.Service.CasosUso.CrearCalificacionCasoUso;

import com.example.hoteleria.Calificacion.Dominio.Puntuacion;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import lombok.Value;

import java.util.UUID;

@Value
public class CrearCalificacionDTO {
    private String comentario;
    private Double puntuacion;
    private UUID reservacion;
}
