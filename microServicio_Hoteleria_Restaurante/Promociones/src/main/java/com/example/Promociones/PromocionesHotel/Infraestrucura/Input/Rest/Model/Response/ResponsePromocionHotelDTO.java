package com.example.Promociones.PromocionesHotel.Infraestrucura.Input.Rest.Model.Response;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePromocionHotelDTO {
    private UUID id;
    private int cantidad_descuento;
    private LocalDate fecha_inicio;
    private LocalDate fecha_final;
    private UUID habitacion;
}
