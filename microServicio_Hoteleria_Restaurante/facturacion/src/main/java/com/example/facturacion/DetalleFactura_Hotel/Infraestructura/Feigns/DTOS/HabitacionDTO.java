package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS;

import lombok.*;

import java.util.UUID;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabitacionDTO {
    private UUID id;
    private Long numero_habitacion;
    private Long cantidad_camas;
    private HotelDTO hotel;
    private TipoHabitacion tipoHabitacion;
    private Double precio;
}
