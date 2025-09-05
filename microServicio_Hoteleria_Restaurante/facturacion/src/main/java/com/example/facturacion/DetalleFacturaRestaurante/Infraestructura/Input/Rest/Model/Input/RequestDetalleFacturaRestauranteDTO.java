package com.example.facturacion.DetalleFacturaRestaurante.Infraestructura.Input.Rest.Model.Input;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import lombok.Value;

import java.util.UUID;

@Value
public class RequestDetalleFacturaRestauranteDTO {
    private UUID idplatillo;
    private Long cantidad;
    private Double precioParcial;
    private UUID facturaRestaurante;
}
