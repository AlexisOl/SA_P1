package com.example.hoteleria.Calificacion.Aplicacion.Ports.Input;

import com.example.hoteleria.Calificacion.Dominio.Calificacion;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;

import java.util.List;
import java.util.UUID;

public interface ListarCalificacionesInputPort {

    List<Calificacion> listarCalificacionesPorHabitacion(UUID id);
}
