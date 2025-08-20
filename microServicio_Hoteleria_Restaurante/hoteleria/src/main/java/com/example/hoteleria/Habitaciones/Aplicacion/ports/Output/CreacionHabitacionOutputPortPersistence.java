package com.example.hoteleria.Habitaciones.Aplicacion.ports.Output;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;

public interface CreacionHabitacionOutputPortPersistence {
    Habitacion crearHabitacion(Habitacion habitacion);
}
