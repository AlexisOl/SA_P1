package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest.Model.Output;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import lombok.Value;

import java.util.UUID;

@Value
public class ResponseDetalleFacturaRestauranteDTO {

    private UUID id;
    private UUID idplatillo;
    private Long cantidad;
    private Double precioParcial;
    private FacturaRestaurante facturaRestaurante;
}
