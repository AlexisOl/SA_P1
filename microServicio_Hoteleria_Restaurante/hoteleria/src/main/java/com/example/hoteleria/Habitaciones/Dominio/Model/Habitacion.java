package com.example.hoteleria.Habitaciones.Dominio.Model;


import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {
    private UUID id;
    private Long numero_habitacion;
    private Long cantidad_camas;
    private Hotel hotel;
    private TipoHabitacion tipoHabitacion;
    private Double precio;
}
