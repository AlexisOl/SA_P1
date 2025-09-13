package com.example.facturacion.Factura_Restaurante.Infraestructura.Input.Rest.Model.Output;

import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;
@Value
public class ResponseFacturaRestauranteDTO {
    private UUID id;

    private LocalDate fecha;

    private UUID id_Cliente;

    private PrecioFactura precioTotal;

}
