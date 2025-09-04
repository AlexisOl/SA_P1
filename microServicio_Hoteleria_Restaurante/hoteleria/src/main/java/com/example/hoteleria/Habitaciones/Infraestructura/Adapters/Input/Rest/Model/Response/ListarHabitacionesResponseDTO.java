package com.example.hoteleria.Habitaciones.Infraestructura.Adapters.Input.Rest.Model.Response;

import com.example.hoteleria.Habitaciones.Dominio.Model.TipoHabitacion;
import com.example.hoteleria.Hotel.Dominio.Models.Hotel;
import com.example.hoteleria.Rerservacion.Dominio.TipoReservacion;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListarHabitacionesResponseDTO {
    private UUID id;
    private Long numero_habitacion;
    private Long cantidad_camas;
    private Hotel hotel;
    private TipoHabitacion tipoHabitacion;
    private Double precio;
    private Double promedio_valoracion;
}
