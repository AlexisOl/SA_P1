package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Feigns.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromocionRestauranteDTO {
    private UUID id;
    private int cantidad_descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private UUID platillo;

}
