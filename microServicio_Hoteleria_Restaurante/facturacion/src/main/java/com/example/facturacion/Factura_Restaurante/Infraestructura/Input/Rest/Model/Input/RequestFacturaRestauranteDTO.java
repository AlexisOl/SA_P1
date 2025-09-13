package com.example.facturacion.Factura_Restaurante.Infraestructura.Input.Rest.Model.Input;

import com.example.facturacion.Factura_Restaurante.Dominio.ObjetosValor.PrecioFactura;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class RequestFacturaRestauranteDTO {
    private UUID id;

    private LocalDate fecha;

    private UUID id_Cliente;

    private Double precioTotal;

}
