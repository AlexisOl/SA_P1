package com.example.hoteleria.Habitaciones.Aplicacion.ports.Output;

import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.DTO.HabitacionConReservacionesDTO;

public interface HabitacionConMasAlojamientosOutputPort {
    Object habitacionConMasAlojamientos(HabitacionConReservacionesDTO habitacion);

}
