package com.example.hoteleria.Habitaciones.Dominio.Model;


import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
public class Habitacion {
    private UUID id;
    private Long numero_habitacion;
    private Long cantidad_camas;
    private Hotel hotel;
    private TipoHabitacion tipoHabitacion;
    private Double precio;
    private Double promedio_valoracion;


    public Habitacion(UUID id, Long numero_habitacion, Long cantidad_camas, Hotel hotel, TipoHabitacion tipoHabitacion, Double precio) {
        this.id = id;
        this.numero_habitacion = numero_habitacion;
        this.cantidad_camas = cantidad_camas;
        this.hotel = hotel;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.promedio_valoracion = 0.0;
    }

    public Habitacion(UUID id, Long numero_habitacion, Long cantidad_camas, Hotel hotel, TipoHabitacion tipoHabitacion, Double precio, Double promedio_valoracion) {
        this.id = id;
        this.numero_habitacion = numero_habitacion;
        this.cantidad_camas = cantidad_camas;
        this.hotel = hotel;
        this.tipoHabitacion = tipoHabitacion;
        this.precio = precio;
        this.promedio_valoracion = promedio_valoracion;
    }


}
