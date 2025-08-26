package com.example.hoteleria.Habitaciones.Aplicacion.ports.Output;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;

import java.util.UUID;

public interface BuscarHabitacionOutputPort {

    Habitacion  buscarHabitacion(UUID habitacion);
}
