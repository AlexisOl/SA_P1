package com.example.facturacion.Factura_Restaurante.Dominio;

import com.example.facturacion.DetalleFactura_Hotel.Dominio.ObjetosDeValor.precioPorFacturaHotel;
import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class FacturaRestaurante {
    private UUID id;

    private  LocalDate fecha;

    private UUID id_Cliente;

    private PrecioFactura precioTotal;



    public FacturaRestaurante(UUID id, LocalDate fecha, UUID id_Cliente, PrecioFactura precioTotal) {
        this.id = id;
        this.fecha = fecha;
        this.id_Cliente = id_Cliente;
        this.precioTotal = precioTotal;
    }
    public FacturaRestaurante(UUID id, LocalDate fecha, UUID id_Cliente) {
        this.id = id;
        this.fecha = fecha;
        this.id_Cliente = id_Cliente;
        this.precioTotal = new PrecioFactura(0.0);
    }

    public FacturaRestaurante() {
    }
}
