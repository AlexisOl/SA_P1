package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.DTO;

import com.example.hoteleria.Habitaciones.Dominio.Model.Habitacion;
import com.example.hoteleria.Rerservacion.Dominio.Reservacion;
import lombok.Value;

import java.util.List;
@Value
public class HabitacionConReservacionesDTO {
    private Habitacion habitacion;
    private List<Reservacion> reservaciones;

    public HabitacionConReservacionesDTO(Habitacion habitacion, List<Reservacion> reservaciones) {
        this.habitacion = habitacion;
        this.reservaciones = reservaciones;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public List<Reservacion> getReservaciones() {
        return reservaciones;
    }
}
