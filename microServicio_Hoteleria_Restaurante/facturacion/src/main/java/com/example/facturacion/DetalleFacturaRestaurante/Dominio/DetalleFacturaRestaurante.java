package com.example.facturacion.DetalleFacturaRestaurante.Dominio;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DetalleFacturaRestaurante {
    private UUID id;
    private UUID idplatillo;
    private Long cantidad;
    private Double precioParcial;
    private FacturaRestaurante facturaRestaurante;

    private DetalleFacturaRestaurante(UUID id, UUID idplatillo, Long cantidad, Double precioParcial, FacturaRestaurante facturaRestaurante) {
        this.id = id;
        this.idplatillo = idplatillo;
        this.cantidad = cantidad;
        this.precioParcial = precioParcial;
        this.facturaRestaurante = facturaRestaurante;
    }




}
