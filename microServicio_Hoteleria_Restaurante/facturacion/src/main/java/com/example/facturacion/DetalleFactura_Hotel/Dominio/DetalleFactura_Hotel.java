package com.example.facturacion.DetalleFactura_Hotel.Dominio;

import java.time.LocalDate;
import java.util.UUID;

public class DetalleFactura_Hotel {

    private final UUID id;

    private final LocalDate fecha;

    private UUID id_reservacion;

    public DetalleFactura_Hotel(UUID id, LocalDate fecha, UUID id_reservacion) {
        this.id = id;
        this.fecha = fecha;
        this.id_reservacion = id_reservacion;
    }
}
