package com.example.facturacion.Factura_Restaurante.Aplicacion.Ports.Output;

import com.example.facturacion.Factura_Restaurante.Dominio.FacturaRestaurante;

public interface CrearFacturaRestauranteOutputPort {

    FacturaRestaurante crearFacturaRestaurante(FacturaRestaurante facturaRestaurante);
}
