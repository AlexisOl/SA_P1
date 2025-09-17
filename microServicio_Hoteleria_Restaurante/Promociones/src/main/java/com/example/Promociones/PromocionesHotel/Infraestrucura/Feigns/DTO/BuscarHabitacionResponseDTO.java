package com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO;

import lombok.*;

import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuscarHabitacionResponseDTO {
    private UUID id;
    private Long numero_habitacion;
    private Long cantidad_camas;
    private HotelDTO hotel;
    private TipoHabitacion tipoHabitacion;
    private Double precio;
    private Double promedio_valoracion;
}
