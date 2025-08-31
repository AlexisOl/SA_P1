package com.example.facturacion.DetalleFactura_Hotel.Aplicacion.Service.GenerarFactura;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;


@Data
public class GenerarFacturaDTO {
    // aasmbos elementos de facturas

    @NotNull
    private LocalDate fecha;
    @NotNull
    private UUID id_reservacion;
    @NotNull
    private double precio;


}
