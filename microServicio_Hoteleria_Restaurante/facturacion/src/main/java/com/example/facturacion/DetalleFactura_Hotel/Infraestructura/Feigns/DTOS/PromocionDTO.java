package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Feigns.DTOS;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromocionDTO {
    private UUID id;
    private int cantidad_descuento;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private UUID habitacion;

}
