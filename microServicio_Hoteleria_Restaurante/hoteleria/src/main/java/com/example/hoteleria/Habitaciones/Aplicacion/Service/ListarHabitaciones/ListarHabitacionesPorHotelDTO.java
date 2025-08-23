package com.example.hoteleria.Habitaciones.Aplicacion.Service.ListarHabitaciones;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Value
@Getter
@Setter
public class ListarHabitacionesPorHotelDTO {

    @NotNull
    private Long id_hotel;
}
