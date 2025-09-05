package com.example.facturacion.DetalleFacturaRestaurante.Aplicacion.Service.CrearDetalleFactura;

import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Value
public class CrearDetlleFacturaDTO {

    private final UUID idCliente;
    private final LocalDate fecha;
    private final List<ListadoElementosDTO> listadoElementosDTO;
}
