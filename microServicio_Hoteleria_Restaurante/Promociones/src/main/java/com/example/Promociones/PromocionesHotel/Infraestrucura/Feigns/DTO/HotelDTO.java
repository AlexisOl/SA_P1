package com.example.Promociones.PromocionesHotel.Infraestrucura.Feigns.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private Long id;

    private String nombre;

    private String direccion;

    private Long telefono;
}
