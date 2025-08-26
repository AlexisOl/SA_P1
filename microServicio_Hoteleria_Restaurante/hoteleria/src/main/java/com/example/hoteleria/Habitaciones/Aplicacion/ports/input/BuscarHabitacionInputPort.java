package com.example.hoteleria.Habitaciones.Aplicacion.ports.input;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;

import java.util.UUID;

public interface BuscarHabitacionInputPort {

    Habitacion buscarHabitacion(UUID habitacion);
}
