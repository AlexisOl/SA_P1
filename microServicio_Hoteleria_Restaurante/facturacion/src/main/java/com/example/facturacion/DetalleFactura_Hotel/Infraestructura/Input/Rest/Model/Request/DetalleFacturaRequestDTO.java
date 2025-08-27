package com.example.facturacion.DetalleFactura_Hotel.Infraestructura.Input.Rest.Model.Request;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class DetalleFacturaRequestDTO {
    private final LocalDate fecha;
    private UUID id_reservacion;
}
