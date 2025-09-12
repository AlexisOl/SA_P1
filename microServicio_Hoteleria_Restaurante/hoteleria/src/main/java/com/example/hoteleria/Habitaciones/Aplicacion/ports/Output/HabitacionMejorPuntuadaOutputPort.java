package com.example.hoteleria.Habitaciones.Aplicacion.ports.Output;

import com.example.hoteleria.Habitaciones.Infraestructura.Adapters.DTO.HabitacionConReservacionesDTO;

public interface HabitacionMejorPuntuadaOutputPort {
    Object habitacionMejorPuntuada(HabitacionConReservacionesDTO habitacion);

}
