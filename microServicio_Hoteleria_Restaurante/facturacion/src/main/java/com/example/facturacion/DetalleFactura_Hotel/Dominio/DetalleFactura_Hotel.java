package com.example.facturacion.DetalleFactura_Hotel.Dominio;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.precioPorFacturaHotel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
public class DetalleFactura_Hotel {

    private  UUID id;

    private  LocalDate fecha;

    private UUID id_reservacion;

    private precioPorFacturaHotel precio;

    public DetalleFactura_Hotel(UUID id, LocalDate fecha, UUID id_reservacion, precioPorFacturaHotel precio) {
        this.id = id;
        this.fecha = fecha;
        this.id_reservacion = id_reservacion;
        this.precio = precio;
    }
}
