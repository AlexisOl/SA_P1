package com.example.hoteleria.Calificacion.Aplicacion.Ports.Output;

import com.example.hoteleria.Calificacion.Dominio.Calificacion;

import java.util.List;
import java.util.UUID;

public interface ListarCalificacionesOutputPort {
    List<Calificacion> listarCalificacionesPorHabitacion(UUID id);

}
