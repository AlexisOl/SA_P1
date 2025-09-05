package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Service.CrearDetalleFactura;

import lombok.Value;

import java.util.UUID;

@Value
public class ListadoElementosDTO {
    private final UUID idPlatillo;
    private final Long cantidad;
}
