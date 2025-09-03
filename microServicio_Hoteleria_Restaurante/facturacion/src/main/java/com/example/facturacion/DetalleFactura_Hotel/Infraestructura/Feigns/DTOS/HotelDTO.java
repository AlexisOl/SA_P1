package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS;

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
